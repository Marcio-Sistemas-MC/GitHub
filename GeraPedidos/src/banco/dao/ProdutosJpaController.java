/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import banco.novo.Itvendas;
import banco.novo.Produtos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Paulo
 */
public class ProdutosJpaController implements Serializable {

    public ProdutosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtos produtos) {
        if (produtos.getItvendasCollection() == null) {
            produtos.setItvendasCollection(new ArrayList<Itvendas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Itvendas> attachedItvendasCollection = new ArrayList<Itvendas>();
            for (Itvendas itvendasCollectionItvendasToAttach : produtos.getItvendasCollection()) {
                itvendasCollectionItvendasToAttach = em.getReference(itvendasCollectionItvendasToAttach.getClass(), itvendasCollectionItvendasToAttach.getItvendasPK());
                attachedItvendasCollection.add(itvendasCollectionItvendasToAttach);
            }
            produtos.setItvendasCollection(attachedItvendasCollection);
            em.persist(produtos);
            for (Itvendas itvendasCollectionItvendas : produtos.getItvendasCollection()) {
                Produtos oldCodproOfItvendasCollectionItvendas = itvendasCollectionItvendas.getCodpro();
                itvendasCollectionItvendas.setCodpro(produtos);
                itvendasCollectionItvendas = em.merge(itvendasCollectionItvendas);
                if (oldCodproOfItvendasCollectionItvendas != null) {
                    oldCodproOfItvendasCollectionItvendas.getItvendasCollection().remove(itvendasCollectionItvendas);
                    oldCodproOfItvendasCollectionItvendas = em.merge(oldCodproOfItvendasCollectionItvendas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtos produtos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtos persistentProdutos = em.find(Produtos.class, produtos.getCodpro());
            Collection<Itvendas> itvendasCollectionOld = persistentProdutos.getItvendasCollection();
            Collection<Itvendas> itvendasCollectionNew = produtos.getItvendasCollection();
            Collection<Itvendas> attachedItvendasCollectionNew = new ArrayList<Itvendas>();
            for (Itvendas itvendasCollectionNewItvendasToAttach : itvendasCollectionNew) {
                itvendasCollectionNewItvendasToAttach = em.getReference(itvendasCollectionNewItvendasToAttach.getClass(), itvendasCollectionNewItvendasToAttach.getItvendasPK());
                attachedItvendasCollectionNew.add(itvendasCollectionNewItvendasToAttach);
            }
            itvendasCollectionNew = attachedItvendasCollectionNew;
            produtos.setItvendasCollection(itvendasCollectionNew);
            produtos = em.merge(produtos);
            for (Itvendas itvendasCollectionOldItvendas : itvendasCollectionOld) {
                if (!itvendasCollectionNew.contains(itvendasCollectionOldItvendas)) {
                    itvendasCollectionOldItvendas.setCodpro(null);
                    itvendasCollectionOldItvendas = em.merge(itvendasCollectionOldItvendas);
                }
            }
            for (Itvendas itvendasCollectionNewItvendas : itvendasCollectionNew) {
                if (!itvendasCollectionOld.contains(itvendasCollectionNewItvendas)) {
                    Produtos oldCodproOfItvendasCollectionNewItvendas = itvendasCollectionNewItvendas.getCodpro();
                    itvendasCollectionNewItvendas.setCodpro(produtos);
                    itvendasCollectionNewItvendas = em.merge(itvendasCollectionNewItvendas);
                    if (oldCodproOfItvendasCollectionNewItvendas != null && !oldCodproOfItvendasCollectionNewItvendas.equals(produtos)) {
                        oldCodproOfItvendasCollectionNewItvendas.getItvendasCollection().remove(itvendasCollectionNewItvendas);
                        oldCodproOfItvendasCollectionNewItvendas = em.merge(oldCodproOfItvendasCollectionNewItvendas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = produtos.getCodpro();
                if (findProdutos(id) == null) {
                    throw new NonexistentEntityException("The produtos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtos produtos;
            try {
                produtos = em.getReference(Produtos.class, id);
                produtos.getCodpro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtos with id " + id + " no longer exists.", enfe);
            }
            Collection<Itvendas> itvendasCollection = produtos.getItvendasCollection();
            for (Itvendas itvendasCollectionItvendas : itvendasCollection) {
                itvendasCollectionItvendas.setCodpro(null);
                itvendasCollectionItvendas = em.merge(itvendasCollectionItvendas);
            }
            em.remove(produtos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtos> findProdutosEntities() {
        return findProdutosEntities(true, -1, -1);
    }

    public List<Produtos> findProdutosEntities(int maxResults, int firstResult) {
        return findProdutosEntities(false, maxResults, firstResult);
    }

    private List<Produtos> findProdutosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Produtos findProdutos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtos.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtos> rt = cq.from(Produtos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

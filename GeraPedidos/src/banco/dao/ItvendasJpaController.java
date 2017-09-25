/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.dao.exceptions.NonexistentEntityException;
import banco.dao.exceptions.PreexistingEntityException;
import banco.novo.Itvendas;
import banco.novo.ItvendasPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import banco.novo.Produtos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Paulo
 */
public class ItvendasJpaController implements Serializable {

    public ItvendasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itvendas itvendas) throws PreexistingEntityException, Exception {
        if (itvendas.getItvendasPK() == null) {
            itvendas.setItvendasPK(new ItvendasPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtos codpro = itvendas.getCodpro();
            if (codpro != null) {
                codpro = em.getReference(codpro.getClass(), codpro.getCodpro());
                itvendas.setCodpro(codpro);
            }
            em.persist(itvendas);
            if (codpro != null) {
                codpro.getItvendasCollection().add(itvendas);
                codpro = em.merge(codpro);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItvendas(itvendas.getItvendasPK()) != null) {
                throw new PreexistingEntityException("Itvendas " + itvendas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Itvendas itvendas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itvendas persistentItvendas = em.find(Itvendas.class, itvendas.getItvendasPK());
            Produtos codproOld = persistentItvendas.getCodpro();
            Produtos codproNew = itvendas.getCodpro();
            if (codproNew != null) {
                codproNew = em.getReference(codproNew.getClass(), codproNew.getCodpro());
                itvendas.setCodpro(codproNew);
            }
            itvendas = em.merge(itvendas);
            if (codproOld != null && !codproOld.equals(codproNew)) {
                codproOld.getItvendasCollection().remove(itvendas);
                codproOld = em.merge(codproOld);
            }
            if (codproNew != null && !codproNew.equals(codproOld)) {
                codproNew.getItvendasCollection().add(itvendas);
                codproNew = em.merge(codproNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ItvendasPK id = itvendas.getItvendasPK();
                if (findItvendas(id) == null) {
                    throw new NonexistentEntityException("The itvendas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ItvendasPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itvendas itvendas;
            try {
                itvendas = em.getReference(Itvendas.class, id);
                itvendas.getItvendasPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itvendas with id " + id + " no longer exists.", enfe);
            }
            Produtos codpro = itvendas.getCodpro();
            if (codpro != null) {
                codpro.getItvendasCollection().remove(itvendas);
                codpro = em.merge(codpro);
            }
            em.remove(itvendas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Itvendas> findItvendasEntities() {
        return findItvendasEntities(true, -1, -1);
    }

    public List<Itvendas> findItvendasEntities(int maxResults, int firstResult) {
        return findItvendasEntities(false, maxResults, firstResult);
    }

    private List<Itvendas> findItvendasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itvendas.class));
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

    public Itvendas findItvendas(ItvendasPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Itvendas.class, id);
        } finally {
            em.close();
        }
    }

    public int getItvendasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itvendas> rt = cq.from(Itvendas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

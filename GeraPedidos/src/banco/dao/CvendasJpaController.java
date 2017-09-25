/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.dao.exceptions.NonexistentEntityException;
import banco.dao.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import banco.novo.Clientes;
import banco.novo.Cvendas;
import banco.novo.CvendasPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Paulo
 */
public class CvendasJpaController implements Serializable {

    public CvendasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cvendas cvendas) throws PreexistingEntityException, Exception {
        if (cvendas.getCvendasPK() == null) {
            cvendas.setCvendasPK(new CvendasPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes codCliente = cvendas.getCodCliente();
            if (codCliente != null) {
                codCliente = em.getReference(codCliente.getClass(), codCliente.getCodpessoa());
                cvendas.setCodCliente(codCliente);
            }
            em.persist(cvendas);
            if (codCliente != null) {
                codCliente.getCvendasCollection().add(cvendas);
                codCliente = em.merge(codCliente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCvendas(cvendas.getCvendasPK()) != null) {
                throw new PreexistingEntityException("Cvendas " + cvendas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cvendas cvendas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cvendas persistentCvendas = em.find(Cvendas.class, cvendas.getCvendasPK());
            Clientes codClienteOld = persistentCvendas.getCodCliente();
            Clientes codClienteNew = cvendas.getCodCliente();
            if (codClienteNew != null) {
                codClienteNew = em.getReference(codClienteNew.getClass(), codClienteNew.getCodpessoa());
                cvendas.setCodCliente(codClienteNew);
            }
            cvendas = em.merge(cvendas);
            if (codClienteOld != null && !codClienteOld.equals(codClienteNew)) {
                codClienteOld.getCvendasCollection().remove(cvendas);
                codClienteOld = em.merge(codClienteOld);
            }
            if (codClienteNew != null && !codClienteNew.equals(codClienteOld)) {
                codClienteNew.getCvendasCollection().add(cvendas);
                codClienteNew = em.merge(codClienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                CvendasPK id = cvendas.getCvendasPK();
                if (findCvendas(id) == null) {
                    throw new NonexistentEntityException("The cvendas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(CvendasPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cvendas cvendas;
            try {
                cvendas = em.getReference(Cvendas.class, id);
                cvendas.getCvendasPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cvendas with id " + id + " no longer exists.", enfe);
            }
            Clientes codCliente = cvendas.getCodCliente();
            if (codCliente != null) {
                codCliente.getCvendasCollection().remove(cvendas);
                codCliente = em.merge(codCliente);
            }
            em.remove(cvendas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cvendas> findCvendasEntities() {
        return findCvendasEntities(true, -1, -1);
    }

    public List<Cvendas> findCvendasEntities(int maxResults, int firstResult) {
        return findCvendasEntities(false, maxResults, firstResult);
    }

    private List<Cvendas> findCvendasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cvendas.class));
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

    public Cvendas findCvendas(CvendasPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cvendas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCvendasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cvendas> rt = cq.from(Cvendas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

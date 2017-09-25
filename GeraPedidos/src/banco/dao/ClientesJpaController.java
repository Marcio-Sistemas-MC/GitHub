/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.dao.exceptions.NonexistentEntityException;
import banco.novo.Clientes;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import banco.novo.Cvendas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Paulo
 */
public class ClientesJpaController implements Serializable {

    public ClientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clientes clientes) {
        if (clientes.getCvendasCollection() == null) {
            clientes.setCvendasCollection(new ArrayList<Cvendas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cvendas> attachedCvendasCollection = new ArrayList<Cvendas>();
            for (Cvendas cvendasCollectionCvendasToAttach : clientes.getCvendasCollection()) {
                cvendasCollectionCvendasToAttach = em.getReference(cvendasCollectionCvendasToAttach.getClass(), cvendasCollectionCvendasToAttach.getCvendasPK());
                attachedCvendasCollection.add(cvendasCollectionCvendasToAttach);
            }
            clientes.setCvendasCollection(attachedCvendasCollection);
            em.persist(clientes);
            for (Cvendas cvendasCollectionCvendas : clientes.getCvendasCollection()) {
                Clientes oldCodClienteOfCvendasCollectionCvendas = cvendasCollectionCvendas.getCodCliente();
                cvendasCollectionCvendas.setCodCliente(clientes);
                cvendasCollectionCvendas = em.merge(cvendasCollectionCvendas);
                if (oldCodClienteOfCvendasCollectionCvendas != null) {
                    oldCodClienteOfCvendasCollectionCvendas.getCvendasCollection().remove(cvendasCollectionCvendas);
                    oldCodClienteOfCvendasCollectionCvendas = em.merge(oldCodClienteOfCvendasCollectionCvendas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clientes clientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes persistentClientes = em.find(Clientes.class, clientes.getCodpessoa());
            Collection<Cvendas> cvendasCollectionOld = persistentClientes.getCvendasCollection();
            Collection<Cvendas> cvendasCollectionNew = clientes.getCvendasCollection();
            Collection<Cvendas> attachedCvendasCollectionNew = new ArrayList<Cvendas>();
            for (Cvendas cvendasCollectionNewCvendasToAttach : cvendasCollectionNew) {
                cvendasCollectionNewCvendasToAttach = em.getReference(cvendasCollectionNewCvendasToAttach.getClass(), cvendasCollectionNewCvendasToAttach.getCvendasPK());
                attachedCvendasCollectionNew.add(cvendasCollectionNewCvendasToAttach);
            }
            cvendasCollectionNew = attachedCvendasCollectionNew;
            clientes.setCvendasCollection(cvendasCollectionNew);
            clientes = em.merge(clientes);
            for (Cvendas cvendasCollectionOldCvendas : cvendasCollectionOld) {
                if (!cvendasCollectionNew.contains(cvendasCollectionOldCvendas)) {
                    cvendasCollectionOldCvendas.setCodCliente(null);
                    cvendasCollectionOldCvendas = em.merge(cvendasCollectionOldCvendas);
                }
            }
            for (Cvendas cvendasCollectionNewCvendas : cvendasCollectionNew) {
                if (!cvendasCollectionOld.contains(cvendasCollectionNewCvendas)) {
                    Clientes oldCodClienteOfCvendasCollectionNewCvendas = cvendasCollectionNewCvendas.getCodCliente();
                    cvendasCollectionNewCvendas.setCodCliente(clientes);
                    cvendasCollectionNewCvendas = em.merge(cvendasCollectionNewCvendas);
                    if (oldCodClienteOfCvendasCollectionNewCvendas != null && !oldCodClienteOfCvendasCollectionNewCvendas.equals(clientes)) {
                        oldCodClienteOfCvendasCollectionNewCvendas.getCvendasCollection().remove(cvendasCollectionNewCvendas);
                        oldCodClienteOfCvendasCollectionNewCvendas = em.merge(oldCodClienteOfCvendasCollectionNewCvendas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = clientes.getCodpessoa();
                if (findClientes(id) == null) {
                    throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.");
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
            Clientes clientes;
            try {
                clientes = em.getReference(Clientes.class, id);
                clientes.getCodpessoa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.", enfe);
            }
            Collection<Cvendas> cvendasCollection = clientes.getCvendasCollection();
            for (Cvendas cvendasCollectionCvendas : cvendasCollection) {
                cvendasCollectionCvendas.setCodCliente(null);
                cvendasCollectionCvendas = em.merge(cvendasCollectionCvendas);
            }
            em.remove(clientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clientes> findClientesEntities() {
        return findClientesEntities(true, -1, -1);
    }

    public List<Clientes> findClientesEntities(int maxResults, int firstResult) {
        return findClientesEntities(false, maxResults, firstResult);
    }

    private List<Clientes> findClientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clientes.class));
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

    public Clientes findClientes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clientes> rt = cq.from(Clientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

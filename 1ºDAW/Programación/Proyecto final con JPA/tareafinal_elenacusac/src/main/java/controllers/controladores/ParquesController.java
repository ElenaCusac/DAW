package controllers.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.modelos.entidades.Parques;

public class ParquesController {
    private final EntityManagerFactory emf;

    public ParquesController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Parques parque) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(parque);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al crear el parque", ex);
        } finally {
            em.close();
        }
    }

    public Parques findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Parques.class, id);
        } finally {
            em.close();
        }
    }

    public List<Parques> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Parques p", Parques.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Parques> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Parques.findByNombre", Parques.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Parques> findByCiudad(String ciudad) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Parques.findByCiudad", Parques.class)
                    .setParameter("ciudad", ciudad)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Parques> findByDireccion(String direccion) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Parques.findByDireccion", Parques.class)
                    .setParameter("direccion", direccion)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Parques parque) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(parque);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar el parque", ex);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Parques parque = em.find(Parques.class, id);
            if (parque != null) {
                em.remove(parque);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar el parque", ex);
        } finally {
            em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("delete from parques").executeUpdate();
            em.createNativeQuery("alter table parques AUTO_INCREMENT = 1").executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar todos los parques", ex);
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}

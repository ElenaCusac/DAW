package controllers.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.modelos.entidades.Zonas;

public class ZonasController {
    private final EntityManagerFactory emf;

    public ZonasController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Zonas zona) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(zona);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al crear la zona", ex);
        } finally {
            em.close();
        }
    }

    public Zonas findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Zonas.class, id);
        } finally {
            em.close();
        }
    }

    public List<Zonas> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT z FROM Zonas z", Zonas.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Zonas> findByCodZona(Integer codZona) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Zonas.findByCodZona", Zonas.class)
                    .setParameter("codZona", codZona)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Zonas> findByCodParque(java.lang.Integer codParque) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Zonas.findByCodParque", Zonas.class)
                    .setParameter("codParque", codParque)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Zonas> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Zonas.findByNombre", Zonas.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Zonas zona) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(zona);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar la zona", ex);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Zonas zona = em.find(Zonas.class, id);
            if (zona != null) {
                em.remove(zona);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar la zona", ex);
        } finally {
            em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("delete from zonas").executeUpdate();
            em.createNativeQuery("alter table zonas AUTO_INCREMENT = 1").executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar todas las zonas", ex);
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

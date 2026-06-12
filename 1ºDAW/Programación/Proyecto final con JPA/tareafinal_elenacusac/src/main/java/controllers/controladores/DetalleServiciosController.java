package controllers.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.modelos.entidades.DetalleServicios;

public class DetalleServiciosController {
    private final EntityManagerFactory emf;

    public DetalleServiciosController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleServicios detalleServicios) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(detalleServicios);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al crear el detalle de servicio", ex);
        } finally {
            em.close();
        }
    }

    public DetalleServicios findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleServicios.class, id);
        } finally {
            em.close();
        }
    }

    public List<DetalleServicios> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT d FROM DetalleServicios d", DetalleServicios.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<DetalleServicios> findByCodCliente(Integer codCliente) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("DetalleServicios.findByCodCliente", DetalleServicios.class)
                    .setParameter("codCliente", codCliente)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<DetalleServicios> findByCodServicio(Integer codServicio) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("DetalleServicios.findByCodServicio", DetalleServicios.class)
                    .setParameter("codServicio", codServicio)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<DetalleServicios> findByCantidad(Integer cantidad) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("DetalleServicios.findByCantidad", DetalleServicios.class)
                    .setParameter("cantidad", cantidad)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void update(DetalleServicios detalleServicios) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(detalleServicios);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar el detalle de servicio", ex);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            DetalleServicios detalle = em.find(DetalleServicios.class, id);
            if (detalle != null) {
                em.remove(detalle);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar el detalle de servicio", ex);
        } finally {
            em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("delete from DetalleServicios").executeUpdate();
            em.createNativeQuery("alter table DetalleServicios AUTO_INCREMENT = 1").executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar todos los detalles de servicios", ex);
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

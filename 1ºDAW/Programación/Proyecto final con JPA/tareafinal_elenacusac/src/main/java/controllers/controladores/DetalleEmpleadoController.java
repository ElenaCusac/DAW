package controllers.controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.modelos.entidades.DetalleEmpleado;

public class DetalleEmpleadoController {

    private final EntityManagerFactory emf;

    public DetalleEmpleadoController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleEmpleado detalleEmpleado) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(detalleEmpleado);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al crear los detalles del empleado", ex);
        } finally {
            em.close();
        }
    }

    public DetalleEmpleado findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleEmpleado.class, id);
        } finally {
            em.close();
        }
    }

    public List<DetalleEmpleado> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT d FROM DetalleEmpleado d", DetalleEmpleado.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<DetalleEmpleado> findByCodEmpleado(Integer codEmpleado) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("DetalleEmpleado.findByCodEmpleado", DetalleEmpleado.class)
                    .setParameter("codEmpleado", codEmpleado)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<DetalleEmpleado> findByCodParque(Integer codParque) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("DetalleEmpleado.findByCodParque", DetalleEmpleado.class)
                    .setParameter("codParque", codParque)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<DetalleEmpleado> findByFechaInicio(Date fechaInicio) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("DetalleEmpleado.findByFechaInicio", DetalleEmpleado.class)
                    .setParameter("fechaInicio", fechaInicio)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void update(DetalleEmpleado detalleEmpleado) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(detalleEmpleado);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar los detalles del empleado", ex);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            DetalleEmpleado detalle = em.find(DetalleEmpleado.class, id);
            if (detalle != null) {
                em.remove(detalle);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar los detalles del empleado", ex);
        } finally {
            em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("delete from detalleEmpleado").executeUpdate();
            em.createNativeQuery("alter table detalleEmpleado AUTO_INCREMENT = 1").executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar todos los detalles de los empleados", ex);
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

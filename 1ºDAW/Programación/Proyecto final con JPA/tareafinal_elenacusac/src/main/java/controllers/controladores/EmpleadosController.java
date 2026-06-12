package controllers.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.modelos.entidades.Empleados;

public class EmpleadosController {
    private final EntityManagerFactory emf;

    public EmpleadosController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleados empleado) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(empleado);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al crear el empleado", ex);
        } finally {
            em.close();
        }
    }

    public Empleados findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    public List<Empleados> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Empleados e", Empleados.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Empleados> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Empleados.findByNombre", Empleados.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Empleados> findByDni(String dni) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Empleados.findByDni", Empleados.class)
                    .setParameter("dni", dni)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Empleados> findByEmail(String email) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Empleados.findByEmail", Empleados.class)
                    .setParameter("email", email)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Empleados> findByRol(String rol) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Empleados.findByRol", Empleados.class)
                    .setParameter("rol", rol)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Empleados> findByTelefono(String telefono) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Empleados.findByTelefono", Empleados.class)
                    .setParameter("telefono", telefono)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Empleados empleado) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(empleado);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar el empleado", ex);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Empleados empleado = em.find(Empleados.class, id);
            if (empleado != null) {
                em.remove(empleado);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar el empleado", ex);
        } finally {
            em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("delete from empleados").executeUpdate();
            em.createNativeQuery("alter table empleados AUTO_INCREMENT = 1").executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar todos los empleados", ex);
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

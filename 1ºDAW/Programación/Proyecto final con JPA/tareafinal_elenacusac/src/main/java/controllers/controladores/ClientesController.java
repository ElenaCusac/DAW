package controllers.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.modelos.entidades.Clientes;

public class ClientesController {

    private final EntityManagerFactory emf;

    public ClientesController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clientes cliente) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(cliente);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al crear el cliente", ex);
        } finally {
            em.close();
        }
    }

    public Clientes findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clientes.class, id);
        } finally {
            em.close();
        }
    }

    public List<Clientes> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Clientes c", Clientes.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Clientes> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Clientes.findByNombre", Clientes.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Clientes> findByDni(String dni) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Clientes.findByDni", Clientes.class)
                    .setParameter("dni", dni)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Clientes> findByEmail(String email) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Clientes.findByEmail", Clientes.class)
                    .setParameter("email", email)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Clientes> findByTelefono(String telefono) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Clientes.findByTelefono", Clientes.class)
                    .setParameter("telefono", telefono)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Clientes cliente) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(cliente);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar el cliente", ex);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Clientes cliente = em.find(Clientes.class, id);
            if (cliente != null) {
                em.remove(cliente);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar el cliente", ex);
        } finally {
            em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("delete from clientes").executeUpdate();
            em.createNativeQuery("alter table clientes AUTO_INCREMENT = 1").executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar todos los clientes", ex);
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

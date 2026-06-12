package controllers.controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.modelos.entidades.Entradas;

public class EntradasController {
    private final EntityManagerFactory emf;

    public EntradasController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Entradas entrada) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entrada);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al crear la entrada", ex);
        } finally {
            em.close();
        }
    }

    public Entradas findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entradas.class, id);
        } finally {
            em.close();
        }
    }

    public List<Entradas> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Entradas e", Entradas.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Entradas> findByFecha(Date fecha) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Entradas.findByFecha", Entradas.class)
                    .setParameter("fecha", fecha)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Entradas> findByTipoEntrada(String tipoEntrada) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Entradas.findByTipoEntrada", Entradas.class)
                    .setParameter("tipoEntrada", tipoEntrada)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Entradas> findByCodParque(Integer codParque) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Entradas.findByCodParque", Entradas.class)
                    .setParameter("codParque", codParque)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Entradas> findByCodCliente(Integer codCliente) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Entradas.findByCodCliente", Entradas.class)
                    .setParameter("codCliente", codCliente)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Entradas entrada) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entrada);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar la entrada", ex);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Entradas entrada = em.find(Entradas.class, id);
            if (entrada != null) {
                em.remove(entrada);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar la entrada", ex);
        } finally {
            em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("delete from entradas").executeUpdate();
            em.createNativeQuery("alter table entradas AUTO_INCREMENT = 1").executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar todas las entradas", ex);
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

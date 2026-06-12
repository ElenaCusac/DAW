package controllers.controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.modelos.entidades.Atracciones;

public class AtraccionesController {
    private final EntityManagerFactory emf;

    public AtraccionesController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Atracciones atraccion) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(atraccion);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al crear la atracción", ex);
        } finally {
            em.close();
        }
    }

    public Atracciones findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Atracciones.class, id);
        } finally {
            em.close();
        }
    }

    public List<Atracciones> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Atracciones a", Atracciones.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Atracciones> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Atracciones.findByNombre", Atracciones.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Atracciones> findByFechaInstalacion(Date fechaInstalacion) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Atracciones.findByFechaInstalacion", Atracciones.class)
                    .setParameter("fechaInstalacion", fechaInstalacion)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Atracciones> findByCapacidadMaxima(long capacidadMaxima) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Atracciones.findByCapacidadMaxima", Atracciones.class)
                    .setParameter("capacidadMaxima", capacidadMaxima)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Atracciones> findByEdadMinima(Integer edadMinima) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Atracciones.findByEdadMinima", Atracciones.class)
                    .setParameter("edadMinima", edadMinima)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Atracciones> findByCodParque(Integer codParque) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Atracciones.findByCodParque", Atracciones.class)
                    .setParameter("codParque", codParque)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Atracciones> findByCodParqueAndCodZona(Integer codParque, Integer codZona) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Atracciones.findByCodParqueAndCodZona", Atracciones.class)
                    .setParameter("codParque", codParque)
                    .setParameter("codZona", codZona)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Atracciones atraccion) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(atraccion);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar la atracción", ex);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Atracciones atraccion = em.find(Atracciones.class, id);
            if (atraccion != null) {
                em.remove(atraccion);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar la atracción", ex);
        } finally {
            em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("delete from atracciones").executeUpdate();
            em.createNativeQuery("alter table atracciones AUTO_INCREMENT = 1").executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar todas las atracciones", ex);
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

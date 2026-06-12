package controllers.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.modelos.entidades.Oficinas;

public class OficinasController {

    private final EntityManagerFactory emf;

    public OficinasController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Oficinas oficina) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(oficina);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al crear la oficina", ex);
        } finally {
            em.close();
        }
    }

    public Oficinas findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Oficinas.class, id);
        } finally {
            em.close();
        }
    }

    public List<Oficinas> findAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT o FROM Oficinas o", Oficinas.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Oficinas> findByDireccion(String direccion) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Oficinas.findByDireccion", Oficinas.class)
                    .setParameter("direccion", direccion)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Oficinas> findByTelefono(String telefono) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Oficinas.findByTelefono", Oficinas.class)
                    .setParameter("telefono", telefono)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Oficinas> findByCodParque(Integer codParque) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Oficinas.findByCodParque", Oficinas.class)
                    .setParameter("codParque", codParque)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Oficinas oficina) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(oficina);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar la oficina", ex);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Oficinas oficina = em.find(Oficinas.class, id);
            if (oficina != null) {
                em.remove(oficina);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar la oficina", ex);
        } finally {
            em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.createNativeQuery("delete from oficinas").executeUpdate();
            em.createNativeQuery("alter table oficinas AUTO_INCREMENT = 1").executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al eliminar todas las oficinas", ex);
        } finally {
            em.close();
        }
    }

    public boolean existeOficinaParaParque(int codParque) {

        EntityManager em = getEntityManager();

        try {

            Long total = em.createQuery(
                    "select count(o) from Oficinas o where o.codParque = :parque",
                    Long.class)
                    .setParameter("parque", codParque)
                    .getSingleResult();

            return total > 0;

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

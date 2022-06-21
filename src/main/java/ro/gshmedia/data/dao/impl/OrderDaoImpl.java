package ro.gshmedia.data.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import ro.gshmedia.data.dao.OrderDao;
import ro.gshmedia.data.model.Order;

public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    EntityManager entityManager;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ro.gshmedia.persistance");

    @Override
    public Order addOrder(Order order) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        em.persist(order);
        em.getTransaction().commit();
        return order;
    }


    @Override
    public Order updateOrder(Order order) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        return order;
    }

    @Override
    public Order getOrder(int id) {

        EntityManager em = getEntityManager();
        Order order = em.find(Order.class, id);
        em.detach(order);
        return order;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}

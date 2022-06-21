package ro.gshmedia.data.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import ro.gshmedia.data.dao.ProductDao;
import ro.gshmedia.data.model.Product;


public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    EntityManager entityManager;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ro.gshmedia.persistance");

    @Override
    public Product addProduct(Product product) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        em.persist(product);
        em.getTransaction().commit();
        return product;
    }


    @Override
    public Product updateProduct(Product product) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        em.persist(product);
        em.getTransaction().commit();
        return product;
    }


    @Override
    public Product getProduct(int id) {
        EntityManager em = getEntityManager();
        Product product = em.find(Product.class, id);
        em.detach(product);
        return product;

    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();


    }
}

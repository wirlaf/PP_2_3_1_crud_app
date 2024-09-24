package web.dao;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void add(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public User get(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    @Override
    public void update(Long id, User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<User> listUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<User> users = em.createQuery("from User").getResultList();
        em.close();
        return users;
    }
}

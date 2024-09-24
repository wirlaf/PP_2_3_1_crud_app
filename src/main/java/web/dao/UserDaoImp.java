package web.dao;

import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

//    @Autowired
//    private SessionFactory sessionFactory;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }
    @Override
    public void add(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

//    @Override
//    public User get(Long id) {
//        return sessionFactory.getCurrentSession().get(User.class, id);
//    }
    @Override
    public User get(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

//    @Override
//    public void update(Long id, User user) {
//        User userToBeUpdated = get(id);
//        userToBeUpdated.setFirstName(user.getFirstName());
//        userToBeUpdated.setLastName(user.getLastName());
//        userToBeUpdated.setEmail(user.getEmail());
//        sessionFactory.getCurrentSession().update(userToBeUpdated);
//    }
    @Override
    public void update(Long id, User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }
//    @Override
//    public void delete(Long id) {
//        User user = sessionFactory.getCurrentSession().get(User.class, id);
//        sessionFactory.getCurrentSession().delete(user);
//    }
    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> listUsers() {
//        String hql = "from User";
//        return sessionFactory.getCurrentSession().createQuery(hql).list();
//    }
    @Override
    public List<User> listUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<User> users = em.createQuery("from User").getResultList();
        em.close();
        return users;
    }
}

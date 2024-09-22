package web.dao;

import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User get(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void update(Long id, User user) {
        User userToBeUpdated = get(id);
        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setEmail(user.getEmail());
        sessionFactory.getCurrentSession().update(userToBeUpdated);
    }

    @Override
    public void delete(Long id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        String hql = "from User";
        return sessionFactory.getCurrentSession().createQuery(hql).list();
    }
}

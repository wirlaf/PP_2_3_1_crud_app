package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    User get(Long id);

    void update(Long id, User user);

    void delete(Long id);

    List<User> listUsers();
}

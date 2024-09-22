package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    User get(Long id);

    void update(Long id, User user);

    void delete(Long id);

    List<User> listUsers();


}

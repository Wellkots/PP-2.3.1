package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user);
    User getById(Long id);
    void update(Long id, User user);
    void delete(Long id);
}


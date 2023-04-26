package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public User getUserById(int id);

    public void addUser(User user);

    public User updateUser(User user, int id);

    public void deleteUser(int id);
}

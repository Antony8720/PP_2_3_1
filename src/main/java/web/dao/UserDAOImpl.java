package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return  entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User updateUser(User user, int id) {
        User userUpd = getUserById(id);
        userUpd.setId(user.getId());
        userUpd.setName(Objects.requireNonNull(user.getName(), "Name can`t be null"));
        userUpd.setSurname(Objects.requireNonNull(user.getSurname(), "Surname can`t be null"));
        return entityManager.merge(userUpd);
    }

    @Override
    public void deleteUser(int id) {
        User userDel = getUserById(id);
        entityManager.remove(userDel);
    }
}

package DataAccessObjects.abstracts;

import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    List<User> users = new ArrayList<>();

    void addToDb(User user);

    List<User> getUsers();

    User getUser(int index);

    void loginRequest();
}

package DataAccessObjects.concretes;

import DataAccessObjects.abstracts.UserDao;
import Entities.concretes.User;

import java.util.List;

public class HibernateUserDao implements UserDao {

    @Override
    public void addToDb(User user) {
        users.add(user);
        System.out.println("Kullanıcı Hibernate ile veritabanına eklendi : " + user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(int index) {
        return users.get(index);
    }

    @Override
    public void loginRequest() {
        System.out.println("Başarıyla giriş yapıldı.");
    }

}

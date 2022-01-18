import Business.abstracts.UserService;
import Business.concretes.UserManager;
import Core.Adapters.GoogleRegisterAdapter;
import Core.Validate.MailValidation;
import DataAccessObjects.concretes.HibernateUserDao;
import Entities.concretes.User;

public class Main {

    public static void main(String[] args) throws Exception {

        UserService userService = new UserManager(new HibernateUserDao(), new MailValidation(), new GoogleRegisterAdapter());
        User user = new User("Hasan Can", "Özbek", "hasancanozbek@gmail.com", "123132");
        userService.register(user);
        userService.login("hasancanozbek@gmail.com", "123132");
        userService.registerWithThirdParty(user);
    }
}



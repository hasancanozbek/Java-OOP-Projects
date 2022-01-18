package Business.concretes;

import Business.abstracts.UserService;
import Core.Adapters.ThirdPartyRegisterService;
import Core.Regex.MailRegex;
import Core.Validate.ValidationService;
import DataAccessObjects.abstracts.UserDao;
import Entities.concretes.User;

public class UserManager implements UserService {
    private UserDao userDao;
    private ValidationService validationService;
    private ThirdPartyRegisterService thirdPartyRegisterService;

    public UserManager(UserDao userDao, ValidationService validationService, ThirdPartyRegisterService thirdPartyRegisterService) {
        this.userDao = userDao;
        this.validationService = validationService;
        this.thirdPartyRegisterService = thirdPartyRegisterService;
    }

    @Override
    public void register(User user) {
        if (MailRegex.ifValidMail(user.getEmail()) && user.getPassword().length() >= 6 &&
                user.getFirstName().length() >= 2 && user.getLastName().length() >= 2 &&
                !(userDao.getUsers().contains(user))) {
            userDao.addToDb(user);
//            validationService.sendValidationCode(user.getEmail());
            validationService.mailValidation(validationService.sendValidationCode(user.getEmail()));

        } else {
            System.out.println("Kullanıcı kayıt edilemedi.");
        }
    }

    @Override
    public void registerWithThirdParty(User user) {
        thirdPartyRegisterService.registerWithThirdPartyApp(user);
        userDao.getUsers().add(user);

    }

    @Override
    public void login(String email, String password) {
        for (int i = 0; i < userDao.getUsers().size(); i++) {
            if (email.equals(userDao.getUser(i).getEmail()) && password.equals(userDao.getUser(i).getPassword())) {
                userDao.loginRequest();
                return;
            }
        }
        System.out.println("Mail adresiniz veya şifreniz yanlış.");
    }
}
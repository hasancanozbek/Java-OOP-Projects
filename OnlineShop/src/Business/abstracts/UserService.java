package Business.abstracts;

import Entities.concretes.User;

public interface UserService {
    void register(User user);

    void registerWithThirdParty(User user);

    void login(String email, String password);
}

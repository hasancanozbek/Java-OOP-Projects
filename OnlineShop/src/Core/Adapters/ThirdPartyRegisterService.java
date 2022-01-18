package Core.Adapters;

import Entities.concretes.User;

public interface ThirdPartyRegisterService {
    void registerWithThirdPartyApp(User user);
}

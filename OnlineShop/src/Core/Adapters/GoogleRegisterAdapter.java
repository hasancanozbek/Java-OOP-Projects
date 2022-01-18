package Core.Adapters;

import Core.ThirdPartyRegister.GoogleAccountRegister;
import Entities.concretes.User;

public class GoogleRegisterAdapter implements ThirdPartyRegisterService{
    @Override
    public void registerWithThirdPartyApp(User user) {
        GoogleAccountRegister googleAccountRegister = new GoogleAccountRegister();
        googleAccountRegister.googleAccountRegister();
        System.out.println("Google hesabınız ile giriş yaptınız.");
    }
}

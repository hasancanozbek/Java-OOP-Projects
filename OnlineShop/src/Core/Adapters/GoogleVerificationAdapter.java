package Core.Adapters;

import Core.MicroServicesForRegistration.GoogleRegistration.GoogleRegistration;

public class GoogleVerificationAdapter implements ThirdPartyRegistrationService{
    @Override
    public void registeredWithThirdPartyAccount() {
        GoogleRegistration googleRegistration = new GoogleRegistration();
        googleRegistration.registerWithGoogle();
    }
}

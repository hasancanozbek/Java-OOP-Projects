package Core.Validate;

public interface ValidationService {
    public String sendValidationCode(String email);

    public boolean mailValidation(String activationCode);
}


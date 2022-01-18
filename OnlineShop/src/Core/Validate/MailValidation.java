package Core.Validate;

import java.util.Scanner;

public class MailValidation implements ValidationService {

    Scanner scanner = new Scanner(System.in);
    @Override
    public String sendValidationCode(String email) {
        System.out.println(email + " adresine doğrulama linki gönderildi.");
        System.out.print("Lütfen doğrulama kodunu girin : ");
        String activationCode = scanner.nextLine();
        return activationCode;
    }

    @Override
    public boolean mailValidation(String activationCode) {
        if (activationCode.equals("123")) {
            System.out.println("Mail adresiniz doğrulandı.");
            return true;
        }
        System.out.println("Mail adresiniz doğrulanamadı!");
        return false;
    }
}

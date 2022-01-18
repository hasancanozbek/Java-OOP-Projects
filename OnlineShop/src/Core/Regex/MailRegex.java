package Core.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailRegex {
    public static boolean ifValidMail(String email){
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}

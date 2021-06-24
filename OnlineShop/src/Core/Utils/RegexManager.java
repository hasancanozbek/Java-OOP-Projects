package Core.Utils;

import java.util.regex.Pattern;

public class RegexManager {

    public static boolean isValidFormat(String email){
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        return  pattern.matcher(email).find();
    }
}

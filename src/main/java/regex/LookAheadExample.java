package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookAheadExample {
    public static boolean checkPassword(String password) {
        String regex = "(?=.*\\d)";
        //String regex = "(?=.*\\d).*"; //this one would work with matches()
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        boolean isMatch = matcher.find();
        return isMatch;
    }

    public static boolean checkUsername(String username) {
        Pattern p = Pattern.compile("(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%])");
        Matcher matcher = p.matcher(username);
        return matcher.find();
    }

    public static void main(String[] args) {
        String password = "Passw05rd@";
        System.out.println(checkPassword(password));

        String username = "Ba#jj6";
        System.out.println(checkUsername(username));
    }
}

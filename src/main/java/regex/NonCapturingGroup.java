package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// The example of using a non-capturing group using ?:
public class NonCapturingGroup {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\w+)(?:\\s+)(\\d+)");
        Matcher matcher = p.matcher("Hao 2024");
        if (matcher.matches()) {
            System.out.println(matcher.group(1)); // captured letters
            System.out.println(matcher.group(2)); // captured digits
        }
    }
}

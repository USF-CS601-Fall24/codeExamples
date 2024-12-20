package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovingLettersUsingGroups {
    public static void main(String[] args) {
        String word = "string";
        Pattern p = Pattern.compile("([^aeiou]*)(.*)");
        Matcher m = p.matcher(word);
        if (m.matches()) {
            System.out.println(m.group(2) + m.group(1));
        }

    }
}

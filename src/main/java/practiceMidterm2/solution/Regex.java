package practiceMidterm2.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void extractBookInfo(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while((line  = reader.readLine()) != null)
                sb.append(line + System.lineSeparator());

            Pattern pattern = Pattern.compile("<p>(.*?)</p>", Pattern.DOTALL);
            // Pattern.DOTALL makes . match any character including a newline character
            Matcher matcher = pattern.matcher(sb.toString());
            while(matcher.find()) {
                System.out.println(matcher.group(1));
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        extractBookInfo("input/books.html");
    }
}

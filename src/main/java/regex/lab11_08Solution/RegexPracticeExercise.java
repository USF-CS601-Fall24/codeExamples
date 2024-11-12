package regex.lab11_08Solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Lab 11-08: regex exercises solution.
public class RegexPracticeExercise {

    /**
     * Take a string that contains letters followed by numbers, separated by space, for instance:
     * "A25 K150 Z228 D4679 J67"
     *  Returns a string that shifts numbers to the front of the letters. For example above,
     *  it should be: 25A 150K 228Z 4679D 67J
     *  Must use Pattern, Matcher, groups.
     * @param s input string
     * @return res result
     */
    public static String moveNumbersToFront(String s) {
        Pattern p = Pattern.compile("([A-Z])([\\d]{2,4})(\\s)?");
        Matcher matcher = p.matcher(s);
        StringBuffer res = new StringBuffer();
        while (matcher.find()) {
            res.append(matcher.group(2));
            res.append(matcher.group(1));
            if (matcher.group(3) != null)
                res.append(matcher.group(3));
        }
        return res.toString();
    }

    /**
     * Open a given input file in the following format (see input.txt):
     Janet Smith 401-987-3456
     Hao Chen	415-416-6825
     Katherine Tucto 510a-901-123
     Priya Ram 625-891-1467
     Alex van Damm 800-256-8368

     Extract valid phone numbers / last names and output to the output file in the following format:
     Smith: 401-987-3456
     Chen: 415-416-6825
     Ram: 625-891-1467
     van Damm: 800-256-8368
     * @param inputFilename
     * @param output
     */
    public static void extractValidPhoneAndLastName(String inputFilename, String output) {
        try(BufferedReader br = new BufferedReader(new FileReader(inputFilename)); PrintWriter pw = new PrintWriter(output)) {
            String line;
            while ((line = br.readLine()) != null) {
                // Janet Smith 401-987-3456
                Pattern p = Pattern.compile("([A-Z][a-zA-Z]*)\\s([a-zA-Z]+([ '-][a-zA-Z]+)*)\\s([1-9]\\d{2}-[1-9]\\d{2}-\\d{4})");
                Matcher matcher = p.matcher(line);
                StringBuffer res = new StringBuffer();
                if (matcher.matches()) {
                    pw.println(matcher.group(2) + ": " + matcher.group(4));
                    pw.flush();
                }

            }
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(moveNumbersToFront("A25 K150 Z228 D4679 J67"));
        extractValidPhoneAndLastName("input/input.txt", "output.txt");
    }
}

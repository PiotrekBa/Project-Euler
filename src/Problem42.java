import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem42 {

    /*
    Problem 42 - Coded triangle numbers

    The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
    so the first ten triangle numbers are:

        1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

    By converting each letter in a word to a number corresponding to
    its alphabetical position and adding these values we form a word
    value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
    If the word value is a triangle number then we shall call the word a triangle word.

    Using words.txt (right click and 'Save Link/Target As...'),
    a 16K text file containing nearly two-thousand common English
    words, how many are triangle words?
     */


    public static void main(String[] args) {

        Path path = Paths.get("p042-words.txt");

        String words = "";

        try {
            for (String line : Files.readAllLines(path)) {
                words = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list = Arrays.asList(words.split(","));

        int counter = 0;

        for (String s : list) {
            if (isTriangle(s.replaceAll("\"", ""))) {
                counter++;
            }
        }

        System.out.println(counter);
    }

    public static boolean isTriangle(String s) {
        char[] c = s.toCharArray();

        int sum = 0;

        for (int i = 0; i < c.length; i++) {
            sum += (int) c[i] - 64;
        }

        int t = 0;

        for (int i = 1; t <= sum; i++) {
            t = i * (i + 1) / 2;
            if (sum == t) {
                return true;
            }
        }
        return false;
    }
}

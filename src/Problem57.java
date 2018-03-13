import java.math.BigInteger;
import java.util.Arrays;

public class Problem57 {

    /*
    Problem 57 - Square root convergents

    It is possible to show that the square root of two can be expressed as an infinite continued fraction.

    √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

    By expanding this for the first four iterations, we get:

        1 + 1/2 = 3/2 = 1.5
        1 + 1/(2 + 1/2) = 7/5 = 1.4
        1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
        1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

    The next three expansions are 99/70, 239/169, and 577/408,
    but the eighth expansion, 1393/985, is the first example
    where the number of digits in the numerator exceeds the
    number of digits in the denominator.

    In the first one-thousand expansions,
    how many fractions contain a numerator with more digits
    than denominator?
    */

    public static void main(String[] args) {

        BigInteger[] expansion = {BigInteger.valueOf(3),
                BigInteger.valueOf(2)};

        int counter = 0;

        for (int i = 2; i <= 1000; i++) {
            BigInteger denominator = expansion[0].add(expansion[1]);
            BigInteger numerator = denominator.add(expansion[1]);

            expansion[0] = numerator;
            expansion[1] = denominator;

            int numeratorLength = numerator.toString().length();
            int denominatorLength = denominator.toString().length();

            if (numeratorLength > denominatorLength) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}

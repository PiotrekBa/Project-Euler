import java.math.BigInteger;
import java.util.ArrayList;

public class Problem25 {

    /*
    Problem 25 - 1000-digit Fibonacci number

    The Fibonacci sequence is defined by the recurrence relation:

    Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
    Hence the first 12 terms will be:

    F1 = 1
    F2 = 1
    F3 = 2
    F4 = 3
    F5 = 5
    F6 = 8
    F7 = 13
    F8 = 21
    F9 = 34
    F10 = 55
    F11 = 89
    F12 = 144
    The 12th term, F12, is the first term to contain three digits.

    What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
     */

    public static void main(String[] args) {
        ArrayList<BigInteger> fibb = new ArrayList<>();

        fibb.add(BigInteger.valueOf(1));
        fibb.add(BigInteger.valueOf(1));
        int terms = 2;
        BigInteger tempAns = null;
        do {
            tempAns = fibb.get(terms-1).add(fibb.get(terms-2));
            fibb.add(tempAns);
            terms++;
        } while (tempAns.toString().length() < 1_000);

        System.out.println(terms);
    }
}

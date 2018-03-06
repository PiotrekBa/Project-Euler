public class Problem6 {

    /*
    Problem 6 - Sum square difference

    The sum of the squares of the first ten natural numbers is,

    12 + 22 + ... + 102 = 385
    The square of the sum of the first ten natural numbers is,

    (1 + 2 + ... + 10)2 = 552 = 3025

    Hence the difference between the sum of the squares of the first
    ten natural numbers and the square of the sum is 3025 − 385 = 2640.

    Find the difference between the sum of the squares of the
    first one hundred natural numbers and the square of the sum.
    */

    public static void main(String[] args) {
        System.out.println(squereDifference(100));
    }

    public static long squereDifference(int a) {
        long sumOfSquere =0;
        long squereOfSum = 0;
        for (int i = 1; i <= a; i++) {
            sumOfSquere += i*i;
            squereOfSum += i;
        }

        return squereOfSum*squereOfSum - sumOfSquere;
    }
}

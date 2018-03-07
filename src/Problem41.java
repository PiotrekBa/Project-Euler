public class Problem41 {

    /*
    Problem 41 - Pandigital prime

    We shall say that an n-digit number is pandigital
    if it makes use of all the digits 1 to n exactly once.
    For example, 2143 is a 4-digit pandigital and is also prime.

    What is the largest n-digit pandigital prime that exists?
    */

    public static void main(String[] args) {

        int maxPrime = 0;

        for (int i = 2; i <= 9; i++) {
            String s = "";
            for (int j = 1; j <= i; j++) {
                s += j;
            }

            while (true) {
                int num = Integer.parseInt(s);
                if (isPrime(num) && num > maxPrime) {
                    maxPrime = num;
                }
                s = nextOrder(s);
                if (s == null) {
                    break;
                }
            }

        }

        System.out.println(maxPrime);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Algorithm for lexicographic ordering from
    // https://www.quora.com/How-would-you-explain-an-algorithm-that-generates-permutations-using-lexicographic-ordering
    public static String nextOrder(String s) {

        //Step 1. Find the largest x such that P[x]<P[x+1].
        //(If there is no such x, P is the last permutation.)

        int x = findLargest(s);
        if (x >= 0) {

            //Step 2. Find the largest y such that P[x]<P[y].

            String[] array = s.split("");
            int num1 = Integer.parseInt(array[x]);
            String str = s.substring(x);
            int y = findLargest(str, num1) + x;

            //Step 3. Swap P[x] and P[y].

            array = swap(array, x, y);

            //Step 4. Reverse P[x+1 .. n].

            String subOrder1 = String.join("", array).substring(0, x + 1);
            String subOrder2 = String.join("", array).substring(x + 1);
            subOrder2 = new StringBuilder(subOrder2).reverse().toString();

            return subOrder1 + subOrder2;
        }
        return null;
    }

    public static String[] swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        return a;
    }

    public static int findLargest(String s) {
        for (int i = s.length() - 1; i > 0; i--) {
            int num1 = Integer.parseInt(s.substring(i, i + 1));
            int num2 = Integer.parseInt(s.substring(i - 1, i));
            if (num1 > num2) {
                return i - 1;
            }
        }
        return -1;
    }


    public static int findLargest(String s, int x) {
        for (int i = s.length() - 1; i > 0; i--) {
            int num1 = Integer.parseInt(s.substring(i, i + 1));
            if (num1 > x) {
                return i;
            }
        }
        return -1;
    }

}

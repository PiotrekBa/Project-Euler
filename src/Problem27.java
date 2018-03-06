public class Problem27 {

    /*
    Problem 27 - Quadratic primes

    Euler discovered the remarkable quadratic formula:

    n^2+n+41

    It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39.
    However, when n=40, 40^2+40+41=40(40+1)+41 is divisible by 41,
    and certainly when n=41,41^2+41+41 is clearly divisible by 41.

    The incredible formula n^2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79.
    The product of the coefficients, −79 and 1601, is −126479.

    Considering quadratics of the form:

    n^2+an+b, where |a|<1000 and |b|≤1000

    where |n| is the modulus/absolute value of n
    e.g. |11|=11 and |−4|=4

    Find the product of the coefficients, a and b,
    for the quadratic expression that produces the maximum number of primes for consecutive values of n,
    starting with n=0.
     */

    public static void main(String[] args) {

        int[] ab = new int[2];
        int max = 0;

        for (int a = -999; a < 1000; a ++) {
            if (a == 0) {
                a++;
            }
            for (int b = -1000; b <= 1000; b++) {
                boolean isPrime = true;
                int n = 0;
                int tempMax =0;
                while(isPrime) {
                    long result = n*n + a*n + b;
                    if (prime(Math.abs(result))) {
                        n++;
                    } else {
                        isPrime = false;
                    }
                }
                if (n > max) {
                    max = n;
                    ab[0] = a;
                    ab[1] = b;
                }
            }
        }
        System.out.println("a = " + ab[0] + ", b = " + ab[1] +
        ", max = " + max);
        System.out.println(ab[0]*ab[1]);
    }

    public static boolean prime(long p) {
        boolean isPrime = true;
        if (p == 0 || p == 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(p); i++) {
                if (p % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
}

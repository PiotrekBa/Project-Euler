public class Problem10 {
    /*
    Problem 10 - Summation of primes

    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

    Find the sum of all the primes below two million.
     */

    public static void main(String[] args) {
        int primesBelow = 2_000_000;
        long sum = 0L;
        for(int i = 2; i < primesBelow; i++) {
            if(isPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num%i==0) {
                return false;
            }
        }
        return true;
    }
}

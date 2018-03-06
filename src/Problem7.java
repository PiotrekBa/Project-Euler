public class Problem7 {

    /*
    Problem 7 - 10 001st prime

    By listing the first six prime numbers:
    2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

    What is the 10 001st prime number?
    */

    public static void main(String[] args) {
        System.out.println(primeNumber(10_001));
    }

    public static long primeNumber(int a) {
        long counter = 0;
        long number =2;
        while(counter != a) {
            number++;
            boolean isPrime = true;
            for(int i = 2; i < number/2; i++) {
                if(number%i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                counter++;
            }
        }
        return number;
    }
}

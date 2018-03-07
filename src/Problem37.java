public class Problem37 {

    /*
    Problem 37 - Truncatable primes

    The number 3797 has an interesting property.
    Being prime itself, it is possible to continuously remove digits from left to right,
    and remain prime at each stage: 3797, 797, 97, and 7.
    Similarly we can work from right to left: 3797, 379, 37, and 3.

    Find the sum of the only eleven primes that are both
    truncatable from left to right and right to left.

    NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
    */

    public static void main(String[] args) {
        int counter = 0;
        int sum = 0;
        int i = 10;

        while(counter < 11) {
            if(isPrime(i)) {
                if(truncate(i)) {
                    counter++;
                    sum+=i;
                }
            }
            i++;

        }
        System.out.println(sum);

    }

    public static boolean truncate(int num) {
        String s = String.valueOf(num);
        int len = s.length()-1;
        for(int i = 0; i < len; i++) {
            String a1 = s.substring(i+1);
            String a2 = s.substring(0,len-i);

            if(!(isPrime(Integer.parseInt(a1)) &&
                    isPrime(Integer.parseInt(a2)))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num%i==0) {
                return false;
            }
        }
        if(num ==1) {
            return false;
        }
        return true;
    }




}

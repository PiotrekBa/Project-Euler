import java.util.ArrayList;
import java.util.List;

public class Problem35 {

    /*
    Problem 35 - Circular primes

    The number, 197, is called a circular prime because all rotations of the digits:
    197, 971, and 719, are themselves prime.
    There are thirteen such primes below 100:
    2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
    How many circular primes are there below one million?
    */


    public static void main(String[] args) {

        int counter = 0;

        for(int i = 2; i < 1_000_000; i++) {
            String str = ""+i;
            int possibility = str.length();
            boolean isCircular = true;
            int a = Integer.parseInt(str);
            for(int j = 1; j <= possibility; j++) {

                if(!isPrime(a)) {
                    isCircular = false;
                    break;
                }
                if(String.valueOf(a).length() != possibility) {
                    isCircular = false;
                    break;
                }
                a = nextCombination(a);
            }
            if(isCircular) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    static boolean isPrime(int n) {
        boolean isPrime = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    static int nextCombination(int n) {
        String str = ""+n;
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        char c = list.get(0);
        list.remove(0);
        list.add(c);
        String s = "";
        for(int i = 0; i < list.size(); i++) {
            s = s + list.get(i);
        }
        return Integer.parseInt(s);
    }

}

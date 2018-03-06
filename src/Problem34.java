import java.util.HashMap;
import java.util.Map;

public class Problem34 {

    /*
    Problem 34 - Digit Factorials

    145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
    Find the sum of all numbers which are equal to the sum of the factorial of their digits.
    Note: as 1! = 1 and 2! = 2 are not sums they are not included.
     */

    public static void main(String[] args) {
        int maxNumber = 10;
        int sum=0;

        Map<Integer, Integer> map = getList();

        while(true) {
            sum+= map.get(9);
            if(sum > maxNumber) {
                maxNumber *= 10;
            } else {
                break;
            }
        }
        int counter = 0;
        for(int i = 3; i <= sum; i++) {
            String number = ""+i;
            int sumOfDigit = 0;
            for(int j=0; j<number.length(); j++) {
                int digit = Integer.parseInt(number.substring(j,j+1));
                sumOfDigit += map.get(digit);
            }
            if(sumOfDigit==i) {
                System.out.println(i);
                counter += i;
            }
        }
        System.out.println(counter);
    }

    static int factorial(int a) {
        int result = 1;
        for(int i =1; i <=a; i++) {
            result *= i;
        }
        return result;
    }

    static Map<Integer, Integer> getList() {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <10; i++) {
            map.put(i, factorial(i));
        }
        return map;
    }
}

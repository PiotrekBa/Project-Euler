import java.util.ArrayList;
import java.util.List;

public class Problem30 {

    /*
    Problem 30 - Digit fifth powers

    Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

    1634 = 1^4 + 6^4 + 3^4 + 4^4
    8208 = 8^4 + 2^4 + 0^4 + 8^4
    9474 = 9^4 + 4^4 + 7^4 + 4^4
    As 1 = 1^4 is not a sum it is not included.

    The sum of these numbers is 1634 + 8208 + 9474 = 19316.

    Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
     */

    public static void main(String[] args) {
        int power = 5;

        int maxNumber = 10;
        long sum = 0;
        while(true){
            sum+=Math.pow(9,power);
            if(sum>maxNumber) {
                maxNumber = maxNumber*10;
            } else {
                break;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 2; i <= sum; i++) {
            String number = ""+(i);
            int sumOfDigit = 0;
            for(int j = 0; j < number.length(); j++) {
                int digit = Integer.parseInt(number.substring(j,j+1));
                sumOfDigit += (int) Math.pow(digit, power);
            }
            if(sumOfDigit == i) {
                list.add(i);
            }
        }
        System.out.println(list);
        sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}

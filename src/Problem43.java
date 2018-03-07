import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class Problem43 {

    /*
    Problem 43 - Sub-string divisibility

    The number, 1406357289, is a 0 to 9 pandigital number
    because it is made up of each of the digits 0 to 9 in some
    order, but it also has a rather interesting sub-string
    divisibility property.

    Let d1 be the 1st digit, d2 be the 2nd digit,
    and so on. In this way, we note the following:

    d2 d3 d4  = 406 is divisible by 2
    d3 d4 d5  = 063 is divisible by 3
    d4 d5 d6  = 635 is divisible by 5
    d5 d6 d7  = 357 is divisible by 7
    d6 d7 d8  = 572 is divisible by 11
    d7 d8 d9  = 728 is divisible by 13
    d8 d9 d10 = 289 is divisible by 17

    Find the sum of all 0 to 9 pandigital numbers with this property.
    */

    public static void main(String[] args) {

        String num = "1023456789";

        Map<Integer, Integer> mapPrimes = getMap();

        long sum = 0L;

        while(num != null) {

            boolean isDivisibility = true;

            for(int i = 1; i < num.length() - 2; i++) {
                String substring = num.substring(i,i+3);
                int number = Integer.parseInt(substring);
                int divide = mapPrimes.get(i);
                if(number % divide != 0) {
                    isDivisibility = false;
                    break;
                }
            }

            if(isDivisibility) {
                sum += Long.parseLong(num);
            }

            num = Problem41.nextOrder(num);
        }

        System.out.println(sum);

    }

    public static Map<Integer, Integer> getMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,5);
        map.put(4,7);
        map.put(5,11);
        map.put(6,13);
        map.put(7,17);
        return map;
    }

}

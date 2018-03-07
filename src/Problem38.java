public class Problem38 {

    /*
    Problem 38 - Pandigital multiples

    Take the number 192 and multiply it by each of 1, 2, and 3:

        192 × 1 = 192
        192 × 2 = 384
        192 × 3 = 576

    By concatenating each product we get the 1 to 9 pandigital,
    192384576. We will call 192384576 the concatenated product
    of 192 and (1,2,3)

    The same can be achieved by starting with 9
    and multiplying by 1, 2, 3, 4, and 5, giving the pandigital,
    918273645, which is the concatenated product of 9 and (1,2,3,4,5).

    What is the largest 1 to 9 pandigital 9-digit number that
    can be formed as the concatenated product of an integer
    with (1,2, ... , n) where n > 1?
    */

    public static void main(String[] args) {

        int i = 2;

        int max = 0;

        while(true) {
            String concat = nineDigit(i);
            if(concat == null) {
                break;
            }
            if(concat.length() == 9) {
                if(isOneToNine(concat)) {
                    int temp = Integer.parseInt(concat);
                    if(temp > max) {
                        max = temp;
                    }
                }
            }
            i++;
        }
        System.out.println(max);
    }

    public static String nineDigit(int num) {
        String concat = "";
        int i = 1;

        int len = concat.length();

        while(len <9) {
            concat += (num*i);
            len = concat.length();
            i++;
        }

        if(i <= 2) {
            return null;
        }
        if (len == 9) {
            return concat;
        }

        return "";
    }

    public static boolean isOneToNine(String s) {
        for(int i =1; i <=9; i++) {
            if(!s.contains(""+i)) {
                return false;
            }
        }
        return true;
    }
}

public class Problem40 {

    /*
    Problem 40 - Champernowne's constant

    An irrational decimal fraction is created by concatenating the positive integers:

        0.123456789101112131415161718192021...

    It can be seen that the 12th digit of the fractional part is 1.

    If dn represents the nth digit of the fractional part, find the value of the following expression.

        d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
    */

    public static void main(String[] args) {

        int i = 1;
        int position = 1;
        int counter = 0;
        int result = 1;

        while (position <= 1_000_000) {
            String s = String.valueOf(i);
            counter += s.length();
            if (counter >= position) {
                int a = counter - position;
                int p = s.length() - a - 1;
                String number = s.substring(p, p + 1);
                result *= Integer.parseInt(number);
                position *= 10;
            }
            i++;
        }
        System.out.println(result);
    }
}

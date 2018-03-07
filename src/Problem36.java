public class Problem36 {

    /*
    Problem 36 - Double-base palindromes

    The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

    Find the sum of all numbers, less than one million,
    which are palindromic in base 10 and base 2.

    (Please note that the palindromic number,
    in either base, may not include leading zeros.)
    */

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 1_000_000; i++) {
            String numberD = String.valueOf(i);
            if (isPalindrome(numberD)) {
                String numberB = Integer.toString(i,2);
                if(isPalindrome(numberB)) {
                    sum += i;
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean isPalindrome(String s) {
        for(int i = 0; i <= s.length()/2; i++) {
            char a = s.charAt(i);
            char mirrorA = s.charAt(s.length()-i-1);
            if(a != mirrorA) {
                return false;
            }
        }
        return true;
    }
}

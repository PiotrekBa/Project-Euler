public class Problem9 {

    /*
    Problem 9 - Special Pythagorean triplet

    A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

    a^2 + b^2 = c^2

    For example, 32 + 42 = 9 + 16 = 25 = 52.

    There exists exactly one Pythagorean triplet for which a + b + c = 1000.

    Find the product abc.
     */

    public static void main(String[] args) {
        System.out.println("\n"+pythagoreanTriplet(1000));
    }

    public static int pythagoreanTriplet(int sum) {
        int a;
        int product = 0;
        for(a=1; a<= sum/3; a++) {
            int b;
            for(b= a+1; b<= sum/2; b++) {
                int c = sum - a - b;
                if(c>0 && (a*a + b*b == c*c)) {
                    System.out.printf("a=%d, b=%d, c=%d", a, b, c);
                    product = a*b*c;
                    break;
                }
            }
        }
        return product;
    }
}

public class Problem14 {

    /*
    Problem 14 - Longest Collatz squence

    The following iterative sequence is defined for the set of positive integers:

    n → n/2 (n is even)
    n → 3n + 1 (n is odd)

    Using the rule above and starting with 13, we generate the following sequence:

    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
    Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

    Which starting number, under one million, produces the longest chain?
     */

    public static void main(String[] args) {
        int terms = 0;
        int number = 0;
        int maxNumber = 1000_000;

        for (int i = 2; i < maxNumber; i++) {
            long result = i;
            int tempTerms = 1;
            while (result != 1) {
                if (result % 2 == 0) {
                    result /= 2;
                } else {
                    result = 3 * result + 1;
                }
                tempTerms++;
            }
            if (tempTerms > terms) {
                terms = tempTerms;
                number = i;
            }
        }

        System.out.println(number + " - " + terms);

    }
}

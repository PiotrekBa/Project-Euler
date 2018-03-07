public class Problem39 {

    /*
    Problem 39 - Integral right triangle

    If p is the perimeter of a right angle triangle
    with integral length sides, {a,b,c},
    there are exactly three solutions for p = 120.

    {20,48,52}, {24,45,51}, {30,40,50}

    For which value of p ≤ 1000,
    is the number of solutions maximised?
    */

    public static void main(String[] args) {

        int perimeter = 1000;

        int[] max = {0,0};


        for(int i = 12; i <= perimeter; i++) {
            int counter = 0;
            for(int a = 1; a <= i/3; a++) {
                for(int b = a+1; b < a+i/3; b++) {
                    int c = i - a - b;
                    if(a*a + b*b == c*c) {
                        counter++;
                    }
                }
            }
            if(counter > max[1]) {
                max[0] = i;
                max[1] = counter;
            }
        }

        System.out.println(max[0]);
    }
}

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem52 {

    /*
    Problem 52 - Permuted multiples

    It can be seen that the number, 125874, and its double, 251748,
    contain exactly the same digits, but in a different order.

    Find the smallest positive integer, x,
    such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
    */

    public static void main(String[] args) {

        int num = 0;
        boolean isChecked = false;

        while(!isChecked){
            num++;
            List<Character> list1= arrToList(num);

            for(int i = 2; i <= 6; i++) {

                List<Character> list2 = arrToList((num*i));
                if(list1.size() != list2.size()) {
                    break;
                }

                if(!compareLists(list1,list2)){
                    isChecked = false;
                    break;
                }

                isChecked = true;
            }
        }

        System.out.println(num);
    }

    public static List<Character> arrToList(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        List<Character> list = new LinkedList<>();
        for(char c : chars)  {
            list.add(c);
        }
        return list;
    }

    public static boolean compareLists(List<Character> list1,
                                       List<Character> list2) {

        int len = list1.size();
        Collections.sort(list1);
        Collections.sort(list2);

        for(int i = 0; i < len; i++) {
            if(list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

}

package Collections.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class Example3 {
    // This example demonstrates that we can have complex sorting logics too
    // here we are trying to sort String based on length ie. strings with length 2 will
    // come before strings with length 3 and if 2 strings have same length then we simply
    // arrange them in ascending order

    public static void main(String args[]) {
        TreeSet ts = new TreeSet(new MyComparator());
        ts.add("XX");
        ts.add("ABCD");
        ts.add("A");
        ts.add("ABC");
        ts.add("AA");
        System.out.println(ts);
    }

    static class MyComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString();
            String s2 = o2.toString();
            int l1 = s1.length();
            int l2 = s2.length();

            if (l1 < l2) {
                return -1; // -ve means put o1 before o2
            } else if (l2 < l1) {
                return +1;// +ve means put o2 before o1
            } else { // case when length of o1 and o2 is same
                return s1.compareTo(s2); // now we are taking help of the compareTo()
                //method of "String" class which already has defined logic for sorting
                // 2 strings in ascending order
            }
        }
    }
}

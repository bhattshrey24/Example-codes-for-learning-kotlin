package Collections.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class Example2 {
    // We can store Homogenous objects in a TreeSet too just see below code
    public static void main(String args[]) {
        TreeSet ts = new TreeSet(new MyComparator());
        ts.add("D"); // Its a normal String
        ts.add(new StringBuffer("C"));// see Its String buffer object
        ts.add("A");
        ts.add(new StringBuffer("B"));

        System.out.println(ts);
    }
    static class MyComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString(); // this will convert String buffer to string
            //and if its already String then simply cast it to String from Object
            String s2 = o2.toString();

            return s1.compareTo(s2); // ie. we are calling the "compareTo" method of
            //"String" class which already has logic for comparing 2 strings , this is what
            // jvm would have called if default natural sorting was possible in this case but it's
            // not because our TreeSet has StringBuffer objects too in it.
        }
    }
}

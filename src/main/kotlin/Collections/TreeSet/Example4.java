package Collections.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class Example4 {
    //This shows how we can sort string in Descending order
    public static void main(String args[]) {
        TreeSet ts = new TreeSet(new MyComparator());
        ts.add("Abc");
        ts.add("Acd");
        ts.add("Cba");
        ts.add("Cda");
        ts.add("Fab");
        System.out.println(ts);
    }

    static class MyComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString();
            String s2 = o2.toString();
            int val = s1.compareTo(s2);
            return -val; // we are basically reversing whatever "s1.compareTo(s2)" returned because compareTo
            // method of "String" class arranges strings in ascending order but since we want opposite ie. descending
            // therefore we reverse the result ie. if it returns +ve then we make it -ve and vice versa
        }
    }
}

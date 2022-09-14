package Collections.TreeSet;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Example1 {
    // Here I showed how we can perform same operations using Comparator and Comparable
    public static void main(String args[]) {

        // Using Comparator
        TreeSet s = new TreeSet(new MyComparator());
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(0);
        s.add(40);

        System.out.println(s);

        // Using Comparable
        TreeSet s2 = new TreeSet();
        s2.add(new MyComparable(10));
        s2.add(new MyComparable(20));
        s2.add(new MyComparable(30));
        s2.add(new MyComparable(40));

        Iterator itr = s2.iterator(); // we can't directly do System.out.println(s2)
        // because obviously s2 stores objects of class MyComparable , we have to iterate over
        // the treeset and then display 'value'

        while (itr.hasNext()) {
            MyComparable ele = (MyComparable) itr.next();
            System.out.println(ele.value);
        }

    }

    static class MyComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            int i1 = (int) o1; // type casting to int because we know that
            // we will be storing int in the TreeSet which will apply this Comparator
            // If we now try to store something else other than int then we will get type casting error
            int i2 = (int) o2;
            return i2 - i1;
        }

    }

    static class MyComparable implements Comparable<MyComparable> {
        int value;

        MyComparable(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(@NotNull MyComparable o) {
            return o.value - this.value;
        }
    }
}

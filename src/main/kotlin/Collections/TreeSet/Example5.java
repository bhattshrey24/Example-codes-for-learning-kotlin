package Collections.TreeSet;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Example5 {
    // Suppose your senior made a class "Employee" , he/she implemented "Comparable" interface
    // and added logic for sorting employees based on name (ie. String) in ASCENDING order
    // but now you as an intern want to use Employee class but you want to sort the object
    // based on name in DESCENDING order. So now you won't change the Employee class compareTo()
    // definition because it might break code somewhere else
    // so what you can do is define a new "Comparator" and pass that so that now jvm uses your new
    // passed "Comparator" for our treeSet
    // instead of pre defined Comparable's compareTo() which your senior wrote

    public static void main(String args[]) {

        TreeSet epts1 = new TreeSet();
        epts1.add(new Employee("Shrey", 1));
        epts1.add(new Employee("Laksh", 5));
        epts1.add(new Employee("Prasoon", 4));
        epts1.add(new Employee("Rhea", 3));

        Iterator itr = epts1.iterator();
        while (itr.hasNext()) {
            Employee ep = (Employee) itr.next();
            System.out.println(ep.name);
        }

        TreeSet epts2 = new TreeSet(new MyComparator()); // See we are telling JVM to not use the Comparable
        // Instead use the Comparator that we are passing
        epts2.add(new Employee("Shrey", 1));
        epts2.add(new Employee("Laksh", 5));
        epts2.add(new Employee("Prasoon", 4));
        epts2.add(new Employee("Rhea", 3));

        Iterator itr2 = epts2.iterator();
        System.out.println("After Changing Sorting Order :-");
        while (itr2.hasNext()) {
            Employee ep = (Employee) itr2.next();
            System.out.println(ep.name);
        }


    }

    static class Employee implements Comparable<Employee> {
        String name;
        int id;

        Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public int compareTo(@NotNull Employee o) {
            return this.name.compareTo(o.name);
        }
    }

    static class MyComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            int val = o1.name.compareTo(o2.name);
            return -val;
        }
    }
}

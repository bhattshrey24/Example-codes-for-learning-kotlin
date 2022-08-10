package OperatorOverloading

class MyOperatorOverloading {
    // Just watch this 3 min video https://www.youtube.com/watch?v=1oYpIT5aRi8
    // we can overload the default behaviour of an operator using this , The operators on which we can perform operator overloading are mentioned in kotlin documentation
    // Eg generally + operator can add 2 numbers or concatenate 2 string but what if I want it to add something else like 2 user defined objects etc  , just see the code you'll understand
    class A() {

    }

    fun <T> find(a: T) {

    }

    fun execute() {
        val emp1 = Emp("Jack", 5000)
        val emp2 = Emp("James", 10000)

        val combinedEmp = emp1 + emp2// observe carefully that we are using '+' , now the code is so much more readible

        println(combinedEmp)
    }

    class Emp(var name: String, var salary: Int) {
    }

    infix operator fun Emp.plus(emp2: Emp): Emp { // this is not a normal infix function , its overloading function
        // see here we are defining what we want the '+' operator to do
        val newName = this.name + emp2.name
        val newSalary = this.salary + emp2.salary
        return Emp(newName, newSalary)
    }


}
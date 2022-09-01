package `Extension and Inline Function`

class ExtensionFunction {

    fun execute() {
        println("Shrey".myFormatString())
        val listOfStrings = mutableListOf("One", "Two", "Three", "Four", "Five")
        listOfStrings.swap2Variable(1, 3)
        print("$listOfStrings")
        val emp1 = Emp("James", 8000)
        println(emp1.showEmployeeDetails())
        val emp2 = Emp("Jack", 10000)
        println(emp2.showEmployeeDetails())
        println("employees salary sum ${emp1.sumSalaries(emp2)}")
        emp1.age = 10; // accessing the extension property 'age'
        println("Age difference is : "+emp2.showAgeDifference(emp1))
    }

    fun String.myFormatString(): String { // we can extend primitive classes that
        // are given to us by Kotlin
        return "$this-----This is Your Formatted String" // here 'this' basically
        // refers to the string on which we call this method
    }

    fun MutableList<String>.swap2Variable(
        index1: Int,
        index2: Int
    ) { // we are extending MutableList class, adding our own function to it
        val temp = this[index1]// here 'this' refers to the mutableList on which
        // we called this function
        this[index1] = this[index2]
        this[index2] = temp
    }

    fun Emp.showEmployeeDetails(): String {// And we can also extend our own classes ,
        // observe we are doing it outside the class
        return "Employee Name : ${this.name} and Employee Salary: ${this.salary}"
    }

    fun Emp.sumSalaries(emp2: Emp): Int {// we can even take as many parameters as we want , IMP : Since we can declare these functions outside classes therefore we can't use private functions and properties of the class in them
        return this.salary + emp2.salary
    }

    private var Emp.age: Int // This is an extension property ,
        // we can't initialize them, and we have to add a getter and a setter with them
        get() = age // see I used it in below function
        set(value) {
            age = value
        }

    fun Emp.showAgeDifference(emp2: Emp): Int {//we can use extension property
        // anywhere like a normal property
        return this.age - emp2.age
    }

    class Emp(var name: String, var salary: Int) {
    }

    fun myFun(name: String, age: Int) {

    }

}
package Infix

class MyInfix(private val salary: Int, val name: String) {
    fun execute() {
        val emp1 = MyInfix(1000, "Jake")
        val emp2 = MyInfix(4000, "Janardhan Kimothi")
        println(emp1 sumOfSalaryWith emp2) // see "sumOfSalaryWith" is a function
        // still we are using it like an operator due to infix ,
        // this make the code readable
        println(emp1.sumOfSalaryWith(emp2)) // see we can write it like normal
        // function too

    }

    private infix fun sumOfSalaryWith(emp2: MyInfix): Int { // We can only have 1 parameter
        // in an 'infix' functions
        var sum = this.salary + emp2.salary
        return sum
    }

}


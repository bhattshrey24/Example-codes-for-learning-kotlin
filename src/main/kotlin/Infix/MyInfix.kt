package Infix

class MyInfix(private val salary: Int, val name: String) {

    infix fun sumOfSalaryWith(emp2: MyInfix): Int { // We can only have 1 parameter in an 'infix' functions
        A.x
        return this.salary + emp2.salary
    }

    private class A(val b: Int) {
        companion object {
            var x = 10
        }
    }
}


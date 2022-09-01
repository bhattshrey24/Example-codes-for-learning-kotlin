package `Scope Functions`

class Scope_Functions {
    fun execute() {
        var ob = A(1, "A")
        val lambdaRes = with(ob) {
            "Inside With" // i.e. we can do anything inside
            this.age = 22
            this.name = "B"
            "Successfully changed" // this will be returned cause it's the
            // last statement to "lambdaRes"
        }
        val modifiedOb = ob.apply {
            "Inside Apply" // i.e. we can do anything inside
            this.age = 3
            this.name = "C"
        }
        println("modified age by 'apply' ${ob.age}")// modified age

        var modifiedOb2 = ob.also {
            "Inside also" // i.e. we can do anything inside
            it.age = it.age + 5;
        }

        var newOb: A? = A(2, "B")
        var lambdaRes2 = newOb?.run {
            // this function is mixture of 'with' and 'let' i.e. returning the
            // lambda result with null safety
            "Inside run" // i.e. we can do anything inside
            this.age = 10
            this.name = "X"
            "Successfull operation"
        }

        var lambdaRes3 = newOb?.let {
            "Inside let" // i.e. we can do anything inside
            // this is basically used for null safety
            it.name = "Hello"
            "SuccessFull ji"
        }

    }
    data class A(var age: Int, var name: String)

}


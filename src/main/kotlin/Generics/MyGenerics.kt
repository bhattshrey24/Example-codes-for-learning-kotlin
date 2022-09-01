package Generics

class MyGenerics {
    fun execute() {
        var a = 10;
        var b = "Hi"
        printGenFun(a, b)

        var ob = Gen<Int, String>() // We have to specify type here
        // otherwise it will give compile time error
        ob.printGens(200, "Hey")
    }

    class Gen<T, V> { // this way we can make a class generic and then use it,
        // this is how classes like 'List' , 'Maps' etc. are made
        fun printGens(a: T, b: V) {
            println("$a   &    $b")
        }
    }

    private fun <M, N> printGenFun(a: M, b: N) { // This is how we can even make a function 'Generic'
        println("$a   &    $b")
    }
}
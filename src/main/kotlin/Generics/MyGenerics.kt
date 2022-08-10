package Generics

class MyGenerics {
    class Gen<T, V> { // this way we can make a class generic and then use it, this is how classes like 'List' , 'Maps' etc are made
        fun printGens(a: T, b: V) {
            println("$a   &    $b")
        }
    }

    fun <M, N> printGenFun(a: M, b: N) { // This is how we can even make a function 'Generic'
        println("$a   &    $b")
    }
}
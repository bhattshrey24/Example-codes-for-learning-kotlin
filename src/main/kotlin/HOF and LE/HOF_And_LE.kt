package `HOF and LE`

class HOF_And_LE { // Higher order function and lambda expression
    fun execute() {
        var fn: (Int, Int) -> Int = ::sum // storing a function in variable
        println(fn(1, 2))// see we are executing the variable
        // like it's a normal function

        var fn2: (Int, Int) -> Int =
            { a: Int, b: Int -> a + b }// see here I'm directly passing a lambda expression ,
        // lambdas are simply functions with no name
        println(fn2(4, 5))

        println(
            f2(
                4,
                3
            ) { a: Int, b: Int -> a * b }) // passing a lambda function in end ,
        // f2 is a higher order function
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    private fun f2(
        a: Int,
        b: Int,
        gn: (Int, Int) -> Int
    ): Int { // This is higher order function since it's taking a function as parameter and
        // also returning a function
        return gn(a, b) // basically it means that f2 returns whatever gn returns

         // Higher order function is a function which either takes
        // a function as parameter or returns a function or does both
    }

}
fun a(): Int {// SEE WE CAN DEFINE FUNCTION OUTSIDE THE CLASS IN THE SAME FILE TOO
    return 0
}
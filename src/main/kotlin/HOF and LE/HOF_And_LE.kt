package `HOF and LE`

class HOF_And_LE {

    fun execute() { // assume this as main function and write code , to actually run we simply call this function from actual main class

        var fn: (Int, Int) -> Int = ::sum // storing a function
        var fn2: (Int, Int) -> Int =
            { a: Int, b: Int -> a + b }// see here i'm directly passing a lambda , lambdas are simply functions with no name
        println(fn(1, 2))// see we are executing the variable like it's the actual function

        println(
            f2(
                4,
                3
            ) { a: Int, b: Int -> a * b }) // passing a lambda function in end , f2 is a higher order function
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b;
    }

    private fun f2(
        a: Int,
        b: Int,
        gn: (Int, Int) -> Int
    ): Int { // higher order function since its taking a function as parameter and also returning a function
        return gn(a, b) // basically it means that f2 returns whatever gn returns
    }

}

fun a(): Int {// SEE WE CAN DEFINE FUNCTION OUTSIDE THE CLASS IN THE SAME FILE TOO
    return 0
}
package TailRecursion

// Tail recursion is a new type of approach to recursion which tackles the stack
// limitations of recursion.
//Tail recursion follows one rule for implementation. This rule is that the recursive call must be
// the last call of the method.
fun main() {
    println(regFact(5))
    println(tailRecFact(5, 1))

}

fun regFact(n: Int): Int {
    if (n == 1) {
        return 1
    } else {
        return n * regFact(n - 1)
    }
}

tailrec fun tailRecFact(n: Int, ans: Int): Int {
    if (n == 0 || n == 1) { // we are trying to build the answer as we reach base case
        return ans
    } else {
        return tailRecFact(n - 1, n * ans)// see the answer of each level is being calculated and
        // stored in argument which is passed to next level . basically we try to do all the work while building
        // stack so we don't need to do anything when stack falls which means there's NO NEED TO KEEP
        // STACK since we don't need previous state to calculate answer of any state , we are calculating answer
        // as we are moving forward . So when we use "tailrec" keyword then compiler knows
        // that it is tail recursion and compiler does not maintain a stack (actually what happens is
        // that compiler converts the recursive code into iterative code)
        // So if you can convert your code to tail recursive then
        // advantage of that is your code will be easy to understand(since recursive code is easy to
        // understand logic wise) and it is space optimized.
        // Writing tail recursive code is sometimes harder than writing recursive code

    }
}

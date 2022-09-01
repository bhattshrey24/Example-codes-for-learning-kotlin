package `Extension and Inline Function`

class InlineFunction {
    fun execute() {

    }
    // for all lambda functions kotlin will create a class for each lambda (separately I guess)
    // and then instantiate an object of that class and using that instance/object it will run
    // all those lambdas. This is time-consuming and memory consuming if you are using a lot of
    // lambdas . So to tackle this problem we use 'inline'.
    // What inline does is it will simply copy the body of the inline function wherever it
    // is called (just like c++ inline) this improves the performance because now kotlin
    // won't make any unnecessary class for that function.
    // It just enhances performance nothing else
    inline fun sum(a: Int, fn: () -> Unit) { // we can make higher order functions as inline
    }
    inline fun sumNos() { // we can make normal functions inline too
    }
}
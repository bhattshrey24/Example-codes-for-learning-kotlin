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
    // It just enhances performance nothing else. So only use inline for function which are higher
    // order ie. takes another function as parameter . No use of making a function inline
    // if its a normal function . Also inline functions should be small if we make large
    // function as inline then it won't improve performance since compiler will have to
    // copy paste all the code wherever the function is called
    inline fun sum(fn: () -> Unit) { // we can make higher order functions as inline
    }

    inline fun sumNos() { // we can make normal functions inline too but its of no use.
    }

}
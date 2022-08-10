package LamdaFunction

class MyLambdaFunction {

    fun execute() {
        onSum(20) {
        }

        // we define lamda function outside braces '()' and when there is no other parameter then we don't even have to add braces like below
        var myButton = Button()
        myButton.onClick {

        }


        myButton.doSomething { a, b ->  // if there is just 1 parameter we can access it using 'it' but if there are more we have to specify like this

        }

    }

    fun onSum(money: Int, fn: (a: Int) -> Unit) {
        println("Doing something")
        fn(money)
    }

    class Button() {
        fun onClick(fn: (a: Int) -> Unit) {
            println("Ding something")
        }

        fun doSomething(fn: (a: Int, b: Int) -> Unit) {

        }
    }

}
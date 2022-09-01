package `HOF and LE`

class LambdaFunction {
    fun execute() {
        onConvert(20) {
            var convertMoneyToRupees = it * 70 // this "it" is 'money' just go to its implementation
            convertMoneyToRupees// this will be returned by this lambda function
        }

        onConvert2({
            var convertMoneyToRupees = it * 70
        }, 20) // only last lambda function can be defined outside "()"
        // others will have to be defined inside "()"


        // when there is no other parameter then we don't even have to add braces like below
        var myButton = Button()
        myButton.onClick {
            println("Ding something")
        }

        myButton.doSomething(10, 20) { a, b ->  // if there is just 1 parameter we can
            // access it using 'it' but if there are more we have to specify like this
            var sum = a + b;
            println(sum)
        }

    }

    private fun onConvert(money: Int, fn: (a: Int) -> Int) {
        println("Converting Money")
        var converted = fn(money) // se we are passing money to the
        // argument "a" of lambda function "fn"
        println(converted) // this way we delegated work like see while writing onConvert()
        // function we don't care about how fn converts money we just simply get the converted money
        // and do whatever we want to do with it
    }

    private fun onConvert2(fn: (a: Int) -> Unit, money: Int) {
        fn(money)
    }

    class Button() {
        fun onClick(fn: () -> Unit) {
        }

        fun doSomething(money1: Int, money2: Int, fn: (a: Int, b: Int) -> Unit) {
            fn(money1, money2)
        }
    }
}
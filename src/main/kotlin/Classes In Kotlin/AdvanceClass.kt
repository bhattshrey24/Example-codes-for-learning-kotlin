package `Classes In Kotlin`

open class AdvanceClass {
    fun execute() {
        var d = C3("Shrey")
        d.printHi()
    }
//todo(I'm using 'todo' just to highlight the main comment)

//    todo 1) We cannot inherit a private class as shown below by class A and B
//    private open class A() {
//    }
//    class B() : A() {
//    }

    //todo 2) We can even override parent's properties using 'open' as shown below in class C and D
    open class C(open val name: String) {

    }

    class D(name: String, age: Int) : C(name) {
        override var name =
            super.name.toUpperCase();  // You can override a 'val' property with a 'var' property, but not vice versa. This is allowed because a val property essentially declares a getter method, and overriding it as a var additionally declares a setter method in the derived class

    }

    class D2(override var name: String) : C(name) { // We can even use override in primary constructor

    }

    //todo 3) If we make a variable or method as protected then it is only accessible in the classes that inherit that class and not outside
    open class E {
        protected open val p1 = 1
    }

    class F() : E() {
        override val p1 = 2
    }


    //todo 4) Invoking parent constructor using 'super keyword'
    open class G {
        constructor(name: String) {

        }

        constructor(name: String, age: Int) {

        }
    }

    class H : G {
        constructor(first: String, last: String) : super(first) {

        }

        constructor(name: String, last: String, age: Int) : super(name, age) {

        }

//        constructor(salary: Int) { // This will give compile time error because if we are using 'super' to call constructor of parent then we have to do it in all constructors of child.We can call any constructor of parent
//
//        }
    }


    //todo 5) If we want to make overridden function unable to be override any more in further child classes then we can use 'final' keyword as shown
    open class Base() {
        open fun printHi() {

        }
    }

    open class Derived() : Base() {
        final override fun printHi() {

        }
    }

    class Derived2() : Derived() {
//        override fun printHi() { // This will give compile time error , if we remove 'final' keyword then theres no problem
//
//        }

    }

    //todo 6) If we make object of the derived class then first all the base classes initialization is done first
    open class C1 {
        init {
            println("Called init c1 (Will be called 1st)")
        }

        constructor(name: String) {
            println("Called primary constructor of c1 (Will be called 2nd)")
        }

        open fun printHi() {
            println("Hey from c1")
        }
    }

    open class C2 : C1 {
        init {
            println("Called init c2 (Will be called 3rd)")
        }

        constructor(name: String) : super(name) {
            println("Called primary constructor of c2 (Will be called 4th)")
        }

        override fun printHi() {
            println("Hey from c2")
            super.printHi() // this will call c1 class's printHi()
        }

    }

    class C3 : C2 {
        init {
            println("Called init c3 (Will be called 5th)")
        }

        constructor(name: String) : super(name) {
            println("Called primary constructor of c3 (Will be called 6th)")
        }

        override fun printHi() {
            println("Hey from c3")
            super.printHi() // this will call c2 class's printHi()
        }

    }
// Run this below code , the logic is same as above but the way we have written is quite different
//    open class c1(var name: String) {
//        init {
//            println("Called init c1 (Will be called 3rd)")
//        }
//
//        open fun printHi() {
//            println("Hey from c1")
//        }
//    }
//
//    open class c2(var firstName: String) :
//        c1(firstName.also { println("Called c1 class's primary constructor (Will be called 2nd)") }) {
//        init {
//            println("Called init c2 (Will be called 4th)")
//        }
//
//        override fun printHi() {
//            println("Hey from c2")
//            super.printHi() // this will call c1 class's printHi()
//        }
//
//    }
//
//    class c3(var fName: String) :
//        c2(fName.also { println("Called c2 class's primary constructor (Will be called 1st)") }) {
//        init {
//            println("Called init c3 (Will be called 5th)")
//        }
//
//        override fun printHi() {
//            println("Hey from c3")
//            super.printHi() // this will call c2 class's printHi()
//        }
//
//    }

    //todo 7) About abstract and interface
    abstract class A {
        init {

        }

        lateinit var name: String
        fun b() {
            // some code
        }

        abstract fun c() // if we are not providing body then we have to specify it using 'abstract' keyword
    }

    // Weird thing about interfaces in Kotlin is that here methods can have a body too
    interface I {
        var name: String // this will have to initialized by the class that implements it

        //   var name2: String = " " // we cannot initialize a property in interface , it has to be done in the classes that implements it
        fun b()
        fun c() { // its not necessary to override this method
            println("Yo")
        }
//        init { // compile time error cause interface cannot have init block
//        }

    }

    class V(override var name: String) : I {
        override fun b() {
            TODO("Not yet implemented")
        }
    }

    //todo 8) When a class inherits from a class and also implements an interface (ie. multiple inheritance) and suppose both the class and interface has a same method then we have to specify who's method we are calling using '<>'
    open class L {
        open fun f() {
            print("A")
        }
    }

    interface K {
        fun f() {
            print("B")
        } // interface members are 'open' by default

    }

    class J() : L(), K {
        // The compiler requires f() to be overridden:
        override fun f() {
            super<K>.f() // calling f() of interface K
            super<L>.f() // calling f() of class L
        }
        fun z() {
            super<K>.f()
        }
    }

}


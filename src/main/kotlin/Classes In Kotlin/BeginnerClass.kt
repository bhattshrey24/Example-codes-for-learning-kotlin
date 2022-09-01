package `Classes In Kotlin`

class BeginnerClass {
    fun execute() {
        // 2 ways in which we can call the constructors
        val p1a = PersonA("Shrey")
        val p1b = PersonA(name = "Shrey")
        val p2 = PersonB("Stuti")
        val p3 = PersonC("Parsoon")


    }
    //todo(I'm using 'todo' just to highlight the main comment)


    //todo 1) Classes PersonA and PersonB and PersonC shows the 2 ways in which we can use constructors to initialize a value in a class
    class PersonA(var name: String) {
        fun printName() {
            println(name)
        }
    }

    class PersonB constructor(var name: String) {
        fun printName() {
            println(name)
        }
    }

    class PersonC {
        lateinit var name: String

        constructor(name: String) {
            this.name = name
        }

        fun printName() {
            println(name)
        }
    }

    //todo 2) The class PersonD shows how we can have multiple constructors in a class
    class PersonD {
         constructor(firstName: String) { //Secondary constructor

        }

        constructor(firstName: String, lastName: String) { // Secondary constructors

        }

        constructor(firstName: String, lastName: String, age: Int) : this(// Secondary constructors
            firstName,
            lastName
        ) { // 'this(firstName, lastName)' will call the constructor which matches these arguments ie. the constructor just above this one

        }
    }

    //todo 3) classes PersonE, F ,G and H show some general properties of constructors
    class PersonE() { // () becomes the primary constructor
        constructor(first: String) : this() { // we have to call primary constructor either directly
        // or indirectly in all secondary constructors otherwise we get compile time error

        }

        constructor(first: String, last: String) : this(first) { // Indirectly calling the primary constructor

        }

        constructor(firstName: String, last: String, age: Int) : this() {// Directly calling the primary constructor

        }

    }

    class PersonF {
        constructor(first: String) {
        }

        private constructor(
            first: String,
            last: String
        ) { // now we can't access just this constructor outside the class. We can easily access other 2 constructors outside the class

        }

        constructor(firstName: String, last: String, age: Int) {

        }
    }

    class PersonG private constructor(var name: String) { // if we are using either an access
    // modifier or an annotation with () ie. empty primary constructor then we have to use
    // the word 'constructor'

    }
//    class PersonH private @Inject constructor(var name:String) { // Thats why while using
//    'Inject' in hilt we use the keyword 'constructor'
//
//    }


    //todo 4) If there is no body then there's no need to even add {}
    class A
    class B(var name: String, var age: Int)//Again this class also does not have a body
    // , just a constructor
    class X()

    //todo 5) Class Bird and Eagle shows how to achieve inheritance in Kotlin
    open class Bird(var name: String) { // In kotlin if we want to inherit a class we have to declare it 'Open' otherwise we can't inherit it
        fun speakBirdName() {
            println("The bird name is $name")
        }

        open fun fly() { // if we want to override a method then we have to specify it as 'open' too
            println("$name is flying!!")
        }
    }

    class Eagle(var birdName: String, var age: Int) :
        Bird(birdName) { // since the constructor of Bird class takes a string therefore we have to pass it

        init {
            speakBirdName() // we called the speakBirdName() method of parent
        }

        override fun fly() {
            if (age < 5) {
                println("$birdName Can't fly!!!!")
            } else {
                println("$birdName Can fly!!!!")
            }
        }

    }

}
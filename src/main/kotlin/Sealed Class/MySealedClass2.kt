package `Sealed Class`

enum class MySealedClass2 {
    BMW, // behind the scene each object/value of this enum is assigned a number like BMW is 0 , AUDI is 1 and MERCEDES is 2
    AUDI,//the one advantage of enum over sealed classes

    // is that enums are easy to serialize and deserialize since
    // they are numbers(ie. BMW is 0 , AUDI is 1 and MERCEDES is 2) and numbers are easy to serialize and deserialize
    MERCEDES,
}


// sealed classes are enum classes on steroids
sealed class SealedCar() {
    object BMW :
        SealedCar() // observe that these are objects inside a class and they are inheriting from parent sealed class ie. SealedCar

    object Audi : SealedCar()
    object Mercedes : SealedCar()
}

object Lamborghini : SealedCar() // We can even inherit outside the
// sealed class in the same package. But we cannot inherit sealed class
// outside the package in which it is present

sealed class SealedCar2(val model: String) {
    class BMW(model: String) : SealedCar2(model) {

    }

    object Audi : SealedCar2("")
    object Mercedes : SealedCar2("")
}

// Sealed classes are used to expose state ie. Network State class(ie. Resource class as shown below)
//Sealed Class can have generics unlike enum
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) { // this is wrapper class around our api response
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

}

// Sealed class makes parameter much more readible and easy to change
data class Person(
    var name: String,
    var isMale: String
) // Now problem here is that we are just confing our app to take either male or female as gender but there are more

data class Person2(
    var name: String,
    var gender: Gender
) {
    sealed class Gender {
        object Male : Gender()
        object Female : Gender()
        object Transgender : Gender() // now we can easily
    // assign gender by using Gender.Male and we can even increase
    // the number of gender bu simply adding more object classes
    }
}
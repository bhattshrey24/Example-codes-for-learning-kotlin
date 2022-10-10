package MiscellaneousConcepts


fun main() {
    // Wrapper class as the name suggests wraps any kind of data and add some additional capabilities to it
    // like if we wrap our data with LiveData then it becomes observable etc.

    var num = WrapperClass<Int>(10)
    num.print()
    // val sum = num+5 // we can't do this we will get compile time error

    val unWrappedValue = num.value() // compare this with the .value of LiveData . we are just
    // unwrapping the data so that now developer can use the value

    println("Un wrapped value is $unWrappedValue")

    var str = WrapperClass<String>("Hey") // see we can store any kind of data
    str.print()

    val unWrappedValue2 = str.value()
    println("Un wrapped value is $unWrappedValue2")
}

class WrapperClass<T>(ob: T) { // Try to compare this with LiveData , you'll understand better

    var wrappedObject: T? = null

    init {
        wrappedObject = ob
    }

    fun print() { // Can be any complex
        // function that does something with the wrapped data here i'm just printing it
        println(wrappedObject)
    }

    fun value(): T? {
        return wrappedObject
    }
}

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T) : Resource<T>(data)

    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

    class Loading<T>(data: T? = null) : Resource<T>(data)
} // Simply copy and paste
// this in your android project and use it
package Generics

// LEARN MORE ABOUT IT AND ITS USE CASES
// It's a little higher level concept and its fully related to Generics.
//"reified" is a special type of keyword that helps Kotlin developers to access the
// information related to a class at runtime
//"reified" can only be used with inline functions.Since it is inline
// therefore while coping the code to place where the function is called the compiler
// changes the body of the function to match with the type provided during the function
// call at the runtime

fun main() {
    printType(MyClass::class.java)// This is how we pass the class Type
    printType2<MyClass>()
    typeIdentifier<String>("Shrey")
    typeIdentifier<Int>(100)

    val intCall = typeConvert<Int>(12312f)
    val doubleCall = typeConvert<Double>(12312f)
    // val doubleCall: Double = calculate(12312f) // will give exception
    println("Int Call : $intCall")
    println("Double Call : $doubleCall")


}

//fun <T> printType() {
//    print(T::class.java) // Will give error cause we cannot access the type directly ,
//                         // we have to pass it as an argument in java like we did in below function
//}

fun <T> printType(classType: Class<T>) {
    println("Class type in printType() : $classType") // But kotlin provides even better solution using
    // 'reified' keyword as shown below
}

inline fun <reified T> printType2() {
    println("Class type in printType2() : ${T::class.java.name}")
}

inline fun <reified T> typeIdentifier(name: T) {
    println("Value that you passed -> $name")
    println("Type of that value: ${T::class.java.name}")
}

class MyClass {}

inline fun <reified T> typeConvert(value: Float): T { // converts float to Double or int
    return when (T::class) { //'T::class' this would have given error if we haven't
        // used 'reified'
        Double::class -> value.toDouble() as T
        Int::class -> value.toInt() as T
        else -> throw IllegalStateException("Only works with float and int")
    }
}




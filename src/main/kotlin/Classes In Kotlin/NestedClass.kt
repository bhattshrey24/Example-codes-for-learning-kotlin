package `Classes In Kotlin`

class NestedClass {
    fun execute() {
        val o1 = OuterClass1()
        println(o1.outerName)
        val n1 = OuterClass1.NestedClass1()
        println(n1.innerName)

    }
// see this article : https://www.geeksforgeeks.org/kotlin-nested-class-and-inner-class/
// There are 2 concepts 'nested' and 'inner' class in kotlin . The nested class is basically like Static Nested Class of java and the inner class is like Non-Static Nested Class of java

    // This is an example of nested class
    class OuterClass1 {
        var outerName: String = "Shrey"

        class NestedClass1 {
            var innerName: String = "Prasoon"
            fun dummy() {
                // println(outerName)// will give compile time error cause we cannot use outer class properties and functions inside nested class since it is static

                println(OuterClass1().outerName)// we can access it by making object of outer class only
            }
        }
    }

    // This is an example of inner class
    class OuterClass2 {
        var outerName: String = "Shrey"

        inner class InnerClass {
            var innerName = outerName //  see here we can access outer class properties and functions
            var innerClassAge = 10
        }

        fun ageOfInnerClass() {
            //  println(innerClassAge) // we can not access inner class properties and methods in outer class directly
        }
    }

}
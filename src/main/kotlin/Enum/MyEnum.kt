package Enum

class MyEnum {
    // Enum is simply used to represent a group of constants , remember since its a class therefore I guess it has all properties of a class

    enum class SimpleColor { // Simple enum
        RED, // These are objects of enum class 'SimpleColor'. You'll understand how they are objects just see below class
        GREEN,
        BLUE
    }

    enum class ComplexColor1(val colorName: String, val colorVal: Int) {
        RED(
            "Red",
            100
        ), // Since these are objects of class 'ComplexColor1' therefore we have to give value to the constructor parameter
        GREEN( // They are like states , Observe we defined how the properties of Green are like its name is Green and its code is 200 so its a state
            "Green",
            200
        ),
        BLUE(
            "Blue",
            300
        )
    }

    interface DoColor {
        fun doColor()
    }

    enum class ComplexColor2(val colorName: String, val colorVal: Int) : DoColor {
        // we can even inherit interfaces , but you cannot inherit abstract class, you will get compile time error
        RED(
            "Red",
            100
        ) { // Its kind of like object/class cause see here we are overriding 'doColor' method for each state
            override fun doColor() {
                println("Coloring Red")
            }
        },
        GREEN(
            "Green", 200
        ) {
            override fun doColor() {
                println("Coloring GREEN")
            }
        },
        BLUE("Blue", 300) {
            override fun doColor() {
                println("Coloring BLUE")
            }
        };

        val a = 10 // we can even have a property inside a enum class
        fun sum() {// we can even have a method inside a enum class

        }

    }

}
package `Null safety`

class Null_Safety {
    fun execute() {
        var str: String? = "Shrey" // this way i.e. by using '?' we tell compiler this thing can be null
        println(str?.length)// this way we execute functions on variable that can be null ,
        // i.e. we have to tell compiler that this variable can be null by using ? in
        // which case if variable is actually null then it will simply remove the
        // function call or any call (like here we called variable "length") and return
        // null instead of calling on null value

        val res: Int = str?.length ?: -1 // This is elvis operator , syntax is similar to
        // ternary operator , here it means if str is null then instead
        // of returning null return -1 else simply return str.length

        val res2 = str?.let { // this is a scope function , it only executes its
            // body if object/variable on which its called is not null otherwise it returns null
            it.length // observe no need of ? here because we only reach here if str is not null
        }
        println(res2)

        val name: String? = "S" // try making it null , you will get run time null pointer
        // exception
        println(name!!.length)//this is assertion operator - only use this if uk that
        // whenever you are using the variable/object it will never be null otherwise this
        // will give null pointer exception at run time , it's like fooling compiler to think
        // that the value will never result in null
    }
}
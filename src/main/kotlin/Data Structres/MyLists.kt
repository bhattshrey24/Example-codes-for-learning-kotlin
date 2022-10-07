package `Data Structres`


class MyLists {
    fun execute() {
        arrayTest()
        arrayListTest()
        listTest()
        setTest()
    }

    // todo Must read this article : - https://medium.com/mobile-app-development-publication/kotlin-collection-functions-cheat-sheet-975371a96c4b
    private fun arrayTest() {
        println("ARRAY---------------")
        var arr = arrayOf(12, 23, 43, 15, 45, 43)
        arr[2] = 10 // assign value to a particular index
        println(arr[0])
        println("size of array ${arr.size}")
        arr.fill(10, 0, arr.size - 1) // will fill all the array with value 10

        var nullArr =
            arrayOfNulls<Int>(5) // this is same as normal aray that we
        // use in java since it can have null or empty places
        nullArr[0] = 10
        println(nullArr[2]) // Will print null

        var arr2 = intArrayOf(10)

    }

    private fun arrayListTest() {
        println("ARRAYLIST-------")
        var arrayList = ArrayList<Int>()
        arrayList.add(2)
        arrayList.add(6)
        arrayList.add(10)
        arrayList.add(11)
        println(arrayList.size)
        println(arrayList[0])
        arrayList.remove(6)
        arrayList.removeAt(1)
        println(arrayList.last())
    }

    private fun listTest() {
        println("LIST----------------")
        val imList = listOf<Int>(1, 2, 3, 4)
        val mList = mutableListOf<Int>(1, 3, 5, 7, 9, 11, 13, 15)

        //(todo) ForEach -  The forEach function can be used to iterate through collections . Basically its like doing for loop on a list
        val fe = mList.forEach { ele ->
            println(ele)
            ele * 2 // It won't make every element of the list multiplied by 2
            val double = ele * 2
            println("double of ele is : $double")
        }
        println(mList[1])
        for (myList in 0..10) {

        }


        //(todo) Filter - it is basically used to filter out elements from list

        val newFilteredList = mList.filter { ele ->
            ele > 2 // we have to provide condition here. Like here it will simply
            // filter out elements which are bigger than 2 .
            // It takes out element that returns true for the given condition
        }
        println("New Filtered list is ${newFilteredList}")

        val mList2 = mutableListOf<String>("Shrey", "Stuti", "Prateek", "Prasoon")
        val newFilteredList2 = mList2.filter { ele ->
            ele.startsWith("S") // So this will simply filter out elements in the list that starts with 'S'
        }
        println("New Filtered List 2 is $newFilteredList2")


        //(todo) Map - The map function is used to execute certain code for all items inside collection.This function
        //  returns new collection so the original collection is not changed.

        val updatedList = mList.map { ele ->
            ele * 2 // now this will simply multiply every element of the list with 2
        }
        println("New Map $updatedList")

        val updatedList2 = mList2.map { ele -> ele.uppercase() }
        println("New Map 2 $updatedList2")

        //(todo) Sum - gives the sum of the list
        println("Sum of the list is ${mList.sum()}")
        //(todo) Avg - gives the average of the list
        println("Average of the list is ${mList.average()}")
        // (todo) Binary search - we first have to sort the list else it will give undefined result
        mList.sort()
        val ans = mList.binarySearch(7, 0, mList.size)
        println("Binary search answer is $ans") // ans is the index where the element was found


        // (todo) Fold - This is an accumulator ie. it accumulates previous result and uses it to calculate new one
        val sum = listOf(1, 2, 3).fold(0) { prevSum, listItem -> prevSum + listItem } // initally 'prevSum' will take
        // the initial value ie 0 which we passed and listElement will take the 1st element of list then
        // it will perform the operation that we specified in lamda
        // then do the same for rest of list elements ie next 'prevSum' will take the
        // value that was returned by previous lambda and listItem will take next element of list and so on
        println(sum)

        val sum2 = listOf(
            1,
            2,
            3
        ).reduce { prevSum, listItem -> prevSum + listItem } // this is also same as 'fold' the difference is just that it will not
        // take the initial value


        //(todo) GroupBy - simply group the elements based on a condition and convert it to map
        val myList = listOf<Int>(1, 2, 3, 4, 5, 6, 7)
        var mapOfEvenAndOdd = myList.groupBy {
            it % 2
        } //Output =>  0=[2,4,6], 1=[1,3,7]
        println(mapOfEvenAndOdd)

        //(todo) FlatMap - Its used to sort of combine 2 or more lists into one. Just see the example below
        //   where I have to create a list of all family members of all the employee in my company to send them invitation for a party

        var listOfInvitations = employeeList.flatMap {
            it.familyMembers // we have to return a list(ie. an iterable) here
        }
        println(listOfInvitations) // will combine all family members of employee and generate a single list
        // We can achieve similar thing using normal map but that wont return simply a list instead a list of list. See below

        var listOfListOfInvitations = employeeList.map {
            it.familyMembers
        } // this will return List<List<of family members>> basically will join the lists together and not there inside content
        println(listOfListOfInvitations) // Just see the output
        // Though we can easily flatten it too using flatten() as shown below
        println(listOfListOfInvitations.flatten()) //  but instead of having these 2 lines its better to simply use FlatMap here

        // We can also perform operations on the list and add those
        val finalListOfInvitation = employeeList.flatMap { emp ->

            var withSalutation = emp.familyMembers.map { familyMemberName ->
                "Respected $familyMemberName"
            }
            withSalutation // last statement is returned. So here we returned the list that we want to merge
        } // this code will simply add combine all the family members in one list and add "Respected" in front of their names

        println(finalListOfInvitation)

    }

    data class Employee(var name: String, var age: Int, val familyMembers: List<String>)

    private val employeeList = listOf(
        Employee("Shrey", 22, familyMembers = listOf("A", "B", "C")),
        Employee("laksh", 21, familyMembers = listOf("X", "Y")),
        Employee("Dhiraj", 25, familyMembers = listOf("Q", "W", "E"))
    )


    private fun setTest() {// Set only stores unique value
        println("SET------------------")
        var imSet = setOf<Int>(1, 2, 3, 4, 5, 5, 3, 2, 4, 5)
        println("List if set element is $imSet")
        var mSet = mutableSetOf<Int>(1, 2, 3, 4, 5)
        println(imSet.elementAt(2))
        //imSet.elementAt(6)// will give error
        println(imSet.elementAtOrNull(4)) // If we are out of bound then this will not give error instead it will return null
        println(imSet.elementAtOrNull(6))

    }

}
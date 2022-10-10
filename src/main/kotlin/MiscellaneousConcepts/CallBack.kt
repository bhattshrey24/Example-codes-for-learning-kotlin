package MiscellaneousConcepts

import java.lang.Exception
import kotlin.random.Random

fun main() {
    // There maybe more method but here I have discussed important once
    println(" Running Method 1 !!!!!")
    // Method 1
    performWork("https:///.......", 1) { result ->
        // Do whatever you want to do with the result
        println("Inside Perform Work and got the result which is : $result")
        // If it was java then we would have to achieve this same functionality using interface
        // but here due to higher order function we can do it easily
    }

    println(" Running Method 2 !!!!!")
    // Method 2 (This might seem tricky but its actually easy so just read it 2-3 times. This method
    // is used a lot in android)
    // This loadDataFromServer 2 parameters , 1st is a string and 2nd is Implementation class for OnLoad interface
    loadDataFromServer("https://......",
        object : OnLoad { // This is like :- new View.OnClickListener{ public void onClick(){} } ie. we are providing
            // anonymous Implementation class as a parameter to the OnLoad interface
            override fun onSuccessful(data: String, error: Exception?) { // this will be called if we successfuly got
                // data from API otherwise below method will be called
                // here do whatever you want to do with the data
                println("Got Data : $data   and error is: $error")
            }

            override fun onError(error: Exception?) {
                // here do whatever you want to do when error occurs
                println("Oops some error occurred , error message is  : $error")
            }
        })

}

fun performWork(param1: String, param2: Int, callBack: (result: String) -> Unit) {
    // do the work like get data from network call
    val data = getDataFromRetrofit(param1)

    //Now trigger the call back
    callBack.invoke(data) // this invoke will invoke the call back
    //callBack(data) // we could also do it like this but above statement
    // makes more sense while reading
}

fun getDataFromRetrofit(site: String): String {
    return "Got the result from API : ....."
}

fun loadDataFromServer(url: String, callBack: OnLoad) {
    val data = getDataFromRetrofit2(url)
    if (data != null) {
        callBack.onSuccessful(data, null) // observe this carefully , we are calling function
        // of callback after we got result from Retrofit
    } else {// if data is null then we know error occurred
        // so we are calling the onError function of callback
        callBack.onError(Exception("Not Connected to internet"))
    }
}

fun getDataFromRetrofit2(url: String): String? {
    return if (isConnectedToInternet()) {
        "Data 123 " // just giving some random data
    } else {
        null
    }
}

fun isConnectedToInternet(): Boolean { // this is just mimicking real world scenario error where
    // it might be possible that user is not connected to internet so to mimic that I'm just using
    // a random number
    val randumNum = (1..2).random()
    return randumNum == 1 // means if 1 so he is connected if not equal to 1 ie. if it is 2
// then not connected
}

interface OnLoad {
    fun onSuccessful(data: String, error: Exception?)
    fun onError(error: Exception?)
}

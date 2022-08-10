package `Sealed Class`

class MySealedClass {
    //I have a little doubt in use of this , so read a little more about it

    fun execute() {
        //val ob = NetworkState() // This will give compile time error cause we cannot directly make objects of sealed class just like abstract class
        val dataFromApi = getData()

        // See one of the major use cases of sealed class is that in 'when' we do not have to add an else branch , otherwise we have to add an else branch or else we get compile time error
        when (dataFromApi) {
            is NetworkState.Success -> {}
            is NetworkState.Error -> {}
            is NetworkState.Loading -> {}
        }
    }

    fun getData(): NetworkState {
        return NetworkState.Success(100)
    }

    // Generally sealed class is used to manage different states of a network call
    // We can only inherit sealed class in the same file and not outside like we can inherit this NetworkState class in just this file and not anywhere else. This way it makes limited hierarchy
    sealed class NetworkState() {
        data class Success(val data: Int) : NetworkState()
        data class Error(val data: Int, val error: String) : NetworkState()
        class Loading() : MySealedClass.NetworkState()
    }

    data class Dummy1(val data: Int) : NetworkState() // see we can inherit NetworkState outside it
}

class Dummy2() : MySealedClass.NetworkState()
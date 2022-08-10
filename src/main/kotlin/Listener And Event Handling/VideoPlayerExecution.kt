package `Listener And Event Handling`

class VideoPlayerExecution :
    VideoPlayerInterface { // implementing the VideoPlayerInterface ie. this class is implementation of VideoPlayerInterface

    init {// called when object of this class is made

        var videoPLayer: VideoPlayer = VideoPlayer()

        // before using callback we have to first attach/add the listener ie. tell listener to start listening

        videoPLayer.addListener(this)// passing 'this' means that passing this class ie. VideoPlayerExecution ie. the class that has implemented VideoPlayerInterface

        videoPLayer.release()// Now you want a callback here in VideoPlayerExecution from the VideoPlayer class when it's done releasing the resources(Basically you want Class B to tell Class A when it's done doing its work , See you called a function of class B so you triggered Class B from class A by calling the function on Class B's Object but how to trigger Class A from Class B's function now ie. how to communicate from class B to class A now? Here comes the Custom Listeners)

        println("YOOOOO")// this will be executed after the callback is fired that is after onResourcesReleased() is done
        // See you called 'release' function of VideoPlayer class from this class using object of VideoPLayer class and got the callback when it's done releasing from VideoPlayer Class
    }

    fun displayGoodbye() {
        println("Goodbye!!!!!!!!!!!!!!!")
    }

    override fun onResourcesReleased() {// this is the callback function ie. this will be triggered when VideoPLayer class is done releasing resources so that you can do whatever you wanted to do after resources are released by VideoPlayer like here we wanted to display goodbye message , see since you are in VideoPlayerExecution class you can use any variable or function of this class here
        displayGoodbye()// see we are calling function of VideoPlayerExecution class
    }
}
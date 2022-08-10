package `Listener And Event Handling`

import java.lang.ref.WeakReference

// See this video https://www.youtube.com/watch?v=_a3axw2LF0A
class VideoPlayer {
    // just assume this is a class that manages video player

    private var listener: WeakReference<VideoPlayerInterface>? = null//ie. initially it is initialized with null

    // Weak reference is basically used for memory efficiency cause suppose if VideoPlayer class is done its work and is suppose to be released/deleted from memory then if we had strong reference then listener won't let the class to be released but weak reference let's the class to be relased
    fun start() {
        println("Video Started")
    }

    fun stop() {
        println("Video Stopped")

    }
 // The EVENT is finishing of releasing of the resources

    fun release() {// releases the resources taken up by videoplayer
        println("Starting releasing")
        println("releasing...")
        println("Last resource is also released")
        println("All resources are released successfully")

        // The get() is because we used weak reference, if we remove the weak reference wrapper class then we dont need to use get()
        listener?.get()
            ?.onResourcesReleased()//This is the EVENT . we
    // are telling this to all listeners that event has occurred ie. calling the
    // callback function to notify the VideoPlayerExecution class that VideoPlayer Class released the resources.
    // get() basically returns the object to which the reference is referencing on which we called it like here we
    // called it on 'listener' variable just hover over it and see it's explanation

    }

    fun addListener(listener: VideoPlayerInterface) { // We are attaching the listener basically this will be
        // implemented by any class that is interested in knowing when the resources are released.
        // see here the object that will be passed will basically be the object of the class that implemented
        // VideoPlayerInterface and we are using the interface reference to hold it cause interface reference can
        // hold object of its implementation class this is the benefit of using interface

        this.listener = WeakReference(listener) // simply attaching the listener variable of this class to
    // the listener variable passed as an argument

        // 'this' to tell that we are referring to the listener variable of 'this' class , this is because
    // the name of the function's argument is same as the listener variables name
    }
}
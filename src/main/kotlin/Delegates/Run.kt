package Delegates

// delegating means delegating the responsibilities to other objects
// delegation pattern is a normal OOPS concept that can be applied in
// any object-oriented language but kotlin provides additional 'by' keyword for delegation

// In this example I have shown both ways in which we can implement
// delegation ie. normally and then by using 'by' keyword

// After this see the KotlinsDelegateExample app
    fun main() {
    // here we are just mimicking that we are downloading a file and then playing it

        val file: String = "Dance Video.mp4"
        val mediaFile = MediaFile(FileDownloader(file), FilePlayer(file)) // Normal implementation of delegation pattern
        mediaFile.download()
        mediaFile.play()

        val mediaFile2 = MediaFile2(FileDownloader(file), FilePlayer(file)) // delegate implementation using 'by' keyword
        mediaFile2.download()
        mediaFile2.play()

    }

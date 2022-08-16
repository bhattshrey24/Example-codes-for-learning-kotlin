package Delegates

class MediaFile(private val downloader: Downloader, private val player: Player) : Downloader, Player {
    override fun download() {
        downloader.download() // see we are delegating the
        // work to 'download' object. This how we can implement delegation
        // in other object-oriented programing languages
    }

    override fun play() {
        player.play()
    }
}
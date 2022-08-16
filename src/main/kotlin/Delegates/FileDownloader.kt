package Delegates

class FileDownloader(private val file:String):Downloader {
    override fun download() {
        println("$file downloading!!!!!")
    }
}
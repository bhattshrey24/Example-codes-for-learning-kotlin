package Delegates

class MediaFile2
    (private val downloader: Downloader, private val player: Player)
    : Downloader by downloader, Player by player // compare this
    // with 'MediaFile' class . Both are doing the same work but due to kotlin's native
     // support to delegation using 'by' keyword it has reduced so much of boilerplate code
package com.example.myfirstapplication.kotlinOOP


interface DownloadListener {
    fun onDownloadStarted()
    fun onDownloadCompleted(file: String)
    fun onProgress(progress: Int)
}

class FileDownloader {
    var downloadListener: DownloadListener? = null

    fun downloadFile() {
        downloadListener?.onDownloadStarted()
        for (index in 0..10) {
            Thread.sleep(500)
            downloadListener?.onProgress(index * 10)
        }
        downloadListener?.onDownloadCompleted("Songs.pk")
    }
}

class ProcessDownload : DownloadListener {
    override fun onDownloadStarted() {
        println("Download Started")
    }

    override fun onDownloadCompleted(file: String) {
        println("Downlaod completed: $file")
    }

    override fun onProgress(progress: Int) {
        println("Downloading% : $progress")
    }
}
// To work as a listener we can use interface, lambda, object->anonymous inner class
// Here we did it with ProcessDownload class, inheriting interface, next we do it directly
/*
fun main(){
    val processDownload=ProcessDownload()
    val fileDownloader=FileDownloader()
    fileDownloader.downloadListener=processDownload
    fileDownloader.downloadFile()
}*/


// Here we will do it with anonymous inner class
fun main() {
    val fileDownloader = FileDownloader()
    fileDownloader.downloadListener = object : DownloadListener {
        override fun onDownloadStarted() {
            println("Download Started")
        }

        override fun onDownloadCompleted(file: String) {
            println("Downlaod completed: $file")
        }

        override fun onProgress(progress: Int) {
            println("Downloading% : $progress")
        }
    }
    fileDownloader.downloadFile()
}

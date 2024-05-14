package com.example.myfirstapplication.kotlinOOP

interface MusicDownloadListener {
    fun onDownloadStart()
    fun onProgress(progress: Int)
    fun onDownloadComplete(data: String)
}

class MusicOperation {
    private var musicDownloadListener: MusicDownloadListener? = null

    fun setListener(listener: MusicDownloadListener) {
        musicDownloadListener = listener
    }

    fun downloadMusic() {
        musicDownloadListener?.onDownloadStart()

        for (i in 0..10) {
            Thread.sleep(500)
            musicDownloadListener?.onProgress(i * 10)
        }

        musicDownloadListener?.onDownloadComplete("Tick Toc song done")
    }
}

class MonitorDownload : MusicDownloadListener {
    override fun onDownloadStart() {
        println("Download Started")
    }

    override fun onDownloadComplete(data: String) {
        println("Download completed $data")
    }

    override fun onProgress(progress: Int) {
        println("Progress%: $progress")
    }
}

fun main() {
    /*val monitorDownload = MonitorDownload()
    val musicOperation = MusicOperation().run {
        setListener(monitorDownload)
        downloadMusic()
        this
    }*/

    // Using Anonymous class
    val monitorDownload = object : MusicDownloadListener {
        override fun onDownloadStart() {
            println("Download Started")
        }

        override fun onDownloadComplete(data: String) {
            println("Download completed $data")
        }

        override fun onProgress(progress: Int) {
            println("Progress%: $progress")
        }
    }
    val musicOperation = MusicOperation().let {
        it.setListener(monitorDownload)
        it.downloadMusic()
        it
    }
}
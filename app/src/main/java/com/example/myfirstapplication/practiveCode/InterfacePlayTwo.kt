package com.example.myfirstapplication.practiveCode

interface Downloader{
    fun version(){
        println("2.1.1")
    }
    // by default abstract, if not mentioned anything and no body given
    fun downloaderName()
}

interface Players{
    fun play()
    fun playerName()
}

// NO need of paranthesis in inherited part
class AudioVideoPlayer(private val play:String="Real"): Downloader,Players{
    override fun downloaderName() {
        println("Realtek")
    }

    override fun play() {
        println("Oh ho ho ho")
    }

    override fun playerName() {
        println("SONY $play")
    }
}

fun main(){
    val obj:AudioVideoPlayer=AudioVideoPlayer()
    obj.version()
    obj.downloaderName()
    obj.play()

    // If assigned type is Players then only play and playerName are accessable
}
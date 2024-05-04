package com.example.myfirstapplication.practiveCode

// Interface cannot have init and constructor which abstract can have

abstract class Downloader1{
    init {
        println("Downloader1 initialized")
    }
    abstract fun playMusic()

    fun versionNo(){
        println("2.1.212")
    }
}

abstract class Player{
    abstract fun playerName()
    fun name(){
        println("Sony music cds")
    }
}

// while inheriting you need constructor i.e Downloader1(), but in interface no need Downloader1
// We can inherit only 1 class, so we cannot use player here, here comes interface in play to help us
class VideoPlayer: Downloader1() {
    override fun playMusic() {
        println("Na na na anaan na")
    }
}

class AudioPlayer: Downloader1() {
    override fun playMusic() {
        println("Audio ajajj ajaj")
    }
}

fun main(){
    // Playing with abstract class
    val obj:Downloader1=VideoPlayer()
    obj.playMusic()
    obj.versionNo()

    // see we are giving type of parent
    val obj1:Downloader1=AudioPlayer()
    obj1.playMusic()
    obj1.versionNo()
}
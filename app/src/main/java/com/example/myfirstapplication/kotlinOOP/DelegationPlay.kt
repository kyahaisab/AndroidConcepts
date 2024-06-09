package com.example.myfirstapplication.kotlinOOP

interface VirusDownloader {
    fun downloadVirus()
}

interface VirusAttack {
    fun attack()
}

class DownloadChinaVirus : VirusDownloader {
    override fun downloadVirus() {
        println("Corona Virus Download")
    }
}

class VirusAttackOnAmerica : VirusAttack {
    override fun attack() {
        println("Attacked, Joe Biden killed")
    }
}

// This is called delegation pattern, as we are delegating our responsibilities to download and attack (other objects)
class VirusProcessing(private val download: VirusDownloader, private val attack: VirusAttack) :
    VirusDownloader, VirusAttack {
    override fun downloadVirus() {
        download.downloadVirus()
    }

    override fun attack() {
        attack.attack()
    }
}

// Now Kotlin supports delegation directly
class VirusProcessing1(private val download: VirusDownloader, private val attack: VirusAttack) :
    VirusDownloader by download, VirusAttack by attack

fun main() {
    /*val virusProcessing=VirusProcessing(DownloadChinaVirus(), VirusAttackOnAmerica())
    virusProcessing.downloadVirus()
    virusProcessing.attack()*/

    // Delegation
    val virusProcessing1 = VirusProcessing1(DownloadChinaVirus(), VirusAttackOnAmerica())
    virusProcessing1.downloadVirus()
    virusProcessing1.attack()
}


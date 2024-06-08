package com.example.myfirstapplication.amitSekhar.shortQuestions

internal class Sessions(val name: String, val date: String = "23/12/2024")

internal class SessionCall @JvmOverloads constructor( // becz internally it will generate overloads for us
    val name: String,
    val date: String = "23/12/2024"
)

fun main() {
    val session1 = Sessions("Sagar") // one can leave date assign, as it is default assign
    // But, say one wants call this code from java class val session2=new Sessions("Sagar") it will through error

    // now one can use SessionCall default param advantage
    val sessionCall=SessionCall("Ramu")
    // Also one can call this from java class sessionsCall=new SessionCall("Ramu") it works perfectly fine
}


// When only onDestroy is called for an activity without onPause() and onStop()?
// Ans: when we use finish in onCreate block
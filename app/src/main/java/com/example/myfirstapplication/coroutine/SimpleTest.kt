package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.testng.Assert

class SimpleTest {
    @Test
    fun myFirstTest() = runBlocking {
        mySuspendFunction() // can't be called directly, to test suspending fun run it inside runBlocking
        Assert.assertEquals(10, 3 + 7)
    }
}
package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
VIEW MODEL:
view model cache the state and date and persist it during configuration changes(like orientation changes-> screen rotation)
When you rotate screen you don't need to make network call again.
It is lifecycle aware->VM destroyed when owner of VM is permanently destroyed-> when we rotate screen activity not permanent
destroys so VM persist but when we finish activity and move to next activity then VM destroys.
If not using VM we need to cache data at some point like savedinstancestate(used to store small data only)
 */

/*
Is it possible to force Garbage Collection in Android-> Ans-> NO
java.lang.outOfMemoryIssue -> biggest nightmare due to memory leak or loading large bitmaps
So no way to force g collection-> System.gc() -> its just making request its up to jvm it can or cannot delay our request.
Best practice is to find the issue(memory leak etc) and solve it.
 */

/*
JVM Static:
Say you want to call a inside singleton of kotlin, from java code, its not possible, so use @jvmstatic(so compiler will
generate additional static method for us)
 */

/*
init block:
In a class A primary constructor cannot contain any code operation, but secondary constructor can.
Init block executes after primary but before secondary constructor. There can be multiple init blocks and they appear in
same sequence as they appear in class body.
When to use it: when you want to call something at starting of class eg.
 */
class NewsListViewModel() {
    init {
        fetch()
    }

    private fun fetch() {
        // call repo
    }
}

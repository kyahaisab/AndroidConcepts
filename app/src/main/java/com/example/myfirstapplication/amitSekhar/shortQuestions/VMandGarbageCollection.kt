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

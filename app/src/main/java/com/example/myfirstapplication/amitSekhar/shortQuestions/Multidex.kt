package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
Q. What is multidex in android?
Ans. Android developers write the code in kotlin or Java but whenever we build the APK those kotlin
or the Java code get converted into byte code and those byte code gets stored inside a dex file and whenever
you analyze the APK you will see that there are dex files and it is named as classes.dex so you can check classes.dex classes2.dex
something like that. So in our APK we can haven n number of dex files one two three four five and so on that number depends on the
number of methods present in our code base or the libraries or the framework that you have used to build the project so that
will depend on the number of methods that you you have used to build the project.
One index file can have maximum of 64k method and here K is kilo which is 1024 not 1000 so 64k
will come out six five five three six sixty five thousand five hundred thirty six and if we are going to create an
APK from the project if we are going to have more than 64k methods so in that case it will create more than one Dex
file and you can just check it by dragging and dropping the APK in your Android Studio

Always analyze apk where you have applied pro-guard or R8 rules. if your app has more than one dex file it means that we call it as multi dex
If your sdk is 21 or more its automatically applied, but if its less thank that then do it manually

Disadvantages:
1. First disadvantage it can increase the app startup time why because it has to load more than one Dex file that
is why it can increase the app startup time. for that also we do have various Solutions which we can Implement to again decrease the app startup time
so that is why I will recommend do not hesitate to use the multi decks in yourAndroid application if required
2. no class div found error: Suppose we have 2 dex file first dex contains 4 classes and second dex contains 5th dex. Say during
launch first dex is loaded and our primary class need reference of 6th class as well, but that is in our 2nd dex file, So
that is yet not loaded, so it will through this error. Its sol is that we can force the 5th class to present in 1st dex file
by writing a rule.
*/
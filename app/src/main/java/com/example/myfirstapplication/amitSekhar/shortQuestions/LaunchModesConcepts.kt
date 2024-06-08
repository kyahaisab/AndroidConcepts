package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
We use launch mode to give instructions to the Android operating system about how to launch the activity
and there are various types of launch mode in Android.
-launchMode="singleTask"

Assume we have activities A,B,C,D,E and we have set launchMode="singleTask" for C,
Ex1: In activity stack we have A->B, now launch C, so our activity stack will be like A->B->C
Ex2: Say in stack we have A->B->C->D->E, now launch C, new stack will be A->B->C
Note in Ex2: Here activity C is old instance that gat extras data through onNewIntent().
             Activity D, E gets destroyed
 */
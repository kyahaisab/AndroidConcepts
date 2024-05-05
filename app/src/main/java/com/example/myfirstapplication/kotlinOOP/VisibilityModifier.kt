package com.example.myfirstapplication.kotlinOOP

/*
* By default everything is public.
* Modifiers-> public, private, protected, internal.
* Note setter can be private and getter achieves the same property as of variable,
* if vol is private then getter is also private.
* */
class Boxing {
    private var length:Int=4
    private var breadth:Int=34
    private var height:Int=13

    var vol:Int =1
        private set(value) {
            field=value
        }
}
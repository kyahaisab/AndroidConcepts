package com.example.myfirstapplication.amitSekhar.shortQuestions

class Mentor {

}

//Lateinit: We don't initialize variable at time of declaration, but we initialize it before use.
//Can only be used with non nullable variable

// One way to achieve it:
private var mentorOne: Mentor? = null

// Other way or lateinit way
private lateinit var mentorTwo: Mentor

// Study lazy in standardDelegate in OOP module

// Note: Both are used with val only
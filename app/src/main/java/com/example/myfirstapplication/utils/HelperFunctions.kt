package com.example.myfirstapplication.utils

import android.content.Context
import android.view.View

fun View.click(touch: (View) -> Unit) {
    this.setOnClickListener {
        touch(it)
    }
}

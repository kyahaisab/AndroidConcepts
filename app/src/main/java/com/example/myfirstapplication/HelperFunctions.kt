package com.example.myfirstapplication

import android.view.View

fun View.click(touch: (View) -> Unit) {
    this.setOnClickListener {
        touch(it)
    }
}

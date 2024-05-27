package com.example.myfirstapplication

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.example.myfirstapplication.servicesProject.activities.StartedServiceActivity

fun View.click(touch: (View) -> Unit) {
    this.setOnClickListener {
        touch(it)
    }
}

package com.example.myfirstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val items = listOf(
            Item(ItemType.HEADER, "Header 1"),
            Item(ItemType.CONTENT, "Content 1"),
            Item(ItemType.CONTENT, "Content 2"),
            Item(ItemType.HEADER, "Header 2"),
            Item(ItemType.CONTENT, "Content 3"),
            Item(ItemType.CONTENT, "Content 4")
        )

        val adapter = ComplexAdapter(items) { item ->
            Toast.makeText(this, "Clicked: ${item.text}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
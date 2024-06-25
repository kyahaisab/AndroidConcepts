package com.example.myfirstapplication.recyclerViews

data class Item(
    val type: ItemType,
    val text: String
)

enum class ItemType {
    HEADER,
    CONTENT
}
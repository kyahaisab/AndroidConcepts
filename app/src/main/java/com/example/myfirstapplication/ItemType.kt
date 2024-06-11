package com.example.myfirstapplication

data class Item(
    val type: ItemType,
    val text: String
)

enum class ItemType {
    HEADER,
    CONTENT
}
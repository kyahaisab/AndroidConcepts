package com.example.myfirstapplication.practiveCode

sealed class Data {
    data class Success(val result: String) : Data()
    data class Error(val result: String) : Data()
    object Loading : Data()
}

enum class ResultCode {
    SUCCESS,
    ERROR,
    LOADING
}

fun getData(status: ResultCode): Data {
    when (status) {
        ResultCode.SUCCESS -> return Data.Success((10..15).random().toString())
        ResultCode.ERROR -> return Data.Success((0..5).random().toString())
        ResultCode.LOADING -> return Data.Success("0")
    }

}

fun main() {
    val data = getData(ResultCode.SUCCESS)
    when (data) {
        is Data.Success -> println(data.result)
        is Data.Error -> println(data.result)
        is Data.Loading -> println(data)
    }
}
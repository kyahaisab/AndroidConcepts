package com.example.myfirstapplication.kotlinOOP.pattern

/*
Factory pattern, we create object without exposing the creation logic to the client and refer to
newly created object using a common interface.
 */

interface Notification {
    fun show(message: String)
}

// ************************************************************************************************
// Activity not required, can show in android home, non interactive
class ToastNotification(private val context: String) : Notification {
    override fun show(message: String) {
        println("This is a Toast Message: $message")
    }
}

// Can be dismissed by swiping, can be shown inside activity of app, can handle user input (like undo)
class SnackBarNotification(private val view: String?) : Notification {
    override fun show(message: String) {
        println("This is a Snack Message: $message")
    }
}

// Its a dialog box, Interactive
class DialogNotification(private val context: String) : Notification {
    override fun show(message: String) {
        println("This is a Dialog Message: $message")
    }
}
// ************************************************************************************************

class NotificationFactory {
    fun createNotification(type: String, context: String, view: String?): Notification {
        return when (type) {
            "Toast" -> ToastNotification(context)
            "SnackBar" -> SnackBarNotification(view)
            "Dialog" -> DialogNotification(context)
            else -> throw IllegalArgumentException("This type is not present here")
        }
    }
}
// ************************************************************************************************

fun main() {
    val factory = NotificationFactory()
    val notificationOption = "SnackBar" // change it to SnackBar, Dialog

    val notification = when (notificationOption) {
        "Toast" -> factory.createNotification(notificationOption, "this", null)
        "SnackBar" -> factory.createNotification(notificationOption, "null", "layout")
        "Dialog" -> factory.createNotification(notificationOption, "this", null)
        else -> {
            // Just to run code
            factory.createNotification(notificationOption, "this", null)
        }
    }
    notification.show("Hello Team !!!")
}
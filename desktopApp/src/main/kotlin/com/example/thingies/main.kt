package com.example.thingies

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application(exitProcessOnExit = true) {
    Window(
        onCloseRequest = ::exitApplication,
        title = "thingies",
    ) {
        App()
    }
}
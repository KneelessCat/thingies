package com.example.thingies.`interface`

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


// We could maybe change this so it doesn't take a variable?
// Maybe we just leave this as Screens() and force the start to be Main
// Will leave like this for now just for debugging
class Navigator(val startingScreen : Page) {
    //private var currentScreen : Page = startingScreen

    var currentScreen by mutableStateOf(startingScreen)
        // Makes the setter private
        private set

    fun navigateToPage(page: Page) : Unit {
        currentScreen = page
    }

    fun getPage() : Page = currentScreen

}
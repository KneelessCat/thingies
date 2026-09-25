package com.example.thingies

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.thingies.`interface`.AppThemer
import com.example.thingies.`interface`.Navigator
import com.example.thingies.`interface`.Page
import com.example.thingies.screens.Components.lightDarkButton
import com.example.thingies.screens.MainMenuScreen
import com.example.thingies.viewmodel.MainMenuViewModel


fun redirect(btxt: String): Unit {
    val redirectstr: String = btxt.lowercase().replace(' ', '_').plus(".kt")

    println(redirectstr)
}

@Composable // Declares the function as a building block to a Compose app
@Preview
// This main function will be where we keep track of the navigation variable
fun App() {

    var lightMode by remember { mutableStateOf(true) }

    var navDirector = remember { Navigator(Page.MAIN) }

    var mainMenuVM = remember { MainMenuViewModel() }


    fun toggleLightMode() {
        lightMode = !lightMode
    }

    fun goToPage(page: Page) {
        navDirector.navigateToPage(page)
        println(navDirector.getPage().toString())
    }

    AppThemer(lightMode = lightMode)
    {
        when (navDirector.getPage()) {
            Page.MAIN ->
                MainMenuScreen(
                    mainMenuVM,
                lightMode,
                    {lightDarkButton(lightMode, { toggleLightMode() } )},
                { goToPage(Page.CALC) },
                { goToPage(Page.TICTAC) },
                { goToPage(Page.CHESS) },
                { goToPage(Page.TYPESPD) },

            )

            Page.CALC -> println("We should now be in calc")
            Page.TICTAC -> TODO()
            Page.CHESS -> TODO()
            Page.TYPESPD -> TODO()
        }
    }

}
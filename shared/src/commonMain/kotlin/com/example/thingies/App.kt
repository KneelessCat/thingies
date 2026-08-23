package com.example.thingies

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import thingies.shared.generated.resources.Res
import thingies.shared.generated.resources.compose_multiplatform

@Composable // Declares the function as a building block to a Compose app
@Preview
fun App() {
    // MaterialTheme() sets the look of the application
    MaterialTheme {
        // The 'by remember' is how the program remembers to keep the content shown/hidden
        // Whenever the value of showContent changes, any composables that observe it are re-invoked (recomposed)
        var showContent by remember { mutableStateOf(false) }

        // Columnm() controls the layout of the application
        // Colum() displays the button above the AnimatedVisbility() composable
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Inverts the current value of show content when clicked
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            // Observes showContent, so whenever is it changed it is recomposed
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    // Loads the xml file "compose_multiplatform.xml"
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}
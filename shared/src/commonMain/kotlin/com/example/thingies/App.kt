package com.example.thingies

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import thingies.shared.generated.resources.Res
import thingies.shared.generated.resources.compose_multiplatform
import kotlin.time.Clock


fun todaysDate(date: Boolean): String {
    // Gets current time
    val now = Clock.System.now()
    val zone = TimeZone.currentSystemDefault()

    // This removes the T that splits the dd/mm/yyyy and the hh/mm/ss times
    // Format typically looks like yyyy-mm-ddThh/mm/ss.ms (ms extends for 9 digits) - we remove this in the h/m/s display
    // We use the boolean value date to determine if we return y/m/d or h/m/s
    if (date) {
        return now.toLocalDateTime(zone).toString().substringBefore('T')
    }
    else {
        return now.toLocalDateTime(zone).toString().substringAfter('T').substringBefore('.')
    }
}

@Composable // Declares the function as a building block to a Compose app
@Preview
fun App() {
    // MaterialTheme() sets the look of the application
    // MaterialTheme {

    var lightMode by remember { mutableStateOf(true) }

    // Here we set our theme to be light or dark mode
    AppThemer(lightMode) {
        // The 'by remember' is how the program remembers to keep the content shown/hidden
        // Whenever the value of showContent changes, any composables that observe it are re-invoked (recomposed)
        var showContent by remember { mutableStateOf(false) }

        // Columnm() controls the layout of the application
        // Colum() displays the button above the AnimatedVisbility() composable
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Displays current date
            Text(
                text = "Today's date is ${todaysDate(true)} and the time is ${todaysDate(false)}",
                modifier = Modifier.padding(20.dp),
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )

            // Inverts the current value of show content when clicked
            Button(onClick = { showContent = !showContent /*; lightMode = !lightMode }*/ }) {
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
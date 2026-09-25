package com.example.thingies.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thingies.viewmodel.MainMenuViewModel


/*
 * We want to create the main menu, that essentially will look like the following:
 *
 * The top section should contain the title, centred
 *
 * The middle section should contain a navigation bar with:
 * 		two minimum rows, four max
 * 		flexible columns that are calculated automatically
 *
 * The bottom section should contain on the left a toggling between dark and light mode
 * For this dark/light mode, we need to create a way to get colours based on the value.
 * We do however need to be careful that implementation does not run an if check EVERY call on say some method getColourScheme.foreground() or something.
 *
 */


@Composable // Declares the function as a building block to a Compose app
//@Preview - breaks with parameters in the function
// Passes in the lm = true/false if we are in light mode
// tlight = toggles light and dark mode
fun MainMenuScreen(
    vm: MainMenuViewModel,
    lm: Boolean,
    lightDarkButton: @Composable () -> Unit,
    goToCalc: () -> Unit,
    goToTicTac: () -> Unit,
    goToChess: () -> Unit,
    goToTypeSpeed: () -> Unit
)

{
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    )

    {
        Text(
            text = "Thingies app!",
            modifier = Modifier.padding(20.dp),
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )


        FlowRow(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .safeContentPadding()
                .fillMaxWidth(0.6f),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,

            )

        {
            // Here is where we do our buttons
            // For now hard code them, but we should get the attributes from another source
            for (buttonText in vm.buttonTexts) {
                Button(
                    // Change this so we redirect appropriately
                    onClick = { goToCalc() },
                    shape = RoundedCornerShape(35),
                    // TODO: Dynamically change the padding based on screen size
                    modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp),
                    contentPadding = PaddingValues(5.dp),
                ) { Text(buttonText) }
            }
        }

        lightDarkButton()
    }
}
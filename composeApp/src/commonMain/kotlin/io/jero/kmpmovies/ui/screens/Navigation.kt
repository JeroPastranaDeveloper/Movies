package io.jero.kmpmovies.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
   val navController = rememberNavController()

}

object Screen {
    @Serializable
    object One

    @Serializable
    data class Two(val param: String)
}
package com.example.conversify.Screens

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.conversify.Screen

@Composable
fun SignUpScreen(navController: NavController) {
    Text(text = "Hi Myself Imran Click to go back", modifier = Modifier.clickable {
        // Handle click event here
        navController.navigate(Screen.LogIn.route)
    })
}
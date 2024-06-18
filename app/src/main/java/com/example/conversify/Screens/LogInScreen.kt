package com.example.conversify.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.conversify.CFViewModel
@Composable
fun LogInScreen(navController: NavController, viewModel: CFViewModel){
    Text(text = "Hello How Are you", modifier = Modifier
        .background(Color.Red)
        .clickable {
            navController.navigateUp()
        }
    )
}
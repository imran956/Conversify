package com.example.conversify.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.conversify.CFViewModel
import com.example.conversify.CommonProgressBar
import com.example.conversify.R
import com.example.conversify.Screen
import com.example.conversify.navigateTo

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: CFViewModel
) {


    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var nameState by remember {
                mutableStateOf(TextFieldValue())
            }
            var numberState by remember {
                mutableStateOf(TextFieldValue())
            }
            var emailState by remember {
                mutableStateOf(TextFieldValue())
            }
            var passwordState by remember {
                mutableStateOf(TextFieldValue())
            }

            val focusManager = LocalFocusManager.current

            Image(
                painter = painterResource(id = R.drawable.social),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 16.dp)
                    .padding(8.dp)
            )

            Text(
                text = "Sign Up",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)

            )

            OutlinedTextField(
                value = nameState,
                onValueChange = { nameState = it },
                label = { Text(text = "Name") },
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = numberState,
                onValueChange = { numberState = it },
                placeholder = { Text(text = "Number") },
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = emailState,
                onValueChange = { emailState = it },
                label = { Text(text = "Email") },
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = passwordState,
                onValueChange = { passwordState = it },
                label = { Text(text = "Password") },
                modifier = Modifier.padding(8.dp)
            )

            Button(
                onClick = {
                    viewModel.signUp(
                        name = nameState.text,
                        number = numberState.text,
                        email = emailState.text,
                        password = passwordState.text
                    )
                },
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = " Sign Up ")
            }

            Text(
                text = "Already have an account? Login",
                color = Color.Cyan,
                modifier = Modifier.clickable {
//                    navController.navigate(Screen.LogIn.route)
                    navigateTo(navController, Screen.LogIn.route)
                }
            )
        }

    }
    if (viewModel.isProcessing.value) {
        CommonProgressBar()
    }
}

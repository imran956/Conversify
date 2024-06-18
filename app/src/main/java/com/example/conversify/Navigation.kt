package com.example.conversify


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.conversify.Screens.LogInScreen
import com.example.conversify.Screens.SignUpScreen

/*@AndroidEntryPoint
class EntryPoint : AppCompatActivity() {
    val viewModel : CFViewModel by viewModels()
}*/
@Composable
fun ChatAppNavigation() {
    val navController = rememberNavController()
    /*Context: This approach is used within Composable functions that are part of a Jetpack Compose Navigation graph.
    but may be it will create memory leak due to lifecycle problem insted u can use individual view model for each screen
    like val signUpViewModel:CFViewModel = hiltViewModel() and logInViewModel:CFViewModel = hiltViewModel()*/
    val viewModel = hiltViewModel<CFViewModel>()
    /*var vm:CFViewModel = hiltViewModel()*/
    /*var viewModel = EntryPoint().viewModel*/


    NavHost(navController = navController, startDestination = Screen.SignUp.route) {

        composable(Screen.SignUp.route) {
            SignUpScreen(navController,viewModel)
        }
        composable(Screen.LogIn.route) {
            LogInScreen(navController,viewModel)
        }
    }
}
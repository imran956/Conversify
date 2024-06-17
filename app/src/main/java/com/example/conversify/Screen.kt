package com.example.conversify

sealed class Screen(val route: String) {
    object SignUp : Screen("signUp")
    object LogIn : Screen("login")
    object Profile : Screen("profile")
    object ChatList : Screen("chatList")
    object SingleChat : Screen("singleChat/{chatID}"){
        fun createRoute(id: String) = "singleChat/$id"
    }

    object StatusList : Screen("statusList")
    object SingleStatus : Screen("singleStatus/{userID}"){
        fun createRoute(userID: String) = "singleStatus/$userID"
    }
}
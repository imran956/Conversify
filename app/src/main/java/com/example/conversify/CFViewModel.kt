package com.example.conversify

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CFViewModel @Inject constructor(
    private val auth: FirebaseAuth
): ViewModel() {

    init {

    }

    val isProcessing = mutableStateOf(false)
    val eventMutableState = mutableStateOf<Event<String>?>(null)


    fun signUp(name: String,number: String, email: String, password: String){
        isProcessing.value = true
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
            if (it.isSuccessful){
                Log.d("TAG","signUp: success")
            }else{

            }
        }

    }

    fun handleException(exception: Exception?=null, customMessage: String = ""){
        Log.e("LiveChatApp", "Live Chat Exception: ", exception)
        exception?.printStackTrace()
        val errorMessage = exception?.localizedMessage ?: ""
        val message = if (customMessage.isNullOrEmpty()) errorMessage else customMessage
        /*Log.e("LiveChatApp", message)*/
        eventMutableState.value = Event(message)
        isProcessing.value = false
    }
}

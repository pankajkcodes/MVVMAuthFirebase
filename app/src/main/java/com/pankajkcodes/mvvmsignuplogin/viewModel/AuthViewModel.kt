package com.pankajkcodes.mvvmsignuplogin.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pankajkcodes.mvvmsignuplogin.repository.AuthRepository
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val authRepository: AuthRepository =
        AuthRepository()

    val userData: MutableLiveData<FirebaseUser?>? =
        authRepository.firebaseUserMutableLiveData

    val userStatus: MutableLiveData<Boolean>? =
        authRepository.logInUserMutableLiveData


    fun register(email: String?, pass: String?) {
        authRepository.registerUser(email, pass)
    }

    fun login(email: String?, pass: String?) {
        authRepository.loginUser(email, pass)
    }

    fun signOut() {
        authRepository.logOut()
    }

}
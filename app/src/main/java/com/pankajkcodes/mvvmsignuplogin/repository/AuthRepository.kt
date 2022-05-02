package com.pankajkcodes.mvvmsignuplogin.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.FirebaseAuth

class AuthRepository {
    var firebaseUserMutableLiveData: MutableLiveData<FirebaseUser?>? = null
    var logInUserMutableLiveData: MutableLiveData<Boolean>? = null

    private var auth: FirebaseAuth? = null


    init {
        firebaseUserMutableLiveData = MutableLiveData()
        logInUserMutableLiveData = MutableLiveData<Boolean>()
        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser != null) {
            firebaseUserMutableLiveData!!.postValue(auth!!.currentUser)
        }
    }

    fun registerUser(email: String?, pass: String?) {
        auth?.createUserWithEmailAndPassword(email!!, pass!!)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                firebaseUserMutableLiveData!!.postValue(auth!!.currentUser)
            }
        }
    }

    fun loginUser(email: String?, pass: String?) {
        auth?.signInWithEmailAndPassword(email!!, pass!!)?.addOnCompleteListener { }
    }

    fun logOut() {
        auth?.signOut()
        logInUserMutableLiveData?.postValue(true)
    }
}
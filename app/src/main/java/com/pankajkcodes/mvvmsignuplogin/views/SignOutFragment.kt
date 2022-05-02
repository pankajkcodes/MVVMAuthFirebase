package com.pankajkcodes.mvvmsignuplogin.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.pankajkcodes.mvvmsignuplogin.R
import com.pankajkcodes.mvvmsignuplogin.viewModel.AuthViewModel


class SignOutFragment : Fragment() {

    private lateinit var button: Button
    private lateinit var authViewModel: AuthViewModel
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(activity!!.application)
        )[AuthViewModel::class.java]

        authViewModel.userStatus?.observe(this,{
            if (it){
                navController.navigate(R.id.action_signOutFragment_to_signInFragment)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_out, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        button = view.findViewById(R.id.sig_out_btn)

        button.setOnClickListener {
            authViewModel.signOut()

        }
    }

}
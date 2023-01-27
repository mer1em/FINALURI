package com.example.finaluri.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.finaluri.R
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordFragment : Fragment(R.layout.fragment_password_reset) {
    private lateinit var editTextEmail : EditText
    private lateinit var buttonSend : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

        editTextEmail=view.findViewById(R.id.userResetEmail)
        buttonSend=view.findViewById(R.id.buttonResetPassword)
        val navController = Navigation.findNavController(view)



        buttonSend.setOnClickListener{
            val email = editTextEmail.text.toString()

            if(email.isEmpty()){
                Toast.makeText(this@ResetPasswordFragment.requireActivity(), "გთხოვთ, შეყვანეთ Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@ResetPasswordFragment.requireActivity(), "გამოიგზავნა თქვვენს Email-ზე", Toast.LENGTH_SHORT).show()
                        val goToLogin = ResetPasswordFragmentDirections.actionResetPasswordFragmentToLoginFragment()
                        navController.navigate(goToLogin)

                    }
                    else {
                        Toast.makeText(this@ResetPasswordFragment.requireActivity(), "დაფიქსირდა შეცდომა", Toast.LENGTH_SHORT).show()
                    }

                }
        }
    }}
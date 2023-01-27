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

class RegisterFragment : Fragment(R.layout.fragment_register) {


    private lateinit var editTextEmail : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var registerButton : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        editTextEmail=view.findViewById(R.id.userInputEmail)
        editTextPassword=view.findViewById(R.id.userInputPassword)
        registerButton=view.findViewById(R.id.buttonUserRegister)


        val navController = Navigation.findNavController(view)


        registerButton.setOnClickListener{

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if(email.isEmpty()) {
                Toast.makeText(this@RegisterFragment.requireActivity(), "გთხოვთ შეიყვანეთ Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(password.isEmpty() || password.length < 5) {
                Toast.makeText(
                    this@RegisterFragment.requireActivity(),
                    "გთხოვთ შეიყვანეთ პაროლი!(მინიმუმ 5 სიმბოლო)",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this@RegisterFragment.requireActivity(), "რეგისტრაცია, წარმატებით დასრულდა", Toast.LENGTH_SHORT).show()
                        val goToProfile = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                        navController.navigate(goToProfile)

                    }
                    else{
                        Toast.makeText(this@RegisterFragment.requireActivity(), "შეცდომა დაფიქსირდა", Toast.LENGTH_SHORT).show()
                    }

                }}}}
package com.example.finaluri.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.finaluri.R
import com.example.finaluri.dataclass.DataClassName
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var editTextEmail : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var buttonLogin : Button
    private lateinit var buttonRegister : Button
    private lateinit var buttonPasswordReset : Button
    private lateinit var editName : EditText
    private lateinit var database : DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        editTextEmail=view.findViewById(R.id.userEmail)
        editTextPassword=view.findViewById(R.id.userPassword)
        buttonLogin=view.findViewById(R.id.buttonLogin)
        buttonRegister=view.findViewById(R.id.buttonRegister)
        buttonPasswordReset=view.findViewById(R.id.passwordReset)
        editName=view.findViewById(R.id.userName)


        val navController = Navigation.findNavController(view)


        buttonRegister.setOnClickListener{

            val goToRegistration = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            navController.navigate(goToRegistration)

        }

        buttonPasswordReset.setOnClickListener{
            val goToResetPassword = LoginFragmentDirections.actionLoginFragmentToResetPasswordFragment()
            navController.navigate(goToResetPassword)
        }

        buttonLogin.setOnClickListener{
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val name = editName.text.toString()


            if (name.isEmpty() || name.length<4){
                Toast.makeText(this@LoginFragment.requireActivity(), "გთხოვთ, შეიყვანეთ სახელი", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this@LoginFragment.requireActivity(), "გთხოვთ, შეიყვანეთ Email და პაროლი", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        database= FirebaseDatabase.getInstance().getReference("Name")
                        val names = DataClassName(name)
                        database.child(name).setValue(names).addOnSuccessListener {
                            editName.text.clear()
                        }
                        val goToProfile = LoginFragmentDirections.actionLoginFragmentToAppActivity()
                        navController.navigate(goToProfile)

                    }
                    else {
                        Toast.makeText(this@LoginFragment.requireActivity(), "გთხოვთ, შეიყვანეთ სწორი Email და პაროლი", Toast.LENGTH_SHORT).show()
                    }
                }}}}

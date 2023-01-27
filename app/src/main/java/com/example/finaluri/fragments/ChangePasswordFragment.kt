package com.example.finaluri.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.finaluri.R
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordFragment : Fragment(R.layout.fragment_password_change) {

    private lateinit var editTextNewPassword : EditText
    private lateinit var buttonChangePassword : Button
    private lateinit var editTextOldPassword: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        editTextNewPassword=view.findViewById(R.id.userNewPassword)
        buttonChangePassword=view.findViewById(R.id.buttonNewPassword)
        editTextOldPassword=view.findViewById(R.id.userOldPassword)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()


        buttonChangePassword.setOnClickListener{
            val newPassword = editTextNewPassword.text.toString()
            val oldPassword = editTextOldPassword.text.toString()

            if (oldPassword.isEmpty()) {
                Toast.makeText(this@ChangePasswordFragment.requireContext(), "გთხოვთ ძველი შეიყვანეთ პაროლი", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (newPassword.isEmpty() || newPassword.length < 5) {
                Toast.makeText(this@ChangePasswordFragment.requireContext(), "გთხოვთ შეიყვანეთ ახალი პაროლი(მინიმუმ 5 სიმბოლო)", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

            if (oldPassword==newPassword) {
                Toast.makeText(this@ChangePasswordFragment.requireContext(), "ახალი პაროლი ძველის ტოლი არ შეიძლება იყოს", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                            Toast.makeText(this@ChangePasswordFragment.requireContext(), "პაროლი წარმატებით შეიცვალა", Toast.LENGTH_SHORT).show()
                        }

                    else {
                            Toast.makeText(this@ChangePasswordFragment.requireContext(), "შეცდომა დაფიქსირდა", Toast.LENGTH_SHORT).show()
                        }}}}}
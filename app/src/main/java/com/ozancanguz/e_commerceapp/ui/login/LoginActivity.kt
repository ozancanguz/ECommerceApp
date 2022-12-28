package com.ozancanguz.e_commerceapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.e_commerceapp.R
import com.ozancanguz.e_commerceapp.databinding.ActivityLoginBinding
import com.ozancanguz.e_commerceapp.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.login_error_toast.*
import kotlinx.android.synthetic.main.login_toast.*


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        FirebaseApp.initializeApp(this)
        // Initialize Firebase Auth
        auth = Firebase.auth

        // user register
        register()

        // user sign in
        signIn()

    }


    private fun register() {

        binding.registerBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast(this).apply {
                    duration=Toast.LENGTH_LONG
                    setGravity(Gravity.CENTER,0,0)
                    view=layoutInflater.inflate(R.layout.login_error_toast,loginerror)
                }.show()

            } else {

                auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {

                    Toast(this).apply {
                        duration=Toast.LENGTH_LONG
                        setGravity(Gravity.CENTER,0,0)
                        view=layoutInflater.inflate(R.layout.login_toast,logintoast)
                    }.show()


                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }


            }
        }

    }
    private fun signIn() {
        binding.signInBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast(this).apply {
                    duration=Toast.LENGTH_LONG
                    setGravity(Gravity.CENTER,0,0)
                    view=layoutInflater.inflate(R.layout.login_error_toast,loginerror)
                }.show()

            } else {

                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                    val intent= Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }


            }
        }
    }
}
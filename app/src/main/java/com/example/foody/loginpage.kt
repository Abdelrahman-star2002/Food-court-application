package com.example.foody

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class loginpage : AppCompatActivity() {
    private var loginEmail: EditText? = null
    private var loginPassword: EditText? = null
    private var signupRedirectText: TextView? = null
    private var loginButton: Button? = null
    private var auth: FirebaseAuth? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)
        loginEmail = findViewById(R.id.loginemail)
        loginPassword = findViewById(R.id.loginpassword)
        loginPassword?.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
        loginButton = findViewById(R.id.loginbutton)
        signupRedirectText = findViewById(R.id.signupRedirecttext)
        auth = FirebaseAuth.getInstance()
        loginButton?.setOnClickListener(View.OnClickListener {
            val email = loginEmail?.getText().toString()
            val pass = loginPassword?.getText().toString()
            if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                if (!pass.isEmpty()) {
                    auth!!.signInWithEmailAndPassword(email, pass)
                        .addOnSuccessListener {
                            Toast.makeText(this@loginpage, "Login Successful", Toast.LENGTH_SHORT)
                                .show()
                            startActivity(Intent(this@loginpage, choose::class.java))
                            finish()
                        }.addOnFailureListener {
                            Toast.makeText(
                                this@loginpage,
                                "Login Failed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                } else {
                    loginPassword?.setError("password cannot be empty")
                }
            } else if (email.isEmpty()) {
                loginEmail?.setError("email cannot be empty")
            } else {
                loginEmail?.setError("Please enter correct email")
            }
        })
        signupRedirectText?.setOnClickListener {
            startActivity(
                Intent(
                    this, signup::class.java
                )
            )
        }
    }
}
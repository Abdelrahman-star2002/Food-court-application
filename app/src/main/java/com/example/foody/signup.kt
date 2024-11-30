package com.example.foody

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
    private var auth: FirebaseAuth? = null
    private var signupEmail: EditText? = null
    private var signupPassword: EditText? = null
    private var signupButton: Button? = null
    private var loginRedirectText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = FirebaseAuth.getInstance()
        signupEmail = findViewById(R.id.signupemail)
        signupPassword = findViewById(R.id.signuppassword)
        signupButton = findViewById(R.id.signupbutton)
        loginRedirectText = findViewById(R.id.loginRedirecttext)
        signupButton?.setOnClickListener(View.OnClickListener {
            val user = signupEmail?.getText().toString().trim { it <= ' ' }
            val pass = signupPassword?.getText().toString().trim { it <= ' ' }
            if (user.isEmpty()) {
                signupEmail?.setError("Email cannot be Empty")
            }
            if (pass.isEmpty()) {
                signupPassword?.setError("password cannot be Empty")
            } else {
                auth!!.createUserWithEmailAndPassword(user, pass).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@signup, "SignUp Successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@signup, loginpage::class.java))
                    } else {
                        Toast.makeText(
                            this@signup,
                            "SignUp failed" + task.exception!!.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
        loginRedirectText?.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@signup,
                    loginpage::class.java
                )
            )
        })
    }
}
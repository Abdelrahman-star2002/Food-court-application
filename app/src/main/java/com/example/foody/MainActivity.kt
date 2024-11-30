package com.example.foody

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler()
        handler!!.postDelayed({
            val intent = Intent(this@MainActivity, loginpage::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}
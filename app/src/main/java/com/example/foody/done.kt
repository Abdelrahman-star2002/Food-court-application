package com.example.foody

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class done : AppCompatActivity() {
    var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_done)
        handler = Handler()
        handler!!.postDelayed({
            val intent = Intent(this@done, map::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
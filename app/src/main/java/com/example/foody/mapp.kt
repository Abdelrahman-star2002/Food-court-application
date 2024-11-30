package com.example.foody

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class mapp : AppCompatActivity() {

    private var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapp)
        handler = Handler()
        handler!!.postDelayed({
            val intent = Intent(this@mapp, mapcoustmer::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
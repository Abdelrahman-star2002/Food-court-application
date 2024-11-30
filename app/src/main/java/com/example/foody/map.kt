package com.example.foody

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class map : AppCompatActivity() {
    var arabiatacard: CardView? = null
    var amsaadcard: CardView? = null
    var Tbscard: CardView? = null
    var prontocard: CardView? = null
    var Freiendscard: CardView? = null
    var laromacard: CardView? = null
    private var goback: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        goback=findViewById(R.id.goback)
        arabiatacard = findViewById(R.id.arabiatacard)
        amsaadcard = findViewById(R.id.amsaadcard)
        Tbscard = findViewById(R.id.tbscard)
        prontocard = findViewById(R.id.prontocard)
        Freiendscard = findViewById(R.id.friendscard)
        laromacard = findViewById(R.id.laromacard)
        arabiatacard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@map, pass::class.java)
            startActivity(intent)
            finish()
        })
        amsaadcard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@map, pass::class.java)
            startActivity(intent)
            finish()
        })
        Tbscard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@map, pass::class.java)
            startActivity(intent)
            finish()
        })
        prontocard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@map, pass::class.java)
            startActivity(intent)
            finish()
        })
        Freiendscard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@map, pass::class.java)
            startActivity(intent)
            finish()
        })
        laromacard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@map, pass::class.java)
            startActivity(intent)
            finish()
        })
        goback?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@map, pass::class.java)
            startActivity(intent)
        })
    }
}
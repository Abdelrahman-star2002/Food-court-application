package com.example.foody

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class choose : AppCompatActivity() {
    private var coustmercard: CardView? = null
    private var sellercard: CardView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        coustmercard = findViewById(R.id.coustmercard)
        sellercard = findViewById(R.id.sellercard)
        coustmercard?.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@choose, mapcoustmer::class.java))
            finish()
        })
        sellercard?.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@choose, map::class.java))
            finish()
        })
    }
}
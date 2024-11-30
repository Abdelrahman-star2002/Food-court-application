package com.example.foody

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.foody.model.orderdata
import com.google.firebase.database.FirebaseDatabase

class mapcoustmer : AppCompatActivity() {
    var arabiatacard: CardView? = null
    var amsaadcard: CardView? = null
    var Tbscard: CardView? = null
    var prontocard: CardView? = null
    var Freiendscard: CardView? = null
    var laromacard: CardView? = null
    var showmap: Button?=null
    var goback:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapcoustmer)
        goback=findViewById(R.id.goback)
        arabiatacard = findViewById(R.id.arabiatacard)
        amsaadcard = findViewById(R.id.amsaadcard)
        Tbscard = findViewById(R.id.tbscard)
        prontocard = findViewById(R.id.prontocard)
        Freiendscard = findViewById(R.id.friendscard)
        laromacard = findViewById(R.id.laromacard)
        showmap=findViewById(R.id.showmap)
        arabiatacard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@mapcoustmer, arabiatacoustmer::class.java)
            startActivity(intent)
            finish()
            addInfo("arabiata")
        })
        amsaadcard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@mapcoustmer, amsaadcoustmer::class.java)
            startActivity(intent)
            finish()
            addInfo("amsaad")
        })
        Tbscard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@mapcoustmer, tbscoustmer::class.java)
            startActivity(intent)
            finish()
            addInfo("tbs")
        })
        prontocard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@mapcoustmer, prontocoustmer::class.java)
            startActivity(intent)
            finish()
            addInfo("pronto")
        })
        Freiendscard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@mapcoustmer, friendscoustmer::class.java)
            startActivity(intent)
            finish()
            addInfo("friends")
        })
        laromacard?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@mapcoustmer, laromacoustmer::class.java)
            startActivity(intent)
            finish()
            addInfo("lamora")
        })

        showmap?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@mapcoustmer, mapp::class.java)
            startActivity(intent)
            finish()
        })
        goback?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@mapcoustmer, choose::class.java)
            startActivity(intent)
        })
    }
    private fun addInfo(resturantname:String) {
                val itemMap = mapOf(
                "totalitems" to " ",
                "totalprice" to "0"


                )
            val db = FirebaseDatabase.getInstance().reference.child("FOODY").child(resturantname).child("carts")
            val newItemReference = db.push()
            newItemReference.setValue(itemMap)
        }


}
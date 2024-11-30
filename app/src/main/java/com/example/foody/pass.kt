package com.example.foody

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class pass : AppCompatActivity() {


        private var goback: Button? = null
    private var enter: Button? = null

    var password: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass)
        enter = findViewById(R.id.enterr)
        goback=findViewById(R.id.goback)
        password = findViewById(R.id.chefpassword)
        enter?.setOnClickListener(View.OnClickListener {
            val db = FirebaseDatabase.getInstance().reference.child("FOODY")
            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val pass1 = dataSnapshot.child("arabiata").child("password").value.toString()
                    val pass2 = dataSnapshot.child("pronto").child("password").value.toString()
                    val pass3 = dataSnapshot.child("tbs").child("password").value.toString()
                    val pass4 = dataSnapshot.child("amsaad").child("password").value.toString()
                    val pass5 = dataSnapshot.child("lamora").child("password").value.toString()
                    val pass6 = dataSnapshot.child("friends").child("password").value.toString()
                    val z = password?.getText().toString()
                    if (z == pass1) {
                        Toast.makeText(this@pass, "correct password", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@pass, arabiata::class.java)
                        startActivity(intent)
                    } else if (z == pass2) {
                        Toast.makeText(this@pass, "correct password", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@pass, pronto::class.java)
                        startActivity(intent)
                    } else if (z == pass3) {
                        Toast.makeText(this@pass, "correct password", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@pass, tbs::class.java)
                        startActivity(intent)
                    } else if (z == pass4) {
                        Toast.makeText(this@pass, "correct password", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@pass, amsaad::class.java)
                        startActivity(intent)
                    } else if (z == pass5) {
                        Toast.makeText(this@pass, "correct password", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@pass, laroma::class.java)
                        startActivity(intent)
                    } else if (z == pass6) {
                        Toast.makeText(this@pass, "correct password", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@pass, friends::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@pass, "WRONG PASSWORD", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        })

        goback?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@pass, choose::class.java)
            startActivity(intent)
        })
    }


}
package com.example.foody


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.model.orderdata
import com.example.foody.view.orderAdapterforseller
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


private var goback:Button?=null

class prontooders : AppCompatActivity() {

    private lateinit var recv: RecyclerView
    private lateinit var orderList:ArrayList<orderdata>
    private lateinit var userAdapter:orderAdapterforseller
    val restaurantNames = listOf("amsaad", "arabiata", "friends","lamora","pronto","tbs")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pronto_orders)



        orderList = ArrayList()

        recv = findViewById(R.id.mRecycler)
        goback=findViewById(R.id.goback)


        userAdapter = orderAdapterforseller(this,orderList,restaurantNames)

        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter


        goback?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@prontooders, amsaad::class.java)
            startActivity(intent)
        })
        readDataFromDatabase()


    }



    private fun readDataFromDatabase() {
        val db = FirebaseDatabase.getInstance().reference.child("FOODY").child("pronto").child("orders")
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    orderList.clear()

                    for (itemSnapshot in snapshot.children) {
                        val itemName = itemSnapshot.child("name").getValue(String::class.java)
                        val itemdel = itemSnapshot.child("delivery").getValue(String::class.java)
                        val itemorder = itemSnapshot.child("item ordered").getValue(String::class.java)

                        if (itemName != null && itemdel != null && itemorder != null) {
                            orderList.add(orderdata(itemName, itemdel, itemorder))
                        }
                    }

                    userAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@prontooders, "Failed to read data", Toast.LENGTH_SHORT).show()
            }
        })
    }







}


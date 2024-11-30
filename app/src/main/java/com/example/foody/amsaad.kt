package com.example.foody

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.model.itemdata
import com.example.foody.view.itemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

private var goback:Button?=null
private var deliveryyes:Button?=null
private var deliveryno:Button?=null

class amsaad : AppCompatActivity() {

    private lateinit var call: FloatingActionButton
        private lateinit var addsBtn: FloatingActionButton
        private lateinit var oo: FloatingActionButton
        private lateinit var recv: RecyclerView
        private lateinit var itemList:ArrayList<itemdata>
        private lateinit var userAdapter:itemAdapter
        val restaurantNames = listOf("amsaad", "arabiata", "friends","lamora","pronto","tbs")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_amsaad)

            itemList = ArrayList()

            addsBtn = findViewById(R.id.addingBtn)
            recv = findViewById(R.id.mRecycler)
            goback=findViewById(R.id.goback)
            deliveryyes=findViewById(R.id.deliveryyes)
            deliveryno=findViewById(R.id.deliveryno)

            userAdapter = itemAdapter(this,itemList,restaurantNames)

            recv.layoutManager = LinearLayoutManager(this)
            recv.adapter = userAdapter

            addsBtn.setOnClickListener { addInfo() }
            oo=findViewById(R.id.ordersbutton)
            oo.setOnClickListener {
                val intent = Intent(this@amsaad, amsaadorders::class.java)
                startActivity(intent)
            }
            call=findViewById(R.id.callbutton)
            call.setOnClickListener {
                val intent = Intent(this@amsaad, callActivity::class.java)
                startActivity(intent)
            }



            deliveryyes?.setOnClickListener(View.OnClickListener {
                val db = FirebaseDatabase.getInstance().reference.child("FOODY")
                val path = "amsaad/delivery"
                db.child(path).addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        db.child(path).setValue("YES")
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle onCancelled if needed
                    }
                })
            })
            deliveryno?.setOnClickListener(View.OnClickListener {
                val db = FirebaseDatabase.getInstance().reference.child("FOODY")
                val path = "amsaad/delivery"
                db.child(path).addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        db.child(path).setValue("NO")
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle onCancelled if needed
                    }
                })
            })

            goback?.setOnClickListener(View.OnClickListener {
                val intent = Intent(this@amsaad, map::class.java)
                startActivity(intent)
            })
            readDataFromDatabase()


        }

    private fun readDataFromDatabase() {
        val db = FirebaseDatabase.getInstance().reference.child("FOODY").child("amsaad").child("items")
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    itemList.clear()

                    for (itemSnapshot in snapshot.children) {
                        val itemName = itemSnapshot.child("name").getValue(String::class.java)
                        val itemPrice = itemSnapshot.child("price").getValue(String::class.java)
                        val itemQuantity = itemSnapshot.child("quantity").getValue(String::class.java)

                        if (itemName != null && itemPrice != null && itemQuantity != null) {
                            itemList.add(itemdata(itemName, itemQuantity, itemPrice))
                        }
                    }

                    userAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@amsaad, "Failed to read data", Toast.LENGTH_SHORT).show()
            }
            })
        }
    private fun addInfo() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.additem, null)

        val itemname = v.findViewById<EditText>(R.id.itemname)
        val itemquan = v.findViewById<EditText>(R.id.itemquan)
        val itemprice = v.findViewById<EditText>(R.id.itemprice)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val names = itemname.text.toString()
            val quan = itemquan.text.toString()
            val pri=itemprice.text.toString()


            itemList.add(itemdata(names,quan,pri))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(this, "Adding item Information Success", Toast.LENGTH_SHORT).show()
            dialog.dismiss()

            val itemMap = mapOf(
                "name" to names,
                "price" to pri,
                "quantity" to quan,

            )
            val db = FirebaseDatabase.getInstance().reference.child("FOODY").child("amsaad").child("items")


            val newItemReference = db.push()
            newItemReference.setValue(itemMap)
        }

        addDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        }

        addDialog.create().show()
    }






    }


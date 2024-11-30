package com.example.foody

import android.annotation.SuppressLint
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
import com.example.foody.model.orderdata
import com.example.foody.view.coustmerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_choose.*

private var goback:Button?=null

class friendscoustmer : AppCompatActivity() {
    private lateinit var orderList:ArrayList<orderdata>
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var coustmerList:ArrayList<itemdata>
    private lateinit var userAdapter:coustmerAdapter
    private lateinit var orderbutton: FloatingActionButton
    val restaurantNames = listOf( "friends")


    private var del: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friendscoustmer)

        coustmerList = ArrayList()


        del=findViewById(R.id.deliveryA)
        val db = FirebaseDatabase.getInstance().reference.child("FOODY")
        val delivery = "friends/delivery"
        db.child(delivery).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val x = snapshot.getValue(String::class.java)
                del?.setText(x)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled if needed
            }
        })
        orderList = ArrayList()

        recv = findViewById(R.id.mRecycler)
        goback=findViewById(R.id.goback)

        userAdapter = coustmerAdapter(this,coustmerList,restaurantNames)

        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter

        addsBtn = findViewById(R.id.addingBtn)
        addsBtn.setOnClickListener { addInfo() }

        orderbutton = findViewById(R.id.orderstatus)
        orderbutton.setOnClickListener {showorderstatus()}



        goback?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@friendscoustmer, mapcoustmer::class.java)
            startActivity(intent)
        })
        readDataFromDatabase()


    }


    private fun showorderstatus() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.coustmerorderstatus, null)
        val orderStatusTextView = v.findViewById<TextView>(R.id.orderstat)

        val db = FirebaseDatabase.getInstance().reference.child("FOODY").child("friends").child("orders")

        db.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    orderStatusTextView.text = "Not Confirmed"
                } else {
                    orderStatusTextView.text = "Confirmed"
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        addDialog.create().show()
    }

    fun deleteNode(nodePath: String) {
        // Get a reference to the Firebase database
        val database = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference(nodePath)

        // Remove the node
        reference.removeValue()
    }
    private fun addInfo() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.addorder, null)
        val cosname = v.findViewById<EditText>(R.id.coustmername)
        val cosloc = v.findViewById<EditText>(R.id.deliverylocation)
        val cositem = v.findViewById<TextView>(R.id.itemschoosen)

        val cosprice= v.findViewById<TextView>(R.id.totalpricee)
        val db = FirebaseDatabase.getInstance().reference.child("FOODY")
        for (restaurantName in restaurantNames) {
            db.child("friends").child("carts").addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (itemSnapshot in dataSnapshot.children) {
                            var totalitems = itemSnapshot.child("totalitems").getValue(String::class.java)
                            cositem.setText("total items : " +totalitems)

                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle errors
                }
            })
        }
        for (restaurantName in restaurantNames) {
            db.child("friends").child("carts").addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (itemSnapshot in dataSnapshot.children) {
                            var totalprice = itemSnapshot.child("totalprice").getValue(String::class.java)
                            cosprice.setText("total price :"+  totalprice)

                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle errors
                }
            })
        }

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val names = cosname.text.toString()
            val delivery = cosloc.text.toString()
            val order=cositem.text.toString()
            val pp=cosprice.text.toString()


            orderList.add(orderdata(names,delivery,order))
            val intent = Intent(this@friendscoustmer, donecustomer::class.java)
            startActivity(intent)
            Toast.makeText(this, "Adding item Information Success", Toast.LENGTH_SHORT).show()
            dialog.dismiss()

            val itemMap = mapOf(
                "name" to names,
                "delivery" to delivery,
                "item ordered" to order,
                "totalprice" to pp

                )
            val db = FirebaseDatabase.getInstance().reference.child("FOODY").child("friends").child("orders")
            val newItemReference = db.push()
            newItemReference.setValue(itemMap)
            val nodePathToDelete1 = "FOODY/amsaad/carts"
            val nodePathToDelete2 = "FOODY/arabiata/carts"
            val nodePathToDelete3 = "FOODY/tbs/carts"
            val nodePathToDelete4 = "FOODY/pronto/carts"
            val nodePathToDelete5 = "FOODY/lamora/carts"
            val nodePathToDelete6 = "FOODY/friends/carts"
            deleteNode(nodePathToDelete1)
            deleteNode(nodePathToDelete2)
            deleteNode(nodePathToDelete3)
            deleteNode(nodePathToDelete4)
            deleteNode(nodePathToDelete5)
            deleteNode(nodePathToDelete6)
        }

        addDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        }

        addDialog.create().show()
    }
    private fun readDataFromDatabase() {
        val db = FirebaseDatabase.getInstance().reference.child("FOODY").child("friends").child("items")
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    coustmerList.clear()

                    for (itemSnapshot in snapshot.children) {
                        val itemName = itemSnapshot.child("name").getValue(String::class.java)
                        val itemPrice = itemSnapshot.child("price").getValue(String::class.java)
                        val itemQuantity = itemSnapshot.child("quantity").getValue(String::class.java)

                        if (itemName != null && itemPrice != null && itemQuantity != null) {
                            coustmerList.add(itemdata(itemName, "0", itemPrice))
                        }
                    }

                    userAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@friendscoustmer, "Failed to read data", Toast.LENGTH_SHORT).show()
            }
        })
    }







}


package com.example.foody


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.model.itemdata
import com.example.foody.model.orderdata
import com.example.foody.view.coustmerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*


private var goback:Button?=null

class amsaadcoustmer : AppCompatActivity() {
    private lateinit var call: FloatingActionButton
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var orderbutton: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var coustmerList:ArrayList<itemdata>
    private lateinit var orderList:ArrayList<orderdata>
    private lateinit var userAdapter:coustmerAdapter
    private var del: TextView? = null



    val restaurantNames = listOf("amsaad", "arabiata", "friends","lamora","pronto","tbs")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amsaadcoustmer)

        coustmerList = ArrayList()

        orderList = ArrayList()



        recv = findViewById(R.id.mRecycler)
        goback=findViewById(R.id.goback)

        del=findViewById(R.id.deliveryA)
        val db = FirebaseDatabase.getInstance().reference.child("FOODY")
        val delivery = "amsaad/delivery"
        db.child(delivery).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val x = snapshot.getValue(String::class.java)
                del?.setText(x)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled if needed
            }
        })




        addsBtn = findViewById(R.id.addingBtn)
        addsBtn.setOnClickListener { addInfo() }

        orderbutton = findViewById(R.id.orderstatus)
        orderbutton.setOnClickListener {showorderstatus()}

        call=findViewById(R.id.call)




        userAdapter = coustmerAdapter(this,coustmerList,restaurantNames)



        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter


        goback?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@amsaadcoustmer, mapcoustmer::class.java)
            startActivity(intent)
        })
        readDataFromDatabase()




    }
    private fun showorderstatus() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.coustmerorderstatus, null)
        val orderStatusTextView = v.findViewById<TextView>(R.id.orderstat)

        val db = FirebaseDatabase.getInstance().reference.child("FOODY").child("amsaad").child("orders")

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


    private fun addInfo() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.addorder, null)
        val cosname = v.findViewById<EditText>(R.id.coustmername)
        val cosloc = v.findViewById<EditText>(R.id.deliverylocation)
        val cositem = v.findViewById<TextView>(R.id.itemschoosen)


        val cosprice= v.findViewById<TextView>(R.id.totalpricee)
        val db = FirebaseDatabase.getInstance().reference.child("FOODY")
        for (restaurantName in restaurantNames) {
            db.child("amsaad").child("carts").addListenerForSingleValueEvent(object :
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
            db.child("amsaad").child("carts").addListenerForSingleValueEvent(object :
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
            Toast.makeText(this, "Adding item Information Success", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@amsaadcoustmer, donecustomer::class.java)
            startActivity(intent)
            dialog.dismiss()

            val itemMap = mapOf(
                "name" to names,
                "delivery" to delivery,
                "item ordered" to order,
                "totalprice" to pp

                )
            val db = FirebaseDatabase.getInstance().reference.child("FOODY").child("amsaad").child("orders")
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

    fun deleteNode(nodePath: String) {

        val database = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference(nodePath)


        reference.removeValue()
    }
    private fun readDataFromDatabase() {
        val db = FirebaseDatabase.getInstance().reference.child("FOODY").child("amsaad").child("items")
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
                Toast.makeText(this@amsaadcoustmer, "Failed to read data", Toast.LENGTH_SHORT).show()
            }
        })
    }






}


package com.example.foody.view
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.R
import com.example.foody.model.itemdata
import com.google.firebase.database.*

class itemAdapter(val c: Context, val itemList: ArrayList<itemdata>, val restaurantNames: List<String>) :
    RecyclerView.Adapter<itemAdapter.UserViewHolder>() {



    inner class UserViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        var name: TextView = v.findViewById(R.id.mitemname)
        var quan: TextView = v.findViewById(R.id.mitemquan)
        var price: TextView = v.findViewById(R.id.mpricenumber)
        var addprice: Button = v.findViewById(R.id.mpriceplus)
        var minusprice: Button = v.findViewById(R.id.mpriceminus)
        var addquan: Button = v.findViewById(R.id.mplus)
        var minquan: Button = v.findViewById(R.id.mminus)
        var database = FirebaseDatabase.getInstance()
        var databaseReference: DatabaseReference
        val restaurantNames = listOf("amsaad", "arabiata", "friends","lamora","pronto","tbs")

        init {
            databaseReference = database.reference.child("FOODY")

            addprice.setOnClickListener {
                for (restaurantName in restaurantNames) {
                    updateDatabaseplusprice(restaurantName)
                }
            }

            minusprice.setOnClickListener {
                for (restaurantName in restaurantNames) {
                    updateDatabaseminusprice(restaurantName)
                }
            }

            addquan.setOnClickListener {
                for (restaurantName in restaurantNames) {
                    updateDatabaseplus(restaurantName)
                }
            }

            minquan.setOnClickListener {
                for (restaurantName in restaurantNames) {
                    updateDatabaseminus(restaurantName)
                }
            }
        }
        private fun updateDatabaseplus(restaurantName: String) {
            for (restaurantName in restaurantNames) {
                databaseReference.child(restaurantName).child("items").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (itemSnapshot in dataSnapshot.children) {
                                if (name.text.contains(itemSnapshot.child("name").getValue(String::class.java).toString())) {
                                    var itemQuantity = itemSnapshot.child("quantity").getValue(String::class.java)
                                    var finalqty: Int? = (itemQuantity?.toInt()?.plus(1))
                                    itemQuantity = finalqty.toString()
                                    val newData = hashMapOf(
                                        "quantity" to itemQuantity
                                    )
                                    itemSnapshot.ref.updateChildren(newData as Map<String, Any>)
                                }else{

                                }
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle errors
                    }
                })
            }
        }
        private fun updateDatabaseminus(restaurantName: String) {
            databaseReference.child(restaurantName).child("items").addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (itemSnapshot in dataSnapshot.children) {
                            if (name.text.contains(itemSnapshot.child("name").getValue(String::class.java).toString())) {
                                var itemQuantity = itemSnapshot.child("quantity").getValue(String::class.java)
                                var finalqty: Int? = (itemQuantity?.toInt()?.minus(1))
                                itemQuantity = finalqty.toString()

                                val newData = hashMapOf(
                                    "quantity" to itemQuantity
                                )
                                itemSnapshot.ref.updateChildren(newData as Map<String, Any>)
                            }
                        }
                    } else {

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle errors
                }
            })
        }
        private fun updateDatabaseplusprice(restaurantName: String) {
            for (restaurantName in restaurantNames) {
                databaseReference.child(restaurantName).child("items").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (itemSnapshot in dataSnapshot.children) {
                                if (name.text.contains(itemSnapshot.child("name").getValue(String::class.java).toString())) {
                                    var itemPrice = itemSnapshot.child("price").getValue(String::class.java)
                                    var finalpri: Int? = (itemPrice?.toInt()?.plus(1))
                                    itemPrice = finalpri.toString()
                                    val newData = hashMapOf(
                                        "price" to itemPrice
                                    )
                                    itemSnapshot.ref.updateChildren(newData as Map<String, Any>)
                                }else{

                                }
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle errors
                    }
                })
            }

        }
        private fun updateDatabaseminusprice(restaurantName: String) {
            for (restaurantName in restaurantNames) {
                databaseReference.child(restaurantName).child("items").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (itemSnapshot in dataSnapshot.children) {
                                if (name.text.contains(itemSnapshot.child("name").getValue(String::class.java).toString())) {
                                    var itemPrice = itemSnapshot.child("price").getValue(String::class.java)
                                    var finalpri: Int? = (itemPrice?.toInt()?.minus(1))
                                    itemPrice = finalpri.toString()
                                    val newData = hashMapOf(
                                        "price" to itemPrice
                                    )
                                    itemSnapshot.ref.updateChildren(newData as Map<String, Any>)
                                }else{

                                }
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle errors
                    }
                })
            }
        }



    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.listitem, parent, false)
        return UserViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = itemList[position]

        holder.name.text = item.itemName
        holder.quan.text = item.itemquantity
        holder.price.text = item.itemprice


    }


}
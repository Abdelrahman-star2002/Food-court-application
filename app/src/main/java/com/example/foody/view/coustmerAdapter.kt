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

class coustmerAdapter(val c: Context, val coustmerList: ArrayList<itemdata>, val restaurantNames: List<String>) :
    RecyclerView.Adapter<coustmerAdapter.BuyerViewHolder>() {

    inner class BuyerViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        var name: TextView
        var nmPrice: TextView
        var plus: Button
        var minus: Button
        var buyquantity: Int = 0
        var database = FirebaseDatabase.getInstance()
        var databaseReference: DatabaseReference
        var viewbuyquantity: TextView
        val restaurantNames = listOf("amsaad", "arabiata", "friends","lamora","pronto","tbs")


        init {
            name = v.findViewById(R.id.mitemnamee)
            nmPrice = v.findViewById(R.id.mprice)
            plus = v.findViewById(R.id.mplus)
            minus = v.findViewById(R.id.mminus)
            viewbuyquantity = v.findViewById(R.id.mitemquantity)


            databaseReference = database.reference.child("FOODY")





            plus.setOnClickListener {
                // Increment quantity and update TextView
                buyquantity++
                viewbuyquantity.text = buyquantity.toString()
                for (restaurantName in restaurantNames) {
                    updateDatabaseplus(restaurantName)
                }
                minus?.setEnabled(true)

            }



            minus.setOnClickListener {
                    if(buyquantity==1) {
                        buyquantity--
                        viewbuyquantity.text = buyquantity.toString()
                        for (restaurantName in restaurantNames) {
                            updateDatabaseminus(restaurantName)
                        }
                        minus?.isEnabled=false
                    }else{
                        buyquantity--
                        viewbuyquantity.text = buyquantity.toString()
                        for (restaurantName in restaurantNames) {
                            updateDatabaseminus(restaurantName)
                        }
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
                                    var finalqty: Int? = (itemQuantity?.toInt()?.minus(1))
                                    if(finalqty==0){
                                        plus?.isEnabled=false
                                    }
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
            for (restaurantName in restaurantNames) {
                databaseReference.child(restaurantName).child("carts").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (itemSnapshot in dataSnapshot.children) {
                                var titem = itemSnapshot.child("totalitems").getValue(String::class.java)
                                titem=titem+","+name.text

                                val newData = hashMapOf(
                                    "totalitems" to titem.toString()
                                )
                                itemSnapshot.ref.updateChildren(newData as Map<String, Any>)

                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle errors
                    }
                })
            }
            for (restaurantName in restaurantNames) {
                databaseReference.child(restaurantName).child("carts").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (itemSnapshot in dataSnapshot.children) {
                                var totalprice = itemSnapshot.child("totalprice").getValue(String::class.java)
                                var p=(nmPrice.text.toString()).toInt()

                                var finalpri: Int? = (totalprice?.toInt()?.plus(p))


                                val newData = hashMapOf(
                                    "totalprice" to finalpri.toString()
                                )
                                itemSnapshot.ref.updateChildren(newData as Map<String, Any>)
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
                                var finalqty: Int? = (itemQuantity?.toInt()?.plus(1))
                                plus?.isEnabled=true
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

            for (restaurantName in restaurantNames) {
                databaseReference.child(restaurantName).child("carts").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (itemSnapshot in dataSnapshot.children) {
                                var x = itemSnapshot.child("totalitems").getValue(String::class.java)
                                var wordToRemove = name.text.toString()
                                x = x?.replaceFirst(wordToRemove, "")


                                val newData = hashMapOf(
                                    "totalitems" to x.toString()
                                )
                                itemSnapshot.ref.updateChildren(newData as Map<String, Any>)

                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle errors
                    }
                })
            }
            for (restaurantName in restaurantNames) {
                databaseReference.child(restaurantName).child("carts").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (itemSnapshot in dataSnapshot.children) {
                                var totalprice = itemSnapshot.child("totalprice").getValue(String::class.java)
                                var p=(nmPrice.text.toString()).toInt()

                                var finalpri: Int? = (totalprice?.toInt()?.minus(p))


                                val newData = hashMapOf(
                                    "totalprice" to finalpri.toString()
                                )
                                itemSnapshot.ref.updateChildren(newData as Map<String, Any>)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.listitemcoustmer, parent, false)
        return BuyerViewHolder(v)
    }

    override fun onBindViewHolder(holder: BuyerViewHolder, position: Int) {
        val newItem = coustmerList[position]
        holder.name.text = newItem.itemName
        holder.nmPrice.text = newItem.itemprice



    }

    override fun getItemCount(): Int {
        return coustmerList.size
        }
}
package com.example.foody.view
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.R
import com.example.foody.model.orderdata
import com.google.firebase.database.*


class orderAdapterforseller(val c: Context, val orderList: ArrayList<orderdata>, val restaurantNames: List<String>) :
    RecyclerView.Adapter<orderAdapterforseller.BuyerViewHolder>() {

    inner class BuyerViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        var coustmername: TextView
        var coustmerdelivery: TextView
        var coustmerorder: TextView
        var confirm: Button
        var database = FirebaseDatabase.getInstance()
        var databaseReference: DatabaseReference
        val restaurantNames = listOf("amsaad", "arabiata", "friends", "lamora", "pronto", "tbs")

        init {
            coustmername = v.findViewById(R.id.cousname)
            coustmerdelivery = v.findViewById(R.id.deliveryL)
            coustmerorder=v.findViewById(R.id.order)
            confirm = v.findViewById(R.id.truee)




            databaseReference = database.reference.child("FOODY")

            confirm.setOnClickListener {
                for (restaurantName in restaurantNames) {
                    deletefunc(restaurantName,adapterPosition)
                }
            }







        }
    }

    private fun deletefunc(restaurantName: String, position: Int) {
        val database = FirebaseDatabase.getInstance()
        val databaseReference = database.reference.child("FOODY").child(restaurantName).child("orders")

        val orderToRemove = orderList[position]
        val query = databaseReference.orderByChild("name").equalTo(orderToRemove.CoustmerName)

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    snapshot.ref.removeValue().addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            orderList.removeAt(position)
                            notifyItemRemoved(position)
                            notifyItemRangeChanged(position, orderList.size)
                        }
                    }
                    break
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.listorder, parent, false)
        return BuyerViewHolder(v)
    }

    override fun onBindViewHolder(holder: BuyerViewHolder, position: Int) {
        val newItem = orderList[position]
        holder.coustmername.text = newItem.CoustmerName
        holder.coustmerdelivery.text = newItem.DeliveryLocation
        holder.coustmerorder.text = newItem.ItemOrdered




    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}
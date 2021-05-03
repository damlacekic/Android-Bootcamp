package com.damla.finalproject.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.damla.finalproject.Database.Payment
import com.damla.finalproject.Fragments.MainFragmentDirections
import com.damla.finalproject.R
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class Adapter() : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var paymentList = emptyList<Payment>()
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = paymentList[position]
        holder.itemView.TextViewHarcamaRow.text = (currentItem.amount).toInt().toString()
        holder.itemView.imageViewRow.setImageResource(currentItem.vektor)
        holder.itemView.textViewAciklamaRow.text = currentItem.section
        holder.itemView.textViewParaRow.text = currentItem.amountType
        holder.itemView.rootView.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return paymentList.size
    }
    fun setData(payment:List<Payment>){
        this.paymentList = payment
        notifyDataSetChanged()
    }

}
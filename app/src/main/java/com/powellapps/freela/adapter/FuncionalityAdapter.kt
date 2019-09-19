package com.powellapps.freela.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.powellapps.freela.R
import com.powellapps.freela.model.Functionality

class FuncionalityAdapter(var list : List<Functionality>) :
    RecyclerView.Adapter<FuncionalityAdapter.ViewHolderFunctionality>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFunctionality {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_functionality, parent, false)
        return ViewHolderFunctionality(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderFunctionality, position: Int) {
        holder.bind(list.get(position))
    }

    fun update(list: List<Functionality>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolderFunctionality(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(function: Functionality) {
            val textViewName = itemView.findViewById<TextView>(R.id.textView_name)
            val textViewHours = itemView.findViewById<TextView>(R.id.textView_hours)
            textViewName.text = function.name
            textViewHours.text = function.amountOfHours.toString()
        }

    }
}
package com.powellapps.freela.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.powellapps.freela.R
import com.powellapps.freela.model.Functionality

class FunctionalityAdapter(var list : List<Functionality>) :
    RecyclerView.Adapter<FunctionalityAdapter.ViewHolderFunctionality>() {

    var callbackActive : ActiveFunctionality? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFunctionality {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_functionality, parent, false)
        return ViewHolderFunctionality(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderFunctionality, position: Int) {
        val function = list.get(position)
        holder.bind(function)
        holder.checkBoxActive!!.setOnCheckedChangeListener({ buttonView, isChecked ->
            function.active = isChecked
            callbackActive!!.update(function)

        })
    }

    fun update(list: List<Functionality>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolderFunctionality(itemView : View) : RecyclerView.ViewHolder(itemView){

        var checkBoxActive : CheckBox? = null

        fun bind(function: Functionality) {
            val textViewName = itemView.findViewById<TextView>(R.id.textView_name)
            val textViewHours = itemView.findViewById<TextView>(R.id.textView_hours)
            checkBoxActive = itemView.findViewById(R.id.checkBox_active)
            textViewName.text = function.name
            textViewHours.text = function.amountOfHours.toString()

        }

    }

    interface ActiveFunctionality{
        fun update(function: Functionality)
    }
}
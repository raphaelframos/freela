package com.powellapps.freela.ui.freela.myfreelas

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.powellapps.freela.NewFunctionalityActivity
import com.powellapps.freela.R
import com.powellapps.freela.model.Freela
import kotlinx.android.synthetic.main.adapter_freela.view.*
import java.util.*

class FreelaAdapter(val freelas: List<Freela>, val activity: Activity) : RecyclerView.Adapter<FreelaAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return freelas.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val freela = freelas.get(position)
        holder.bind(freela)
        holder.itemView.setOnClickListener({
            activity.startActivity(Intent(activity, NewFunctionalityActivity::class.java))
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_freela, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(freela: Freela) {
            itemView.textView_name_freela.text = freela.name
            itemView.textView_language_freela.text = freela.language
            itemView.textView_profession_freela.text = freela.profession
            itemView.textView_hour_value_freela.text = Currency.getInstance(Locale.getDefault()).symbol + " " + freela.hourValue
            itemView.textView_total_time_freela.text = freela.totalTime.toString() + " horas"

        }

    }
}
package com.powellapps.freela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.powellapps.freela.adapter.FunctionalityAdapter
import com.powellapps.freela.model.Functionality
import kotlinx.android.synthetic.main.activity_new_freela.*
import kotlin.collections.ArrayList

class NewFreelaActivity : AppCompatActivity(), FunctionalityAdapter.ActiveFunctionality {

    var adapter = FunctionalityAdapter(emptyList())
    var sum = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_freela)
        val list = recyclerView_functions
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val f = Functionality("Teste", 25.0)
        var functions = ArrayList<Functionality>()
        functions.add(f)
        functions.add(f)
        functions.add(f)
        adapter.update(functions)
        adapter.callbackActive = this
        showSum()

    }

    override fun update(function: Functionality) {
        if(function.active){
            sum += function.amountOfHours
        }else{
            sum -= function.amountOfHours
        }
        showSum()
    }

    private fun showSum() {
        textView_sum.text = "Total: " + sum
    }
}

package com.powellapps.freela.funcionality

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import com.powellapps.freela.R
import com.powellapps.freela.ui.freela.functionality.FunctionalityAdapter
import com.powellapps.freela.model.Functionality
import kotlinx.android.synthetic.main.activity_funcionality.*

class FuncionalityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcionality)

        recyclerView_functionalities.layoutManager = LinearLayoutManager(this)
        recyclerView_functionalities.addItemDecoration(DividerItemDecoration(this, VERTICAL))
        var funcs : ArrayList<Functionality> = arrayListOf()
        funcs.add(Functionality("Teste", 1.1))
        funcs.add(Functionality("Teste", 1.1))
        funcs.add(Functionality("Teste", 1.1))
        funcs.add(Functionality("Teste", 1.1))
        recyclerView_functionalities.adapter =
            FunctionalityAdapter(funcs)

        imageView_send.setOnClickListener({

        })
    }
}

package com.powellapps.freela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.powellapps.freela.adapter.FuncionalityAdapter
import com.powellapps.freela.model.Functionality
import kotlinx.android.synthetic.main.activity_new_freela.*
import java.util.*
import kotlin.collections.ArrayList

class NewFreelaActivity : AppCompatActivity() {

    var adapter = FuncionalityAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_freela)

        val list = recyclerView_functions
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        val f = Functionality("Teste", 25.0)
        var functions = ArrayList<Functionality>()
        functions.add(f)
        functions.add(f)
        functions.add(f)
        adapter.update(functions)

    }
}

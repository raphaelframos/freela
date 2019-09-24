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

        var functions = ArrayList<Functionality>()
        /*
        val f = Functionality("Login com email e senha", 1.0)
        val f1 = Functionality("Tela de configuração", 10.0)
        val f2 = Functionality("Tela de configuração 2", 10.0)
        val f3 = Functionality("Tela de configuração 3", 10.0)
        val f4 = Functionality("Resumo", 5.0)
        val f5 = Functionality("Final", 5.0)
        val f6 = Functionality("Regras de negócio", 10.0)
        val f7 = Functionality("Customização", 5.0)

        */
        val f = Functionality("Login com email e senha", 5.0)
        val f1 = Functionality("Cadastro de multiusuários", 10.0)
        val f2 = Functionality("Cadastro de objetivos", 5.0)
        val f3 = Functionality("Tela de configuração 1", 10.0)
        val f8 = Functionality("Cadastro de fatores", 5.0)
        val f9 = Functionality("Tela de configuração 2", 10.0)
        val f10 = Functionality("Cadastro de áreas", 5.0)
        val f12 = Functionality("Tela de configuração 3", 10.0)
        val f11 = Functionality("Cadastro de donos do risco", 5.0)
        val f4 = Functionality("Resumo", 10.0)
        val f5 = Functionality("Final", 5.0)
        val f6 = Functionality("Regras de negócio", 15.0)
        val f7 = Functionality("Customização", 5.0)

        functions.add(f)
        functions.add(f1)
        functions.add(f2)
        functions.add(f3)
        functions.add(f4)
        functions.add(f5)
        functions.add(f6)
        functions.add(f7)
        functions.add(f8)
        functions.add(f9)
        functions.add(f10)
        functions.add(f11)
        functions.add(f12)


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
        textView_sum.text = "Total (h): " + sum + " R$ " + (sum*150)
    }
}

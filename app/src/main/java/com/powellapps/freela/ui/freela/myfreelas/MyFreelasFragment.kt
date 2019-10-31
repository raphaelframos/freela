package com.powellapps.freela.ui.freela.myfreelas


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import com.powellapps.freela.NewFreelaActivity
import com.powellapps.freela.R
import kotlinx.android.synthetic.main.fragment_my_freelas.*


/**
 * A simple [Fragment] subclass.
 */
class MyFreelasFragment : Fragment() {

    private lateinit var model: FreelaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_freelas, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model = ViewModelProviders.of(this).get(FreelaViewModel::class.java)
        recyclerView_my_freelas.layoutManager = LinearLayoutManager(context)
        recyclerView_my_freelas.addItemDecoration(
            DividerItemDecoration(
                context,
                VERTICAL
            ))
        floating_nova_freela.setOnClickListener({
            startActivity(Intent(activity, NewFreelaActivity::class.java))
        })

        model.list.observe(this, Observer {
            recyclerView_my_freelas.adapter = FreelaAdapter(it, activity!!)

        })
    }


}

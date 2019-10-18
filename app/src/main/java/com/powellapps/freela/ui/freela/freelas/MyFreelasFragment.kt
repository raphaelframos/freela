package com.powellapps.freela.ui.freela.freelas


import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powellapps.freela.NewFreelaActivity

import com.powellapps.freela.R
import com.powellapps.freela.db.AppDatabase
import com.powellapps.freela.utils.GeralUtils
import kotlinx.android.synthetic.main.fragment_my_freelas.*

/**
 * A simple [Fragment] subclass.
 */
class MyFreelasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_freelas, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        floating_nova_freela.setOnClickListener({
            startActivity(Intent(activity, NewFreelaActivity::class.java))
        })

        AsyncTask.execute({
            GeralUtils.show("Teste " + AppDatabase(context!!).freelaDao().list().size)
        })

    }


}

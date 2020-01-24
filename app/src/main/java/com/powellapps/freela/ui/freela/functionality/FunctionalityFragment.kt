package com.powellapps.freela.ui.freela.functionality


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.powellapps.freela.R
import kotlinx.android.synthetic.main.fragment_functionality.*

/**
 * A simple [Fragment] subclass.
 */
class FunctionalityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_functionality, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView_functionalities.layoutManager = LinearLayoutManager(context)


    }

}

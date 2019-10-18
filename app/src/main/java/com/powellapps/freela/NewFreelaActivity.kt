package com.powellapps.freela

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.powellapps.freela.adapter.FunctionalityAdapter
import com.powellapps.freela.dao.FreelaDao
import com.powellapps.freela.db.AppDatabase
import com.powellapps.freela.model.Freela
import com.powellapps.freela.model.Functionality
import kotlinx.android.synthetic.main.activity_new_freela.*
import kotlin.collections.ArrayList

class NewFreelaActivity : AppCompatActivity() {

    private lateinit var freelaDao: FreelaDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_freela)

        button_save_freela.setOnClickListener({
            val name = textInput_name.text.toString()

            var freela = Freela()
            freela.addName(name)
            AsyncTask.execute({
                AppDatabase(this).freelaDao().add(freela)
                finish()
            })
        })


    }


}

package com.powellapps.freela

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.powellapps.freela.dao.FreelaDao
import com.powellapps.freela.db.AppDatabase
import com.powellapps.freela.model.Freela
import kotlinx.android.synthetic.main.activity_new_freela.*

class NewFreelaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_freela)

        button_save_freela.setOnClickListener({
            val name = textInput_name.text.toString()
            val profession = spinner_profession.selectedItem as String
            val language = spinner_languages.selectedItem as String
            val hourValue = textInput_hour_value.text.toString()
            val positionVisibility = spinner_visible.selectedItemPosition
            var freela = Freela()
            freela.addName(name).addLanguage(language).addProfession(profession).addHourValue(hourValue)
            if(positionVisibility == 1){

            }

            SaveFreela(freela).execute()

        })


    }

    inner class SaveFreela(val freela: Freela) : AsyncTask<Void, Void, Void>(){

        override fun doInBackground(vararg params: Void?): Void? {
            val database = AppDatabase.Database.instance(context = applicationContext)
            database.freelaDao().add(freela)
            finish()
            return null
        }

    }


}

package com.powellapps.freela.newfreela


import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powellapps.freela.R
import com.powellapps.freela.db.AppDatabase
import com.powellapps.freela.model.Freela
import kotlinx.android.synthetic.main.fragment_new_freela.*


class NewFreelaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_freela, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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
            val database = AppDatabase.Database.instance(context = context!!)
            database.freelaDao().add(freela)
            return null
        }

    }


}

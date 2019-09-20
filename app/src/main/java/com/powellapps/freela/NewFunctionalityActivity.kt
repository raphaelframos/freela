package com.powellapps.freela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.powellapps.freela.dao.FunctionalityDao
import com.powellapps.freela.db.AppDatabase
import com.powellapps.freela.model.Functionality

class NewFunctionalityActivity : AppCompatActivity() {

    private lateinit var functionalityDao: FunctionalityDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_functionality)
        val database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "freela-database").allowMainThreadQueries().build()
        functionalityDao = database.functionalityDao()
        var functionality = Functionality("Login", 10.0)
        functionalityDao.save(functionality)

    }
}

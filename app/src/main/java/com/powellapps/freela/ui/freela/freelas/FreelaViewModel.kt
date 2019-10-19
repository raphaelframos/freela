package com.powellapps.freela.ui.freela.freelas

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.powellapps.freela.db.AppDatabase

class FreelaViewModel(application: Application) : AndroidViewModel(application) {

    private val db : AppDatabase = AppDatabase.Database.instance(application)
    var list = db.freelaDao().list()
}
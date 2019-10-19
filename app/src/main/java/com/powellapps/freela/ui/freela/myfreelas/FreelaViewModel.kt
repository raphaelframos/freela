package com.powellapps.freela.ui.freela.myfreelas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.powellapps.freela.db.AppDatabase

class FreelaViewModel(application: Application) : AndroidViewModel(application) {

    private val db : AppDatabase = AppDatabase.Database.instance(application)
    var list = db.freelaDao().list()
}
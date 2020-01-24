package com.powellapps.freela

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.powellapps.freela.dao.FreelaDao
import com.powellapps.freela.db.AppDatabase
import com.powellapps.freela.model.Freela
import com.powellapps.freela.newfreela.NewFreelaFragment
import com.powellapps.freela.newfreela.NewFunctionalityFragment
import com.powellapps.freela.utils.GeralUtils
import kotlinx.android.synthetic.main.activity_new_freela.*

class NewFreelaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_freela)

        tabLayout_options.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if(tab.position == 0){
                    supportFragmentManager.beginTransaction().replace(R.id.linearLayout_new_freela, NewFreelaFragment()).commitAllowingStateLoss()
                }else{
                    supportFragmentManager.beginTransaction().replace(R.id.linearLayout_new_freela, NewFunctionalityFragment()).commitAllowingStateLoss()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })



    }




}

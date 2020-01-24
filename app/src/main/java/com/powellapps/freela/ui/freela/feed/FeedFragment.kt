package com.powellapps.freela.ui.freela.feed


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.powellapps.freela.R
import kotlinx.android.synthetic.main.fragment_feed.*
import com.google.firebase.firestore.FirebaseFirestore
import com.powellapps.freela.model.Feed
import com.powellapps.freela.model.Freela


/**
 * A simple [Fragment] subclass.
 */
class FeedFragment : Fragment() {

    var adapter = FeedAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView_feed.layoutManager = LinearLayoutManager(context)
        recyclerView_feed.adapter = adapter
        val db = FirebaseFirestore.getInstance()
        var feed = Feed()
        var freela = Freela()
        freela.hourValue = 10.0
        freela.addProfession("Programador").addLanguage("ios").addName("redentor")
        feed.freela = freela
        feed.userName = "João"
        feed.userPhoto = "https://i.ytimg.com/vi/wJ7qG1yXJzA/maxresdefault.jpg"
        db.collection("feed").add(feed.toMap())

        db.collection("feed").get().addOnCompleteListener({
            var list = arrayListOf<Feed>()
            for ( document in it.result!!.documents){
                val feed = document.toObject(Feed::class.java)
                feed?.let { it1 -> list.add(it1)
                    list.add(it1)
                }
            }

            adapter.update(list)
        })
    }


}

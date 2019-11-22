package com.example.kakaotalk_dms.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kakaotalk_dms.ui.adapter.FriendsAdapter
import com.example.kakaotalk_dms.model.User

import com.example.kakaotalk_dms.R
import kotlinx.android.synthetic.main.fragment_friends.*

class FriendFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_friends, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val friendAdapter = FriendsAdapter()
        friendsRecycler.adapter = friendAdapter

        val lm = LinearLayoutManager(this.context!!)
        friendsRecycler.layoutManager = lm
        friendsRecycler.setHasFixedSize(true)

        friendAdapter.add(User("석준", "ㅁㄴㅇㄹ","ㅇㅇ"))
        friendAdapter.add(User("a","","ㅇㅜ"))
        friendAdapter.add(User("b","a","ㅣㅇ"))
        friendAdapter.add(User("b","a","ㅏㅇ"))
        friendAdapter.add(User("b","a","ㅓㅇ"))
        friendAdapter.add(User("b","a","ㅋㅇ"))
        friendAdapter.add(User("b","a","ㄴㅇ"))
        friendAdapter.add(User("b","a","ㅗㅇ"))
        friendAdapter.add(User("b","a","ㅛㅇ"))

    }
}

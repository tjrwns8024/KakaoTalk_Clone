package com.example.kakaotalk_dms.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kakaotalk_dms.R
import com.example.kakaotalk_dms.ui.fragment.ChatFragment
import com.example.kakaotalk_dms.ui.fragment.FriendFragment
import com.example.kakaotalk_dms.ui.fragment.ProfileFragment
import com.example.kakaotalk_dms.ui.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.title = "친구"

        supportFragmentManager.beginTransaction().run {
            replace(R.id.main_frame, FriendFragment())
            commit()
        }

        main_menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()
        when(item.itemId){
            R.id.friends ->{
                toolbar.setTitle(" 친구")
                transaction.replace(
                    R.id.main_frame,
                    FriendFragment()
                )
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.chat ->{
                toolbar.setTitle("채팅")
                transaction.replace(
                    R.id.main_frame,
                    ChatFragment()
                )
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile ->{
                toolbar.setTitle("계정")
                transaction.replace(
                    R.id.main_frame,
                    ProfileFragment()
                )
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.setting ->{
                toolbar.setTitle("설정")
                transaction.replace(
                    R.id.main_frame,
                    SettingFragment()
                )
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
            false
        }

}

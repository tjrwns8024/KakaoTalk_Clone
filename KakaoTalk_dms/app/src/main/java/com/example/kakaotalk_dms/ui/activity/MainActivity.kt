package com.example.kakaotalk_dms.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.kakaotalk_dms.R
import com.example.kakaotalk_dms.ui.fragment.ChatFragment
import com.example.kakaotalk_dms.ui.fragment.FriendFragment
import com.example.kakaotalk_dms.ui.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item:MenuItem): Boolean {
        when(item.itemId){
            R.id.id_search->{
                toast("아이디 검색")
            }
            R.id.friend_search->{
                toast("친구 찾기")
            }
        }
        return super.onOptionsItemSelected(item)
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

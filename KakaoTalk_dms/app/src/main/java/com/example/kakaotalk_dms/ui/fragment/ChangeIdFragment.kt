package com.example.kakaotalk_dms.ui.fragment

import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import com.example.kakaotalk_dms.R
import kotlinx.android.synthetic.main.fragment_change_id.*
import kotlinx.android.synthetic.main.fragment_setting.*

class ChangeIdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_change_id, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       change_id_back_btn.setOnClickListener {
               val transaction = activity?.supportFragmentManager?.beginTransaction()?.setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
               transaction?.replace(R.id.main_frame,SettingFragment())
               transaction?.commit()
       }

        change_id_btn.setOnClickListener {
            val builder = AlertDialog.Builder(this.context!!)
            val dialogView = layoutInflater.inflate(R.layout.activity_dialog,null)
            val newId = dialogView.findViewById<EditText>(R.id.new_id)

            builder.setView(dialogView)
                .setPositiveButton("ID 변경"){dialogInterface, i ->
                    checkId.text = newId.text.toString()
                }
                .setNegativeButton("취소"){dialogInterface, i ->

                }
                .show()
        }
    }
}
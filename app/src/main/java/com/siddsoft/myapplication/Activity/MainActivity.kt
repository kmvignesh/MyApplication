package com.siddsoft.myapplication.Activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.siddsoft.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var rootViewGroup: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_dialog.setOnClickListener { showDialog() }
        btn_radio_button.setOnClickListener {
            startActivity(Intent(this, RadioButtonActivity::class.java))
        }
        btn_check_box.setOnClickListener {
            startActivity(Intent(this, CheckBoxActivity::class.java))
        }
        btn_fragment.setOnClickListener {
            startActivity(Intent(this, FragmentActivity::class.java))
        }

    }

    fun showDialog() {
        val builder = AlertDialog.Builder(this)
        val view = this.layoutInflater.inflate(R.layout.dialog_name, rootViewGroup)
        builder.setView(view)
        val etName = view.findViewById<EditText>(R.id.etName)
        builder.setPositiveButton("Okay", { _: DialogInterface, _: Int -> })
        val dialog = builder.create()
        dialog.show()
        dialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener {
            if(etName.length() >= 5){
                dialog.dismiss()
            }else
            {
                showToast("Name must contains at lease 5 characters.")
            }
        }
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

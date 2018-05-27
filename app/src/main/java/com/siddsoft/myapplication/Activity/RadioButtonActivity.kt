package com.siddsoft.myapplication.Activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import com.siddsoft.myapplication.R
import kotlinx.android.synthetic.main.activity_radio_button.*

class RadioButtonActivity : AppCompatActivity() {
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    val KEY = "selectedItem"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)
        sharedPref = getSharedPreferences("Preference", Context.MODE_PRIVATE)
        editor = sharedPref.edit()
        loadPreference()
        rgItems.setOnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = rgItems.findViewById<RadioButton>(checkedId)
            val checkedIndex = rgItems.indexOfChild(checkedRadioButton)
            editor.putInt(KEY, checkedIndex)
            editor.apply()
        }
    }

    fun loadPreference() {
        val index = sharedPref.getInt(KEY, 0)
        val radioButton = rgItems.getChildAt(index) as RadioButton
        radioButton.isChecked = true
    }
}

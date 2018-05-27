package com.siddsoft.myapplication.Activity

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.siddsoft.myapplication.Fragment.BlankFragment
import com.siddsoft.myapplication.R

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        Handler().postDelayed({
            val transaction = supportFragmentManager.beginTransaction()
            val fragment = BlankFragment()
            transaction.replace(R.id.layout_root, fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }, 1000)
    }

}

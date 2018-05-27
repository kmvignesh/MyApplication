package com.siddsoft.myapplication.Activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.siddsoft.myapplication.R
import kotlinx.android.synthetic.main.activity_check_box.*

class CheckBoxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)
        rv_items.layoutManager = LinearLayoutManager(this)
        val list: MutableList<Dto> = ArrayList()
        (0..(100)).forEach {
            val obj = Dto()
            obj.name = "Item " + (it + 1)
            list.add(obj)
        }
        rv_items.adapter = CheckBoxAdapter(list, this)
    }


    class Dto() {
        var name = ""
        var isChecked = false
    }

    class CheckBoxAdapter(val list: MutableList<Dto>, ctx: Context) : RecyclerView.Adapter<CheckBoxAdapter.ViewHolder>() {

        var context = ctx

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.title?.text = "Item " + (position + 1)
            holder?.title?.isChecked = list[position].isChecked
//            holder?.title?.setOnCheckedChangeListener { buttonView, isChecked ->
//                val pos = holder.adapterPosition
//                list[pos].isChecked = !list[pos].isChecked
//            }
            holder?.title?.setOnClickListener {
                val pos = holder.adapterPosition
                list[pos].isChecked = !list[pos].isChecked
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.check_box_child, parent, false))
        }


        class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
            val title = v.findViewById<CheckBox>(R.id.checkBox)
        }
    }
}

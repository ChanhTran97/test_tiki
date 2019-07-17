package com.example.tiki

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*
import java.util.*
import kotlin.collections.ArrayList

class CustomAdapter(var items: ArrayList<String>, var context: Context) :
    RecyclerView.Adapter<KeywordViewHolder>() {

    fun updateData(items: ArrayList<String>) {
        this.items = items
        this.notifyDataSetChanged()
    }

    private fun getRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

    override fun onBindViewHolder(keywordViewHolder: KeywordViewHolder, position: Int) {

        keywordViewHolder.nameKeyword.text = items[position]
        keywordViewHolder.background.setBackgroundColor(getRandomColor())
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): KeywordViewHolder {
        return KeywordViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class KeywordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var background = view.bg
    var nameKeyword = view.tvName
}
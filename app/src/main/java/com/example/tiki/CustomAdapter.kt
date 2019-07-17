package com.example.tiki

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*

class CustomAdapter(var items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<KeywordViewHolder>() {

    override fun onBindViewHolder(keywordViewHolder: KeywordViewHolder, position: Int) {

        keywordViewHolder.nameKeyword.text = items[position].ten
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): KeywordViewHolder {
        return KeywordViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}






class KeywordViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var nameKeyword = view.tvName
}
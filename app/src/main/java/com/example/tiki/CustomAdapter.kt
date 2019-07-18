package com.example.tiki

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
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

    private fun updateText(text: String): String? {
        val textList: List<String> = text.split(" ")
        if (textList.size == 1) {
            return text
        } else if (textList.size == 2) {
            return "".plus(textList[0]).plus("\n").plus(textList[1])
        } else {

            var num = 0

            for (i in 0 until textList.size) {
                num += textList[i].length
            }

            var firstPart = 0
            var secondPart: Int
            var bestfreference: Int = num

            var updateText = ""

            for (i in 0 until textList.size) {
                firstPart += textList[i].length
                secondPart = num - firstPart
                if (secondPart - firstPart > 0) {
                    bestfreference = secondPart - firstPart
                } else {
                    val index = if (firstPart - secondPart < bestfreference) {
                        i
                    } else {
                        i - 1
                    }
                    updateText = ""
                    for (j in 0..index) {
                        updateText += textList[j] + " "
                    }
                    updateText = updateText.dropLast(1)
                    updateText += "\n"

                    for (j in index + 1 until textList.size) {
                        updateText += textList[j] + " "
                    }
                    updateText = updateText.dropLast(1)
                    break
                }
            }
            return updateText
        }
    }

    override fun onBindViewHolder(keywordViewHolder: KeywordViewHolder, position: Int) {

        keywordViewHolder.nameKeyword.text = updateText(items[position])
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
    var background: LinearLayout = view.bg
    var nameKeyword: TextView = view.tvName
}
package com.example.zametco.screens.main

import android.content.ReceiverCallNotAllowedException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zametco.R
import com.example.zametco.models.AppNote
import kotlinx.android.synthetic.main.note_item.view.*

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainHolder>(){

    private var mListNotes = emptyList<AppNote>()

    class MainHolder(view: View):RecyclerView.ViewHolder(view){
        val nameNote:TextView = view.item_note_name
        val textNote:TextView = view.item_note_text
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int = mListNotes.size
    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textNote.text = mListNotes[position].text
        holder.nameNote.text = mListNotes[position].name
    }

    fun setList(list:List<AppNote>){
        mListNotes = list
        notifyDataSetChanged()
    }


}
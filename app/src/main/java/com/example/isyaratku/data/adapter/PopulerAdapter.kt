package com.example.isyaratku.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.isyaratku.R
import com.example.isyaratku.data.model.Populer
import com.example.isyaratku.databinding.ItemTerpopulerBinding

class PopulerAdapter(private val listPopuler: ArrayList<Populer>): RecyclerView.Adapter<PopulerAdapter.ListViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class ListViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTerpopulerBinding.bind(itemView)
        val title = binding.tvItemTitle
        val photo = binding.imgItemPhoto

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_terpopuler, parent, false)
        return ListViewHolder(view, mListener)
    }

    override fun getItemCount(): Int = listPopuler.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listPopuler[position]
        holder.title.text = item.title
        holder.photo.setImageResource(item.image)
    }

}
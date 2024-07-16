package com.example.isyaratku.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.isyaratku.R
import com.example.isyaratku.data.model.Populer
import com.example.isyaratku.databinding.ItemListBinding

class ListAdapter(private val listAngka: ArrayList<Populer>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class ListViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListBinding.bind(itemView)
        val title = binding.tvItem
        val image: ImageView = binding.ivItem
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view, mListener)
    }

    override fun getItemCount(): Int = listAngka.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listAngka[position]
        holder.title.text = item.title
        Glide.with(holder.itemView.context)
            .load(item.image)
            .into(holder.image)
    }

}
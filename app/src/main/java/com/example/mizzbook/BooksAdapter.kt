package com.example.mizzbook

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mizzbook.databinding.HomeBinding

class BooksAdapter (val list: ArrayList<BooksModel>, val context: Context): RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    class ViewHolder (val binding: HomeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HomeBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]

        holder.binding.apply {
            imageView.setImageResource(model.image)
        }
    }

}
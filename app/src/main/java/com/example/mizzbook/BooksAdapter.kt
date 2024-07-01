package com.example.mizzbook

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mizzbook.databinding.HomeBinding

class BooksAdapter (private val list: ArrayList<BooksModel>, private val context: Context): RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    // Kelas dalam / inner class untuk mendefinisikan view holder untuk setiap item buku
    class ViewHolder (val binding: HomeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HomeBinding.inflate(LayoutInflater.from(context),parent,false))
    }
    // Mengembalikan jumlah total item dalam daftar
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]

        holder.binding.apply {
            // Set gambar untuk buku
            imageView.setImageResource(model.image)
            cardView.setOnClickListener {
                // Buat Intent baru
                val intent = Intent()
                // Menambahkan data ke intent untuk diteruskan ke DetailsActivity
                intent.putExtra("book_title", model.title)
                intent.putExtra("book_desc", model.description)
                intent.putExtra("book_pdf", model.bookPDF)
                intent.putExtra("book_image", model.image)

                intent.setClass(context, DetailsActivity::class.java)
//                Membuat animasi agar sedikit smooth saat pindah activity
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, imageView, "bookTransition")

                context.startActivity(intent, options.toBundle())
            }
        }
    }

}
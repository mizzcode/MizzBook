package com.example.mizzbook

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mizzbook.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    // Referensi ke activity saat ini
    val activity = this
    // Referensi ke binding yang akan diinisialisasi nanti
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        // Aktifkan efek edge-to-edge (fit ke seluruh layar)
        setContentView(binding.root)
        enableEdgeToEdge()

        val toolbarTwo = findViewById<LinearLayout>(R.id.toolbar_two)
        val leftIcon = toolbarTwo.findViewById<ImageView>(R.id.leftIcon)
        leftIcon?.setOnClickListener {
            finish()
        }
        // Mendapatkan data buku yang dikirim dari BooksAdapter
        val bookTitle = intent.getStringExtra("book_title").toString()
        val bookDesc = intent.getStringExtra("book_desc").toString()
        val bookPDF = intent.getStringExtra("book_pdf").toString()
        val bookImage = intent.getIntExtra("book_image", 0)
        // Set content view menggunakan root element dari binding
        // Akses elemen UI dengan binding.apply
        binding.apply {
            // Set judul buku ke TextView
            aBookTitle.text = bookTitle
            // Set deskripsi buku ke TextView
            aBookDesc.text = bookDesc
            // Set gambar buku ke ImageView
            aBookImage.setImageResource(bookImage)
            // Ketika tombol "Baca Buku" diklik
            btnReadBook.setOnClickListener {
                // Buat Intent baru
                val intent = Intent()
                // Sertakan URL/path PDF
                intent.putExtra("book_pdf", bookPDF)
                // Set target activity ke PdfActivity
                intent.setClass(activity, PdfActivity::class.java)
                // Memulai activity baru
                startActivity(intent)
            }
        }
        // Penanganan inset (area terhalang status bar/navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
package com.example.mizzbook

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mizzbook.databinding.ActivityPdfBinding

class PdfActivity : AppCompatActivity() {
    // Referensi ke binding yang akan diinisialisasi nanti
    lateinit var binding: ActivityPdfBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfBinding.inflate(layoutInflater)
        // Aktifkan mode full screen
        this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        enableEdgeToEdge()
        setContentView(binding.root)
        // Sembunyikan action bar jika support
        supportActionBar?.hide()
        // Akses elemen UI dengan binding.apply
        binding.apply {
            val bookPDF = intent.getStringExtra("book_pdf").toString()
            // Memuat file PDF dari asset
            pdfView.fromAsset(bookPDF)
                .swipeHorizontal(true)
                .enableSwipe(true)
                .swipeHorizontal(true)
                .pageSnap(true)
                .autoSpacing(true)
                .pageFling(true)
                .load()
        }
        // Penanganan inset (area terhalang status bar/navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
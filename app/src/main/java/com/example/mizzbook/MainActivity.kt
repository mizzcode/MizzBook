package com.example.mizzbook

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mizzbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val activity = this
    val list: ArrayList<BooksModel> = ArrayList()
    val adapter = BooksAdapter(list, activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Akses elemen UI dengan binding.apply
        binding.apply {
            mRecyclerViewHome.adapter = adapter
            list.add(BooksModel(R.drawable.cover_heker, "Buku Sakti Hacker", getString(R.string.description_buku_sakti_hengker), "Buku_Sakti_Hacker.pdf"))
            list.add(BooksModel(R.drawable.book_2, "Atomic Habits", getString(R.string.description_atomic_habit), "Atomic_Habits_by_James_Clear.pdf"))
        }
        // Aktifkan efek edge-to-edge (fit ke seluruh layar)
        enableEdgeToEdge()
        // Penanganan inset (area terhalang status bar/navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
package com.example.mizzbook

import android.os.Bundle
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
            list.add(BooksModel(R.drawable.one_piece_vol_01, "One Piece Volume 1", getString(R.string.description_wanpis_vol1), "one_piece_vol_01.pdf"))
            list.add(BooksModel(R.drawable.one_piece_vol_02, "One Piece Volume 2", getString(R.string.description_wanpis_vol2), "one_piece_vol_02.pdf"))
            list.add(BooksModel(R.drawable.one_piece_vol_03, "One Piece Volume 3", getString(R.string.description_wanpis_vol3), "one_piece_vol_03.pdf"))
            list.add(BooksModel(R.drawable.luffy, "Misbahudin", getString(R.string.misbah), "cv_misbahudin.pdf"))
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
package com.example.isyaratku.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.isyaratku.data.model.Populer
import com.example.isyaratku.databinding.ActivityDetailImageBinding

class DetailImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailImageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val img = binding.ivData
        val text = binding.tvData
        val data = intent.getParcelableExtra<Populer>(EXTRA_DATA)
        if (data != null) {
//            Glide.with(this).asGif().load(data.image).into(img)
            img.setImageResource(data.image)
            text.text = data.title
        }else{
            finish()
        }

        val btnBack = binding.btnBack
        btnBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        val EXTRA_DATA: String = "extra_data"
    }
}
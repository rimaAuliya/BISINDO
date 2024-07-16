package com.example.isyaratku.ui.popular

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.isyaratku.QuizActivity
import com.example.isyaratku.R
import com.example.isyaratku.databinding.ActivityEvaluasiBinding

class EvaluasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEvaluasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEvaluasiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = binding.btnBack
        btnBack.setOnClickListener {
            finish()
        }

        val btnQuiz1 = binding.cvQuiz1
        btnQuiz1.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        val btnQuiz2 = binding.cvQuiz2
        btnQuiz2.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        val btnQuiz3 = binding.cvQuiz3
        btnQuiz3.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        val btnQuiz4 = binding.cvQuiz4
        btnQuiz4.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

    }
}
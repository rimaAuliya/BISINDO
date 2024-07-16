package com.example.isyaratku

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.isyaratku.data.adapter.PopulerAdapter
import com.example.isyaratku.data.model.DataPopuler
import com.example.isyaratku.data.model.Populer
import com.example.isyaratku.ui.popular.AlphabetActivity
import com.example.isyaratku.ui.popular.AngkaActivity
import com.example.isyaratku.ui.popular.EvaluasiActivity
import com.example.isyaratku.ui.popular.KataActivity
import com.example.isyaratku.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvPopuler: RecyclerView
    private var listPopuler: ArrayList<Populer> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvPopuler = binding.rvPopuler
        rvPopuler.setHasFixedSize(true)
        listPopuler.addAll(getList())
        setRecyclerView()

        CoroutineScope(Dispatchers.Main).launch {
            val callback = object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    val dialog = AlertDialog.Builder(this@MainActivity)
                        .setTitle("Keluar dari aplikasi Isyarat")
                        .setMessage("apakah Anda yakin ingin keluar?")
                        .setPositiveButton("Ya") { _, _ ->
                            finish()

                        }
                        .setNegativeButton("Tidak") { dialog, _ ->
                            dialog.cancel()
                        }
                        .create()
                    dialog.show()
                }
            }
            onBackPressedDispatcher.addCallback(callback)
        }

    }

    private fun getList(): ArrayList<Populer> {
        val list = ArrayList<Populer>()
        for (item in DataPopuler.itemPopuler){
            list.add(item)
        }
        return list
    }

    private fun setRecyclerView() {
        rvPopuler.layoutManager = LinearLayoutManager(this)
        val listPopulerAdapter = PopulerAdapter(listPopuler)
        rvPopuler.adapter = listPopulerAdapter

        listPopulerAdapter.setOnItemClickListener(object : PopulerAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val item = DataPopuler.itemPopuler[position]

                val intent = Intent(this@MainActivity, when(item.title) {
                    "Kata Isyarat" -> KataActivity::class.java
                    "Alfabet" -> AlphabetActivity::class.java
                    "Angka" -> AngkaActivity::class.java
                    "Evaluasi" -> EvaluasiActivity::class.java
                    else -> throw IllegalArgumentException("Invalid item name")
                })
                startActivity(intent)
            }
        })
    }
}
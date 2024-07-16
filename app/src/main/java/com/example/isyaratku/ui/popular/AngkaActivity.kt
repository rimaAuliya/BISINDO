package com.example.isyaratku.ui.popular

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.isyaratku.R
import com.example.isyaratku.data.adapter.ListAdapter
import com.example.isyaratku.data.model.DataList
import com.example.isyaratku.data.model.Populer
import com.example.isyaratku.ui.detail.DetailGifActivity
import com.example.isyaratku.databinding.ActivityAngkaBinding
import com.google.android.material.search.SearchView

class AngkaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAngkaBinding
    private lateinit var rvAngka: RecyclerView
    private var listAngka: ArrayList<Populer> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAngkaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvAngka = binding.rvAngka
        rvAngka.setHasFixedSize(true)
        listAngka.addAll(getList())
        setRecyclerView()

        val btnBack = binding.btnBack
        btnBack.setOnClickListener {
            finish()
        }

        fun SearchView.getSearchText(): String {
            val searchView = binding.searchView
            return searchView.text.toString()
        }

        with(binding){
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener { _, _, _ ->
                searchBar.setText(searchView.getSearchText())
                searchView.hide()
                false
            }
        }
    }

    private fun getList(): ArrayList<Populer> {
        val dataAngka = ArrayList<Populer>()
        for (item in DataList.itemAngka){
            dataAngka.add(item)
        }
        return dataAngka
    }

    private fun setRecyclerView() {
        rvAngka.layoutManager = GridLayoutManager(this, 2)
        val listAngkaAdapter = ListAdapter(listAngka)
        rvAngka.adapter = listAngkaAdapter

        listAngkaAdapter.setOnItemClickListener(object : ListAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val selectedAngka = listAngka[position]
                val intent = Intent(this@AngkaActivity, DetailGifActivity::class.java)
                intent.putExtra(DetailGifActivity.EXTRA_DATA, selectedAngka)
                startActivity(intent)
            }

        })
    }
}
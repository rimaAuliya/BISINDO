package com.example.isyaratku.ui.popular

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.isyaratku.data.adapter.ListAdapter
import com.example.isyaratku.data.model.DataList
import com.example.isyaratku.data.model.Populer
import com.example.isyaratku.ui.detail.DetailImageActivity
import com.example.isyaratku.databinding.ActivityAlphabetBinding
import com.google.android.material.search.SearchView

class AlphabetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlphabetBinding
    private lateinit var rvAlfabet: RecyclerView
    private var listAlfabet: ArrayList<Populer> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAlphabetBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvAlfabet = binding.rvAlfabet
        rvAlfabet.setHasFixedSize(true)
        listAlfabet.addAll(getData())
        setRecyclerView()

        val btnBack = binding.btnBack
        btnBack.setOnClickListener {
            finish()
        }

        fun SearchView.getSearchText():String{
            val searchView = binding.searchView
            return searchView.editText.text.toString()
        }

        with(binding){
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener { textView, actionId, event ->
                searchBar.setText(searchView.getSearchText())
                searchView.hide()
                false
            }
        }
    }

    private fun getData(): ArrayList<Populer> {
        val listData = ArrayList<Populer>()
        for (item in DataList.itemAlfabet){
            listData.add(item)
        }
        return listData
    }

    private fun setRecyclerView() {
        rvAlfabet.layoutManager = GridLayoutManager(this, 2)
        val listAlfabetAdapter = ListAdapter(listAlfabet)
        rvAlfabet.adapter = listAlfabetAdapter

        listAlfabetAdapter.setOnItemClickListener(object : ListAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val selectedItem = listAlfabet[position]
                val intent = Intent(this@AlphabetActivity, DetailImageActivity::class.java)
                intent.putExtra(DetailImageActivity.EXTRA_DATA, selectedItem)
                startActivity(intent)
            }

        })
    }
}
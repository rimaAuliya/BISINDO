package com.example.isyaratku.ui.popular

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.isyaratku.data.adapter.ListAdapter
import com.example.isyaratku.data.model.DataList
import com.example.isyaratku.data.model.Populer
import com.example.isyaratku.ui.detail.DetailGifActivity
import com.example.isyaratku.databinding.ActivityKataBinding
import com.example.isyaratku.ui.detail.DetailImageActivity
import com.google.android.material.search.SearchView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKataBinding
    private lateinit var rvKata: RecyclerView
    private var listKata: ArrayList<Populer> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityKataBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvKata = binding.rvKata
        rvKata.setHasFixedSize(true)
        listKata.addAll(getListData())
        setRecyclerView()

        val btnBack = binding.btnBack
        btnBack.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                finish()
            }
        }

        fun SearchView.getSearchText(): String {
            val searchView = binding.searchView
            return searchView.editText.text.toString()
        }

        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener { _, _, _ ->
                searchBar.setText(searchView.getSearchText())
//                    val search = searchBar.text.toString()
                    searchView.hide()
                    false
                }
        }
    }

    private fun getListData(): ArrayList<Populer> {
        val listData = ArrayList<Populer>()
        for (item in DataList.itemKata){
            listData.add(item)
        }
        return listData
    }

    private fun setRecyclerView() {
        rvKata.layoutManager = LinearLayoutManager(this)
        val listKataAdapter = ListAdapter(listKata)
        rvKata.adapter = listKataAdapter

        listKataAdapter.setOnItemClickListener(object : ListAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val selectedData = listKata[position]
                val intent = Intent(this@KataActivity, DetailGifActivity::class.java)
                intent.putExtra(DetailGifActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }
        })
    }

}
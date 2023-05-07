package com.dwiyu.chapter_5_networkingdenganretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dwiyu.chapter_5_networkingdenganretrofit.databinding.ActivityNewsBinding
import com.dwiyu.chapter_5_networkingdenganretrofit.viewmodel.NewsViewModel

class NewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNewsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showDataNews()
        binding.addButton.setOnClickListener{
            startActivity(Intent(this, AddNewsActivity::class.java))
        }
    }

    fun showDataNews(){

        val viewModelNews = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModelNews.callApiNews()
        viewModelNews.liveDataNews.observe(this,{
            if (it != null){
                binding.rvNews2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                binding.rvNews2.adapter = NewsAdapter(it)
            }
        })
    }
}
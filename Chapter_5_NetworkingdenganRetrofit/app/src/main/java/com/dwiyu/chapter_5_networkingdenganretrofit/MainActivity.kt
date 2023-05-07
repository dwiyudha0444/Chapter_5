package com.dwiyu.chapter_5_networkingdenganretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dwiyu.chapter_5_networkingdenganretrofit.databinding.ActivityMainBinding
import com.dwiyu.chapter_5_networkingdenganretrofit.model.ResponseDataNewsItem
import com.dwiyu.chapter_5_networkingdenganretrofit.model.ResponseDataNewsItemItem
import com.dwiyu.chapter_5_networkingdenganretrofit.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataNews()
    }

    fun getDataNews(){
        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<ResponseDataNewsItemItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataNewsItemItem>>,
                response: Response<List<ResponseDataNewsItemItem>>
            ) {
                if(response.isSuccessful){
                    binding.rvNews.layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    binding.rvNews.adapter = NewsAdapter(response.body()!!)
                }else{
                    Toast.makeText(this@MainActivity, "FAILED", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseDataNewsItemItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"",Toast.LENGTH_SHORT).show()
            }

        })
    }


}

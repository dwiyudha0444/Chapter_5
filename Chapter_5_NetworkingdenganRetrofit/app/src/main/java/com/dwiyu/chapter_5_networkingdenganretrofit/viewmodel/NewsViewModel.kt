package com.dwiyu.chapter_5_networkingdenganretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dwiyu.chapter_5_networkingdenganretrofit.model.DataNews
import com.dwiyu.chapter_5_networkingdenganretrofit.model.ResponseAddNews
import com.dwiyu.chapter_5_networkingdenganretrofit.model.ResponseDataNewsItemItem
import com.dwiyu.chapter_5_networkingdenganretrofit.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    lateinit var liveDataNews : MutableLiveData<List<ResponseDataNewsItemItem>>
    lateinit var postDataNews : MutableLiveData<ResponseAddNews>

    init {
        liveDataNews = MutableLiveData()
        postDataNews = MutableLiveData()
    }

   // fun getLiveData():MutableLiveData<ResponseDataNewsItemItem>{
   //     return liveDataNews
   // }

    fun postNews():MutableLiveData<ResponseAddNews>{
        return postDataNews

    }

    fun callApiNews(){
        RetrofitClient.instance.getAllNews()
            .enqueue(object : Callback<List<ResponseDataNewsItemItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataNewsItemItem>>,
                    response: Response<List<ResponseDataNewsItemItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataNews.postValue(response.body())
                    }else{
                        liveDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataNewsItemItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }
            })
    }

    fun addDataNews(title : String,image : String, author : String, desc : String){
         RetrofitClient.instance.postDataNews(DataNews(title, image, author, desc))
             .enqueue(object  : Callback<ResponseAddNews>
         {
             override fun onResponse(
                 call: Call<ResponseAddNews>,
                 response: Response<ResponseAddNews>
             ) {
                 if (response.isSuccessful){
                     postDataNews.postValue(response.body())
                 }else{
                     postDataNews.postValue(null)
                 }
             }

             override fun onFailure(call: Call<ResponseAddNews>, t: Throwable) {
                 postDataNews.postValue(null)
             }

         })
    }

}
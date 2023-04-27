package com.example.tilek_shambetaliev_hw5_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tilek_shambetaliev_hw5_3.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var page = 1
    var adapter = PixaAdapter(arrayListOf())
    var list = arrayListOf<ImageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnNewpage.setOnClickListener {
                ++page
                requestImages(page)

            }
            btnSearch.setOnClickListener {
                requestImages(page)
                adapter.list.clear()
            }
        }
    }
    private fun ActivityMainBinding.requestImages(page: Int){
        RetrofitService().api.getImages(etSearch.text.toString(),page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(
                    call: Call<PixaModel>,
                    response: Response<PixaModel>
                ) {
                    response.body()?.let {
                        list = it.hits
                        adapter.addImages(list)
                        rvImage.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                }
            })
    }
}
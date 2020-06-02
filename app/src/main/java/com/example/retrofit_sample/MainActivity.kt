package com.example.retrofit_sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var myRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val service: GetData = RetroFitClient.myApi.retroFitService
        val call: Call<MutableList<RetroUsers>> = service.getAllUsers()



        if (call != null) {
            call.enqueue(object : Callback<MutableList<RetroUsers?>?> {

                override fun onResponse(
                    call: Call<MutableList<RetroUsers?>?>,
                    response: Response<MutableList<RetroUsers?>?>
                ) {
                    loadDataList(response.body())
                }

                override fun onFailure(call: Call<MutableList<RetroUsers?>?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Unable to load users", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }


    }


private fun loadDataList(usersList: MutableList<RetroUsers?>?) {
        myRecyclerView = findViewById(R.id.rvMyRecyclerView)
        myAdapter = MyAdapter(usersList)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this@MainActivity)
        myRecyclerView.layoutManager = layoutManager
        myRecyclerView.adapter = myAdapter
    }
}







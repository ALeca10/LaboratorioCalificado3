package com.example.laboratoriocalificado3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratoriocalificado3.adapter.TeacherAdapter
import com.example.laboratoriocalificado3.databinding.ActivityMainBinding
import com.example.laboratoriocalificado3.model.Teacher
import com.example.laboratoriocalificado3.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        val apiService = RetrofitInstance.api
        apiService.getTeachers().enqueue(object : Callback<List<Teacher>> {
            override fun onResponse(call: Call<List<Teacher>>, response: Response<List<Teacher>>) {
                if (response.isSuccessful) {
                    val teachers = response.body()
                    teachers?.let {
                        binding.recyclerView.adapter = TeacherAdapter(it)
                    }
                } else {
                    Log.e("MainActivity", "Error al obtener datos: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Teacher>>, t: Throwable) {
                Log.e("MainActivity", "Error al realizar solicitud: ${t.message}", t)
            }
        })
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
    }
}

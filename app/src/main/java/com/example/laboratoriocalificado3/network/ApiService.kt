package com.example.laboratoriocalificado3.network

import com.example.laboratoriocalificado3.model.Teacher
import retrofit2.Call
import retrofit2.http.GET

public interface ApiService {
    @GET("/list/teacher-b")
    fun getTeachers(): Call<List<Teacher>>
}
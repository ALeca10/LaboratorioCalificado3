package com.example.laboratoriocalificado3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratoriocalificado3.databinding.ItemTeacherBinding
import com.example.laboratoriocalificado3.model.Teacher
import com.squareup.picasso.Picasso

class TeacherAdapter (private val teachers: List<Teacher>):
    RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(private val binding: ItemTeacherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(teacher: Teacher) {
            binding.apply {
                teacherName.text = teacher.name
                teacherLastName.text = teacher.last_name
                teacherPhoneNumber.text = teacher.phone_number
                teacherEmail.text = teacher.email
                Picasso.get().load(teacher.image_url).into(teacherImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val binding = ItemTeacherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeacherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.bind(teachers[position])
    }

    override fun getItemCount(): Int = teachers.size
}
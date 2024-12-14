package com.example.task_app

import RecyclerAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task_app.databinding.ActivitySecond_screenBinding
import androidx.recyclerview.widget.RecyclerView


class SecondScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecond_screen.inflate(layoutInflater)
        setContentView(binding.root)

        // Collect data passed from the MainActivity
        val data = ArrayList<Array<String?>>()
        data.add(
            arrayOf(
                intent.getStringExtra("name"),
                intent.getStringExtra("email"),
                intent.getStringExtra("gender"),
                intent.getStringExtra("country")
            )
        )

        // Set up RecyclerView with the adapter
        val adapter = RecyclerAdapter(data)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }
}

package com.example.task_app



import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task_app.adapter.RecyclerAdapter
import com.example.task_app.databinding.SecondscreenBinding


class SecondScreen : AppCompatActivity() {
    lateinit var binding: SecondscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = SecondscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val country = intent.getStringExtra("country")


        val data = listOf(
            mapOf(
                "Name" to name,
                "Email" to email,
                "Gender" to gender,
                "Country" to country
            )
        )
        // Set up RecyclerView with the adapter
        val adapter = RecyclerAdapter(data)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }
}


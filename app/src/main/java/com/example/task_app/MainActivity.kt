package com.example.task_app

import android.R.attr.name
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val countryAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            arrayOf("Nepal", "India", "USA", "UK")
        )
        binding.SubmitButton.setOnClickListener{
            val fullname:String=binding.nameFeild.text.toString()
            val email:String=binding.emailFeild.text.toString()
            val password:String=binding.passFeild.text.toString()
            val selectedGenderId: Int = binding.itemGender.checkedRadioButtonId
            val gender: String = if (selectedGenderId != -1) {
                binding.itemGender.findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                "Not Specified" // Handle case where no gender is selected
            }
            val country: String = binding.countryspinner.selectedItem.toString()
            val intent = Intent(this@MainActivity,second_screen::class.java
            )
            intent.putExtra("name", fullname)
            intent.putExtra("email", email)
            intent.putExtra("gender",selectedGenderId)
            intent.putExtra("country", country)
            startActivity(intent)
        }
    }
}

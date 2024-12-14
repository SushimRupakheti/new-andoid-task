package com.example.task_app


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
        binding.countryspinner.adapter=countryAdapter
        binding.SubmitButton.setOnClickListener{
            val fullname=binding.nameFeild.text.toString()
            val email=binding.emailFeild.text.toString()
            val password=binding.passFeild.text.toString()
            val selectedGenderId= binding.itemGender.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                binding.itemGender.findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                "Not Specified" // Handle case where no gender is selected
            }
            val country= binding.countryspinner.selectedItem.toString()
            val intent = Intent(this@MainActivity,SecondScreen::class.java).apply {
            intent.putExtra("name", fullname)
            intent.putExtra("email", email)
            intent.putExtra("gender",gender)
            intent.putExtra("country", country)}
            startActivity(intent)
        }
    }
}

package com.example.appgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.appgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var binding: ActivityMainBinding
    private val questions = arrayListOf<CharSequence>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textView = findViewById(R.id.numQu)
        binding.btnAdd.setOnClickListener {
            if (binding.etQuestion.text.isNotEmpty()) {
                val q = binding.etQuestion.text.toString()
                questions.add(q)
                binding.etQuestion.text.clear()
                textView.text = "Number Questions :" +" "+ questions.size.toString()

            } else {
                Toast.makeText(this, "Add Questions", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btnStart.setOnClickListener {
            if(questions.size >= 2){
                val intent = Intent(this,Game::class.java)
                intent.putExtra("Questions",questions)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Must have more 2 Questions than", Toast.LENGTH_SHORT).show()
            }

        }
    }


}
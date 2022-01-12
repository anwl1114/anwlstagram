package com.example.countryyouquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import com.example.countryyouquiz.databinding.ActivityMainBinding
import com.example.countryyouquiz.databinding.ActivityResultBinding
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(constants.USER_NAME)
        tv_name.text = username.toString()

        val totalQuestions = intent.getIntExtra(constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(constants.CORRECT_ANSWERS, 0)

        tv_score.text = "Your Score is $correctAnswers out of $totalQuestions"

       binding.btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
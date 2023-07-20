package com.macrogallant.quizapplicationmg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.macrogallant.quizapplicationmg.QuizQNA.QuizQNA

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val btnFinish = findViewById<Button>(R.id.btn_finish)

        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val totalQuestions = intent.getIntExtra(QuizQNA.TOTAL_QUESTION, 0)
        val correctAnswer = intent.getIntExtra(QuizQNA.CORRECT_ANSWER, 0)
        tvScore.text = "Your Score is $correctAnswer out of $totalQuestions"
        btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}
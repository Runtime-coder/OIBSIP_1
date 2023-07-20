package com.macrogallant.quizapplicationmg

import android.content.Intent
import android.graphics.ColorSpace.Rgb
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val window: Window = this@MainActivity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.mainStatusColor)
        val btn = findViewById<Button>(R.id.nextBtn)
        btn.setOnClickListener {
            val intent = Intent(this,QuizActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

}
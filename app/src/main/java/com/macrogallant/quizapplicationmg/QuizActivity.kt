package com.macrogallant.quizapplicationmg

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.macrogallant.quizapplicationmg.QuizQNA.QuizQNA

class QuizActivity : AppCompatActivity(), View.OnClickListener {
    private var mQuestionList: ArrayList<QuizQuestion>? = null
    private var mCurrentPosition: Int = 1
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        supportActionBar?.hide()
        val window: Window = this@QuizActivity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this@QuizActivity, R.color.quizStatusBarColor)
        val optionOne = findViewById<TextView>(R.id.tv_option_one)
        val optionTwo = findViewById<TextView>(R.id.tv_option_two)
        val optionThree = findViewById<TextView>(R.id.tv_option_three)
        val optionFour = findViewById<TextView>(R.id.tv_option_four)

        mQuestionList = QuizQNA.getQuestions()
        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)

        val btnSubmit = findViewById<Button>(R.id.btn_submit)
        btnSubmit.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        val progress = findViewById<TextView>(R.id.tv_progress)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val questions = findViewById<TextView>(R.id.tv_question)
        val optionOne = findViewById<TextView>(R.id.tv_option_one)
        val optionTwo = findViewById<TextView>(R.id.tv_option_two)
        val optionThree = findViewById<TextView>(R.id.tv_option_three)
        val optionFour = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)


        val question: QuizQuestion = mQuestionList!![mCurrentPosition - 1]


        progressBar.max = mQuestionList!!.size
        progressBar.progress = mCurrentPosition

        progress.text = "$mCurrentPosition" + "/" + mQuestionList!!.size

        questions.text = question.question
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour

        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit.text = "finish"
        } else {
            btnSubmit.text = "submit"
        }
    }

    private fun defaultOptionsView() {
        val optionOne = findViewById<TextView>(R.id.tv_option_one)
        val optionTwo = findViewById<TextView>(R.id.tv_option_two)
        val optionThree = findViewById<TextView>(R.id.tv_option_three)
        val optionFour = findViewById<TextView>(R.id.tv_option_four)

        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionThree)
        options.add(3, optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8080"))
            option.typeface = Typeface.DEFAULT
            option.background =
                ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.select_option_border_bg)

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        val optionOne = findViewById<TextView>(R.id.tv_option_one)
        val optionTwo = findViewById<TextView>(R.id.tv_option_two)
        val optionThree = findViewById<TextView>(R.id.tv_option_three)
        val optionFour = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)
        when (p0?.id) {
            R.id.tv_option_one -> {
                optionOne.isEnabled = true
                selectedOptionView(optionOne, 1)
            }
            R.id.tv_option_two -> {
                optionOne.isEnabled = true
                selectedOptionView(optionTwo, 2)
            }
            R.id.tv_option_three -> {
                optionOne.isEnabled = true
                selectedOptionView(optionThree, 3)
            }
            R.id.tv_option_four -> {
                optionOne.isEnabled = true
                selectedOptionView(optionFour, 4)
            }
            R.id.btn_submit ->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                            optionOne.isEnabled = true
                            optionTwo.isEnabled = true
                            optionThree.isEnabled = true
                            optionFour.isEnabled = true
                        }else ->{
                        val intent = Intent(this@QuizActivity, ResultActivity::class.java)
                        intent.putExtra(QuizQNA.CORRECT_ANSWER, mCorrectAnswer)
                        intent.putExtra(QuizQNA.TOTAL_QUESTION,mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    }

                }else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    if (mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit.text = "finish"
                        optionOne.isEnabled = false
                        optionTwo.isEnabled = false
                        optionThree.isEnabled = false
                        optionFour.isEnabled = false
                    }else{
                        btnSubmit.text = "Go to next question"
                        optionOne.isEnabled = false
                        optionTwo.isEnabled = false
                        optionThree.isEnabled = false
                        optionFour.isEnabled = false

                    }
                    mSelectedOptionPosition = 0
                }

            }
        }
    }

    private fun answerView(answer: Int,drawerView: Int){
        val optionOne = findViewById<TextView>(R.id.tv_option_one)
        val optionTwo = findViewById<TextView>(R.id.tv_option_two)
        val optionThree = findViewById<TextView>(R.id.tv_option_three)
        val optionFour = findViewById<TextView>(R.id.tv_option_four)
        when(answer){
            1 ->{
                optionOne.background = ContextCompat.getDrawable(this,drawerView)
            }
            2 ->{
                optionTwo.background = ContextCompat.getDrawable(this,drawerView)
            }
            3 ->{
                optionThree.background = ContextCompat.getDrawable(this,drawerView)
            }
            4 ->{
                optionFour.background = ContextCompat.getDrawable(this,drawerView)
            }
        }
    }
}
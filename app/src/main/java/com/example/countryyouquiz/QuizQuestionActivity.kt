package com.example.countryyouquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.countryyouquiz.constants.TOTAL_QUESTIONS
import com.example.countryyouquiz.constants.USER_NAME
import com.example.countryyouquiz.databinding.ActivityMainBinding
import com.example.countryyouquiz.databinding.ActivityQuizQuestionBinding
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mcurrentPostion: Int = 1
    private var mquestionsList: ArrayList<Question>? = null
    private var mselectedOptionPosition: Int = 0
    private var mcorrectAnswers: Int = 0
    private var muserName: String? = null



//        private lateinit var binding: ActivityQuizQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

//        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        muserName = intent.getStringExtra(constants.USER_NAME)

        mquestionsList = constants.getQuestions()
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question = mquestionsList!![mcurrentPostion - 1]

        defaultOptionsView()

        if (mcurrentPostion == mquestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mcurrentPostion
        tv_progress.text = "$mcurrentPostion" + "/" + progressBar.max

        tv_question.text = question!!.question
        tv_image.setImageResource(question.image)
        tv_option_one.text = question.optionone
        tv_option_two.text = question.optiontwo
        tv_option_three.text = question.optionthree
        tv_option_four.text = question.optionfour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#363A43"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mselectedOptionPosition == 0) {
                    mcurrentPostion++

                    when {
                        mcurrentPostion <= mquestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(constants.USER_NAME, muserName)
                            intent.putExtra(constants.CORRECT_ANSWERS, mcorrectAnswers)
                            intent.putExtra(constants.TOTAL_QUESTIONS, mquestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mquestionsList?.get(mcurrentPostion - 1)
                    if (question!!.correctAnswer != mselectedOptionPosition) {
                        answerView(mselectedOptionPosition, R.drawable.red_option_border_bg)
                    } else {
                        mcorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.green_option_border_bg)

                    if (mcurrentPostion == mquestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mselectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mselectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}
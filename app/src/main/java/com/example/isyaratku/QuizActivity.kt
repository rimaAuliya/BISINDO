package com.example.isyaratku

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.isyaratku.data.model.Constant
import com.example.isyaratku.data.model.Question
import com.example.isyaratku.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuizBinding
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuizBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mQuestionsList = Constant.getQuestions()
        setQuestion()

        binding.tvOptions1.setOnClickListener(this)
        binding.tvOptions2.setOnClickListener (this)
        binding.tvOptions3.setOnClickListener (this)
        binding.tvOptions4.setOnClickListener (this)
        binding.btnSubmit.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion(){
        val question = mQuestionsList!![mCurrentPosition - 1]

        binding.pbQuestions.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition" + "/" + "${binding.pbQuestions.max}"

        defaultOptionViews()

        if (mCurrentPosition == mQuestionsList!!.size){
            binding.btnSubmit.text = "FINISH"
        }else{
            binding.btnSubmit.text = "SUBMIT"
        }

        binding.tvQuestions.text = question!!.question
        Glide.with(this).asGif().load(question.image).into(binding.ivQuestions)

        binding.tvOptions1.text = question.option1
        binding.tvOptions2.text = question.option2
        binding.tvOptions3.text = question.option3
        binding.tvOptions4.text = question.option4
    }

    private fun defaultOptionViews(){
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptions1)
        options.add(1, binding.tvOptions2)
        options.add(2, binding.tvOptions3)
        options.add(3, binding.tvOptions4)

        for (option in options){
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.buttons_background)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tvOptions1 -> {
                selectedOptionView(binding.tvOptions1, 1)
            }
            R.id.tvOptions2 -> {
                selectedOptionView(binding.tvOptions2, 2)
            }
            R.id.tvOptions3 -> {
                selectedOptionView(binding.tvOptions3, 3)
            }
            R.id.tvOptions4 -> {
                selectedOptionView(binding.tvOptions4, 4)
            }
            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constant.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constant.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.when_answer_wrong)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.when_answer_correct)
                    if (mCurrentPosition == mQuestionsList!!.size){
                        binding.btnSubmit.text = "FINISH"
                    }else{
                        binding.btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                binding.tvOptions1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                binding.tvOptions2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                binding.tvOptions3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                binding.tvOptions4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(textView: TextView, selected:Int){
        defaultOptionViews()
        mSelectedOptionPosition = selected
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.when_option_selected)
    }
}
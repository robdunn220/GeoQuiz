package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_americas, true),
        Question(R.string.question_australia, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_oceans, true)
    )

    private var currentIndex = 0

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val messageResId = if (userAnswer == questionBank[currentIndex].answer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(
            this,
            messageResId,
            Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        prevButton = findViewById(R.id.prev_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        prevButton.setOnClickListener { view: View ->
            currentIndex =
                if (currentIndex == 0) {
                questionBank.lastIndex
                } else {
                    (currentIndex - 1) % questionBank.size
                }
            updateQuestion()
        }

        nextButton.setOnClickListener { view: View ->
            println(currentIndex)
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        updateQuestion()

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

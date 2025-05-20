package za.ac.iie.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Questions : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was president in 1994",
        "World War I ended in 1945",
        "The Great Wall of China is visible from space",
        "The pyramids are in Egypt",
        "The Berlin Wall fell in 1989"
    )

    private val answers = arrayOf(true, false, false, true, true)
    private var currentQuestion = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        questionText = findViewById(R.id.txtQuest)
        feedbackText = findViewById(R.id.txtFeedb)
        trueButton = findViewById(R.id.btnTrue)
        falseButton = findViewById(R.id.btnFalse)
        nextButton = findViewById(R.id.btnNext)

        loadQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            currentQuestion++
            if (currentQuestion < questions.size) {
                loadQuestion()
            } else {
                val intent = Intent(this, Scores::class.java)
                intent.putExtra("score", score)
                intent.putExtra("Questions",questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionText.text = questions[currentQuestion]
        feedbackText.text = ""
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextButton.isEnabled = false
    }

    @SuppressLint("SetTextI18n")
    private fun checkAnswer(userAnswer: Boolean) {
        val correct = answers[currentQuestion] == userAnswer
        if (correct) {
            feedbackText.text = "Correct!"
            score++
        } else {
            feedbackText.text = "Incorrect!"
        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true
    }
}























package za.ac.iie.assignment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Scores : AppCompatActivity() {
    private val questions = arrayOf(

        "Nelson Mandela was president in 1994",
        "World War I ended in 1945",
        "The Great Wall of China is visible from space",
        "The pyramids are in Egypt",
        "The Berlin Wall fell in 1989"
    )

    private val answers = arrayOf(true, false, false, true, true)

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_scores)



        val score = intent.getIntExtra("score", 0)
        val scoreText: TextView = findViewById(R.id.txtScore)
        val reviewButton: Button = findViewById(R.id.btnReview)
        val exitButton: Button = findViewById(R.id.btnExit)

        val feedback = if (score >= 3) "Great job!" else "Keep practising!"

        scoreText.text = "Your Score: $score / 5\n$feedback"

        reviewButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val reviewText = questions.mapIndexed { index, q ->
                "$q\nAnswer: ${if (answers[index]) "True" else "False"}\n"
            }.joinToString("\n")

            builder.setTitle("Review Answers")
                .setMessage(reviewText)
                .setPositiveButton("OK", null)
                .show()
        }

        exitButton.setOnClickListener {
            finishAffinity() // Terminates the app
        }
    }
}

























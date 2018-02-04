package com.example.higherorlower

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var randomNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignRandomNumber()
        createListerForButton()
    }

    private fun generateRandomNumber(min: Int = 1, max: Int = 10): Int {
        val random = Random()
        randomNum = random.nextInt((max - min) + 1) + min

        return randomNum
    }

    private fun createListerForButton() {
        btnGuess.setOnClickListener {
            if (numGuess.text.isBlank()) {
                toast(getString(R.string.enterNumber))
            } else {
                guessNumber()
            }

        }
    }

    private fun guessNumber() {
        val userGuess = numGuess.text.toString().toInt()

        checkUserGuess(userGuess)
    }

    private fun checkUserGuess(userGuess: Int) {
        when {
            userGuess > randomNum -> lblFeedback.text = getString(R.string.lower)
            userGuess < randomNum -> lblFeedback.text = getString(R.string.higher)
            else -> {
                lblFeedback.text = getString(R.string.correct)
                openCorrectGuessScreen()
            }
        }
        numGuess.text.clear()
    }

    private fun assignRandomNumber() {
        randomNum = generateRandomNumber()
    }

    private fun openCorrectGuessScreen() {
        val intent = Intent(this, CorrectGuessActivity::class.java)
        startActivity(intent)
    }
}

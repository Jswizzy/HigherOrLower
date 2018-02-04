package com.example.higherorlower

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_correct_guess.*

class CorrectGuessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correct_guess)

        playAgain()
        exitGame()
    }

    private fun playAgain() {
        btnPlayAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun exitGame() {
        btnExit.setOnClickListener {
            this.finishAffinity()
        }
    }
}

package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var correctScore: Int = 0
    private var errorCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initChecker()
    }

    private fun initChecker() {
        binding.btnSubmit.setOnClickListener {
            resetScore()
            checkFirstCase()
            checkSecondCase()
            checkThirdCase()
            checkFourthCase()
            displayResult()
        }
    }

    private fun resetScore() {
        correctScore = 0
        errorCount = 0
    }

    private fun checkSequence(conjunction: String, answer: String) {
        if (answer.isEmpty()) errorCount++

        if (conjunction.contains("F")) {
            if (answer == "F") {
                correctScore++
            }
        } else {
            if (answer == "T") {
                correctScore++
            }
        }
    }

    private fun checkFirstCase() {
        val fullConjunction = binding.tvAFirst.text.toString() + binding.tvBFirst.text.toString()
        val answer = binding.tbFirst.text.toString()
        checkSequence(fullConjunction, answer)
    }

    private fun checkSecondCase() {
        val fullConjunction = binding.tvASecond.text.toString() + binding.tvBSecond.text.toString()
        val answer = binding.tbSecond.text.toString()
        checkSequence(fullConjunction, answer)
    }

    private fun checkThirdCase() {
        val fullConjunction = binding.tvAThird.text.toString() + binding.tvBThird.text.toString()
        val answer = binding.tbThird.text.toString()
        checkSequence(fullConjunction, answer)
    }

    private fun checkFourthCase() {
        val fullConjunction = binding.tvAFourth.text.toString() + binding.tvBFourth.text.toString()
        val answer = binding.tbFourth.text.toString()
        checkSequence(fullConjunction, answer)
    }

    private fun displayResult() {
        if (errorCount > 0) {
            displayError()
        } else {
            displayScore()
        }
    }

    private fun displayScore() {
        Toast.makeText(this, getString(R.string.score) + correctScore, Toast.LENGTH_SHORT).show()
    }


    private fun displayError() {
        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
    }

}
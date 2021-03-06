package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
//            /* Show on display *\
            val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
//            /* change the TextView *\
//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
            rollDice()

        }

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val imageResult: ImageView = findViewById(R.id.imageView)
        imageResult.setImageResource(R.drawable.falseicon)
        if(diceRoll === 6) {
            imageResult.setImageResource(R.drawable.dice6)
        }
        if(diceRoll === 5) {
            imageResult.setImageResource(R.drawable.dice5)
        }
        if(diceRoll===4){
            imageResult.setImageResource(R.drawable.dice4)
        }
        if(diceRoll===3){
            imageResult.setImageResource(R.drawable.dice3)
        }
        if(diceRoll===2){
            imageResult.setImageResource(R.drawable.dice2)
        }
        if(diceRoll===1){
            imageResult.setImageResource(R.drawable.dice1)
        }



        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
//      Converting the number result to String for the use in textView
        resultTextView.text = diceRoll.toString()



    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
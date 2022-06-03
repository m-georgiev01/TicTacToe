package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources

class GameActivity : AppCompatActivity() {

    private var currentPlayer = 1

    private var playerOnePoints = 0
    private var playerTwoPoints = 0
    private lateinit var lblPlayerOne : TextView
    private lateinit var lblPlayerTwo : TextView

    private lateinit var playerOneName:String
    private lateinit var playerTwoName:String

    private lateinit var box1:ImageView
    private lateinit var box2:ImageView
    private lateinit var box3:ImageView
    private lateinit var box4:ImageView
    private lateinit var box5:ImageView
    private lateinit var box6:ImageView
    private lateinit var box7:ImageView
    private lateinit var box8:ImageView
    private lateinit var box9:ImageView

    private lateinit var btnNewGame:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        displayPlayersNames()
        setup()
    }

    private fun setup(){
        box1 = findViewById(R.id.b1)
        box2 = findViewById(R.id.b2)
        box3 = findViewById(R.id.b3)
        box4 = findViewById(R.id.b4)
        box5 = findViewById(R.id.b5)
        box6 = findViewById(R.id.b6)
        box7 = findViewById(R.id.b7)
        box8 = findViewById(R.id.b8)
        box9 = findViewById(R.id.b9)
        btnNewGame = findViewById(R.id.btnNewGame)

        box1.setOnClickListener{
            onBoxClicked(box1)
        }
        box2.setOnClickListener{
            onBoxClicked(box2)
        }
        box3.setOnClickListener{
            onBoxClicked(box3)
        }
        box4.setOnClickListener{
            onBoxClicked(box4)
        }
        box5.setOnClickListener{
            onBoxClicked(box5)
        }
        box6.setOnClickListener{
            onBoxClicked(box6)
        }
        box7.setOnClickListener{
            onBoxClicked(box7)
        }
        box8.setOnClickListener{
            onBoxClicked(box8)
        }
        box9.setOnClickListener{
            onBoxClicked(box9)
        }
        btnNewGame.setOnClickListener{
            clearBoxes()
            currentPlayer = 1
        }
    }

    private fun onBoxClicked(box:ImageView){

        if (box.background == null){
            if (currentPlayer == 1){
                box.background = AppCompatResources.getDrawable(this,R.drawable.x)
                checkWin(currentPlayer)
                currentPlayer = 2
                checkDraw()

            }
            else{
                box.background = AppCompatResources.getDrawable(this,R.drawable.o)
                checkWin(currentPlayer)
                currentPlayer = 1
                checkDraw()
            }
        }

    }

    private fun displayPlayersNames(){
        playerOneName = intent.getStringExtra("pOneName").orEmpty()
        playerTwoName = intent.getStringExtra("pTwoName").orEmpty()

        //Added playerPoints in string.xml
        lblPlayerOne = findViewById(R.id.lblPlayerOnePoints)
        lblPlayerOne.text = getString(R.string.playersPoints, playerOneName, playerOnePoints)

        lblPlayerTwo = findViewById(R.id.lblPlayerTwoPoints)
        lblPlayerTwo.text = getString(R.string.playersPoints, playerTwoName, playerTwoPoints)
    }

    private fun checkWin(player:Int){

        if(player == 1){
            checkWinPlayerX()
        }
        else if(player == 2){
            checkWinPlayerO()
        }
    }

    private fun checkWinPlayerX(){
        val drawblX = AppCompatResources.getDrawable(this,R.drawable.x)?.constantState

        val msg = AlertDialog.Builder(this)
        msg.setTitle("Congratulations!")
        msg.setMessage("$playerOneName won!")
        msg.setPositiveButton("Next game"){_,_ -> }

        //row1 , row2, row3, col1, col2, col3, d1, d2
        if ((box1.background?.constantState == drawblX && box2.background?.constantState == drawblX && box3.background?.constantState == drawblX) ||
            (box4.background?.constantState == drawblX && box5.background?.constantState == drawblX && box6.background?.constantState == drawblX) ||
            (box7.background?.constantState == drawblX && box8.background?.constantState == drawblX && box9.background?.constantState == drawblX) ||
            (box1.background?.constantState == drawblX && box4.background?.constantState == drawblX && box7.background?.constantState == drawblX) ||
            (box2.background?.constantState == drawblX && box5.background?.constantState == drawblX && box8.background?.constantState == drawblX) ||
            (box3.background?.constantState == drawblX && box6.background?.constantState == drawblX && box9.background?.constantState == drawblX) ||
            (box1.background?.constantState == drawblX && box5.background?.constantState == drawblX && box9.background?.constantState == drawblX) ||
            (box3.background?.constantState == drawblX && box5.background?.constantState == drawblX && box7.background?.constantState == drawblX)){

            msg.show()
            clearBoxes()
            playerOnePoints++
            displayPlayersNames()
        }

    }

    private fun checkWinPlayerO(){
        val drawblO = AppCompatResources.getDrawable(this,R.drawable.o)?.constantState

        val msg = AlertDialog.Builder(this)
        msg.setTitle("Congratulations!")
        msg.setMessage("$playerTwoName won!")
        msg.setPositiveButton("Next game"){_,_ -> }

        if ((box1.background?.constantState == drawblO && box2.background?.constantState == drawblO && box3.background?.constantState == drawblO) ||
            (box4.background?.constantState == drawblO && box5.background?.constantState == drawblO && box6.background?.constantState == drawblO) ||
            (box7.background?.constantState == drawblO && box8.background?.constantState == drawblO && box9.background?.constantState == drawblO) ||
            (box1.background?.constantState == drawblO && box4.background?.constantState == drawblO && box7.background?.constantState == drawblO) ||
            (box2.background?.constantState == drawblO && box5.background?.constantState == drawblO && box8.background?.constantState == drawblO) ||
            (box3.background?.constantState == drawblO && box6.background?.constantState == drawblO && box9.background?.constantState == drawblO) ||
            (box1.background?.constantState == drawblO && box5.background?.constantState == drawblO && box9.background?.constantState == drawblO) ||
            (box3.background?.constantState == drawblO && box5.background?.constantState == drawblO && box7.background?.constantState == drawblO)){

            msg.show()
            clearBoxes()
            playerTwoPoints++
            displayPlayersNames()
        }
    }

    private fun clearBoxes(){
        box1.background = null
        box2.background = null
        box3.background = null
        box4.background = null
        box5.background = null
        box6.background = null
        box7.background = null
        box8.background = null
        box9.background = null
    }

    private fun checkDraw(){
        if(box1.background != null && box2.background != null && box3.background != null && box4.background != null &&
            box5.background != null && box6.background != null && box7.background != null && box8.background != null &&
            box9.background != null){

            val msg = AlertDialog.Builder(this)
            msg.setTitle("It's a draw!")
            msg.setMessage("Better luck next time!")
            msg.setPositiveButton("Next game"){_,_ -> }
            msg.show()
            clearBoxes()
            currentPlayer = 1
        }
    }
}
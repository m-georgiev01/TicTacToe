package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnNewGame: Button
    lateinit var etPlayerOneName: EditText
    lateinit var etPlayerTwoName: EditText
    lateinit var pOneName:String
    lateinit var pTwoName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNewGame = findViewById(R.id.btnStartGame)
        etPlayerOneName = findViewById(R.id.etPlayerOne)
        etPlayerTwoName = findViewById(R.id.etPlayerTwo)

        btnNewGame.setOnClickListener{
            setIntent()
        }
    }

    private fun setIntent(){
        pOneName = etPlayerOneName.text.toString().trim()
        pTwoName = etPlayerTwoName.text.toString().trim()

        if (pOneName == "" || pTwoName == ""){
            //Toast is used to display short/long notifications/messages
            Toast.makeText(this, "You must enter a name!", Toast.LENGTH_SHORT).show()
            return;
        }

        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("pOneName", pOneName)
        intent.putExtra("pTwoName", pTwoName)
        startActivity(intent)
    }
    }


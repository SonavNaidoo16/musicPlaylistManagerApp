package com.example.musicplaylistmanagerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnGo = findViewById<Button>(R.id.btnGo)
        val btnExit = findViewById<Button>(R.id.btnExit)

        //set on click listener on the buttons
        btnStart.setOnClickListener {
            val intent = Intent(this, PlayList::class.java)
            startActivity(intent)
        }
        btnGo.setOnClickListener{
            val intent = Intent(this, PlayList::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener{
            finishAffinity()
        }
    }
}
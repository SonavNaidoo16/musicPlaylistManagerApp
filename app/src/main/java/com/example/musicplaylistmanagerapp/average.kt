package com.example.musicplaylistmanagerapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class average : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_average2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        val btnClose = findViewById<Button>(R.id.btnClose)
        val tvAverageAns = findViewById<TextView>(R.id.tvAverageAns)

        val score = intent.getIntExtra("Rating", 0)
        tvAverageAns.text = "$score / Rating"
        //set on click listener on buttons
        btnClose.setOnClickListener {
            finishAffinity()
        }
    }
}
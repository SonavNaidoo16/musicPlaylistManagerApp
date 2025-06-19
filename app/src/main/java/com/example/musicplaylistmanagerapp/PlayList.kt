package com.example.musicplaylistmanagerapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PlayList : AppCompatActivity() {

    private val titles = ArrayList<String>()
    private val artists = ArrayList<String>()
    private val ratings = ArrayList<Int>()
    private val comments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_list)

        //code starts here
        val songInput = findViewById<EditText>(R.id.etSong)
        val artistInput = findViewById<EditText>(R.id.etArtist)
        val commentInput = findViewById<EditText>(R.id.etComment)
        val ratingBar = findViewById<RatingBar>(R.id.rbRating)
        val btnSave = findViewById<Button>(R.id.btnShowList)
        val btnBack = findViewById<Button>(R.id.btnMenu)
        val btnShowList = findViewById<Button>(R.id.btnShowList)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val tvDetails = findViewById<TextView>(R.id.tvDetails)
        val btnNextPage = findViewById<Button>(R.id.btnListPage)

        //set on click listener on the buttons
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnNextPage.setOnClickListener {
            val intent = Intent(this, average::class.java)
            startActivity(intent)
        }
        btnSave.setOnClickListener {
            val song = songInput.text.toString()
            val artist = artistInput.text.toString()
            val comment = commentInput.text.toString()
            val rating = ratingBar.rating.toInt()

            if (song.isNotEmpty() && artist.isNotEmpty() && comment.isNotEmpty() && rating in 1..5) {
                titles.add(song)
                artists.add(artist)
                ratings.add(rating)
                comments.add(comment)

                Toast.makeText(this, "the song is saved", Toast.LENGTH_SHORT).show()
                songInput.text.clear()
                artistInput.text.clear()
                commentInput.text.clear()
                ratingBar.rating = 0f
            } else {
                Toast.makeText(this, "Please fill in full!", Toast.LENGTH_SHORT).show()
            }
        }

        btnShowList.setOnClickListener {
            val builder = StringBuilder()
            for (i in titles.indices) {
                builder.append("Song: ${titles[i]}\n")
                builder.append("Artist: ${artists[i]}\n")
                builder.append("Rating: ${ratings[i]}\n")
                builder.append("Comment: ${comments[i]}\n\n")
            }
            tvDetails.text = builder.toString()
        }

        btnAverage.setOnClickListener {
            if (ratings.isNotEmpty()) {
                val avg = ratings.sum().toFloat() / ratings.size
                tvDetails.text = "Average Rating: %.2f".format(avg)
                val intent = Intent(this, average::class.java)
                    .putExtra("score",4)
                startActivity(intent)
            } else {
                tvDetails.text = "No songs ratings found."
            }
        }
        btnSave.setOnClickListener {
            val song = songInput.text.toString()
            val artist = artistInput.text.toString()
            val comment = commentInput.text.toString()
            val rating = ratingBar.rating.toInt()

            if (titles.size >= 4) {
                Toast.makeText(this, "Only 4 songs in a playlist.", Toast.LENGTH_SHORT).show()
            } else if (song.isNotEmpty() && artist.isNotEmpty() && comment.isNotEmpty() && rating in 1..5) {
                titles.add(song)
                artists.add(artist)
                ratings.add(rating)
                comments.add(comment)

                Toast.makeText(this, "The song is saved", Toast.LENGTH_SHORT).show()
                songInput.text.clear()
                artistInput.text.clear()
                commentInput.text.clear()
                ratingBar.rating = 0f
            } else {
                Toast.makeText(this, "Please fill in all information above", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}
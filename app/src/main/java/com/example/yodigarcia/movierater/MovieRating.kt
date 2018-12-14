package com.example.yodigarcia.movierater

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.movie_rating.*

class MovieRating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_rating)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rating_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.submitRate){

            val intent = Intent(this, MovieDetail::class.java)
            intent.putExtra("rating", movieRating.rating)
            intent.putExtra("review", movieReview.text.toString())

            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
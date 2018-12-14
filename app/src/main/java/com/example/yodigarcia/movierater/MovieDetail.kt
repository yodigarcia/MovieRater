package com.example.yodigarcia.movierater

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.movie_detail.*

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        registerForContextMenu(movReview)

        val movValue = MovieEntity(intent.getStringExtra("title"),intent.getStringExtra("desc"),intent.getStringExtra("language"),intent.getStringExtra("release"), intent.getStringExtra("audience"))

        movTitle.text = movValue.movTitle
        movDescription.text = movValue.movDesc
        movLang.text = movValue.movLang
        movDate.text = movValue.relDate
        movAudience.text = movValue.movAud

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {

        if (v?.id == R.id.movReview) {
            menu?.add(1, 1001, 1, "Add Review")
        }

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1001) {
            val intent = Intent(this, MovieRating::class.java)
            startActivityForResult(intent, 300)
        }

        return super.onContextItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 300){
            if(resultCode == Activity.RESULT_OK){

                val getRating = data!!.getFloatExtra("rating", -0.1f)
                val getReview = data.getStringExtra("review")

                if (getRating != -0.1f) {
                    movRating.visibility = View.VISIBLE
                    movRating.rating = getRating
                    movReview.setText(getReview)
                }
                else {
                    println("Error")
                }
            }
        }
    }
}
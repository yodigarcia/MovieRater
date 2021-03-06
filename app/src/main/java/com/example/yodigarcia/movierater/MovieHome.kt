package com.example.yodigarcia.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.movie_home.*

class MovieHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_home)

        audienceCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                checkbox.visibility = View.VISIBLE
            else
                checkbox.visibility = View.INVISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.addMenu) {
            val editTitle: String? = movieTitle.text.toString()
            val editDesc: String? = movieDesc.text.toString()
            val editRelDate: String? = releaseDate.text.toString()
            val radio: RadioButton = findViewById(language.checkedRadioButtonId)

            if (editTitle == ""){
                movieTitle.setError("Field empty")
            }

            if (editDesc == ""){
                movieDesc.setError("Field empty")
            }

            if (editRelDate == ""){
                releaseDate.setError("Field empty")
            }

            if (editTitle != "" && editDesc != "" && editRelDate != "" ) {
                val intent = Intent(this, MovieDetail::class.java)

                intent.putExtra("title", movieTitle.text.toString())
                intent.putExtra("desc", movieDesc.text.toString())
                intent.putExtra("language", "${radio.text}")
                intent.putExtra("release", releaseDate.text.toString())
                if (audienceCheck.isChecked == true) {
                    intent.putExtra("audience", "No")

                    if (violenceChk.isChecked == true)
                        intent.putExtra("audience", "No (Violence)")
//
                    if (languageChk.isChecked == true)
                        intent.putExtra("audience", "No (Language)")
//
                }
                else {
                    intent.putExtra("audience", "Yes")
                }
                startActivity(intent)
            }
        }

        if (item?.itemId == R.id.clearMenu) {
            movieTitle.setText("")
            movieDesc.setText("")
            releaseDate.setText("")
            language.check(R.id.english)
            audienceCheck.isChecked = false
        }
        return super.onOptionsItemSelected(item)
    }
}

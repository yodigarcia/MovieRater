package com.example.yodigarcia.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.movie_home.*

class MovieHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_home)

//        var movDesc: String = "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life"

        audienceCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                checkbox.visibility = View.VISIBLE
            else
                checkbox.visibility = View.INVISIBLE
        }
//            var movieDetail = MovieEntity("Venom", movDesc, "English", "03-10-2018", "Yes")
    }

    fun btnValidate(v: View) {
        val editTitle: String? = movieTitle.text.toString()
        val editDesc: String? = movieDesc.text.toString()
        val editRelDate: String? = releaseDate.text.toString()
        val radio: RadioButton = findViewById(language.checkedRadioButtonId)
        val toastText: String = "Title = " + movieTitle.text.toString() +
                "\n Overview = " + movieDesc.text.toString() +
                "\n Release date = " + releaseDate.text.toString() +
                "\n Language = ${radio.text}" +
                "\n Suitable for all ages = " + audienceCheck.isChecked
        var toastText2: String = toastText + "\n Reason:"

        if (violenceChk.isChecked == true)
            toastText2 += "\n" + violenceChk.text.toString()

        if (languageChk.isChecked == true)
            toastText2 += "\n" + languageChk.text.toString()

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
            if (audienceCheck.isChecked == false)
                Toast.makeText(this@MovieHome, toastText, Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this@MovieHome, toastText2, Toast.LENGTH_LONG).show()
        }
    }
}

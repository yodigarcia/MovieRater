package com.example.yodigarcia.movierater

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.movie_detail.*

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        var movDesc: String = "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life"
        var movieDetail = MovieEntity("Venom", movDesc, "English", "03-10-2018", "Yes")

        movTitle.text = movieDetail.movTitle
        movDescription.text = movieDetail.movDesc
        movLang.text = movieDetail.movLang
        movDate.text = movieDetail.relDate
        movAudience.text = movieDetail.movAud

    }
}
package com.example.yodigarcia.movierater

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.movie_landing.*

class MovieLanding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_landing)

        registerForContextMenu(addLanding)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if(v?.id == R.id.addLanding)
            menu?.add(1,2001,1,"Add")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == 2001) {
            val intent: Intent? = Intent(this, MovieHome::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }
}
package com.example.recipefood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profilePhoto: ImageView = findViewById(R.id.profilePhoto)

        Glide.with(this)
            .load(R.drawable.merah)
            .into(profilePhoto)

        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setHomeButtonEnabled(true)
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
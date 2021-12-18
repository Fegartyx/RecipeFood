package com.example.recipefood

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val FOOD_NAME = "food_name"
        const val FOOD_PHOTO = "food_photo"
        const val FOOD_LANGKAH = "food_langkah"
        const val FOOD_BAHAN = "food_bahan"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val foodPhoto: ImageView = findViewById(R.id.imgFood)
        val foodLangkah: TextView = findViewById(R.id.txtLangkah)
        val foodBahan: TextView = findViewById(R.id.txtBahan)

        foodLangkah.text = intent.getStringExtra(FOOD_LANGKAH)
        foodBahan.text = intent.getStringExtra(FOOD_BAHAN)
        Log.d("Detail", "onCreate: " + FOOD_PHOTO)

        Glide.with(this)
            .load(intent.getIntExtra(FOOD_PHOTO,0))
            .into(foodPhoto)

        val actionbar = supportActionBar
        if (actionbar != null){
            actionbar.title = intent.getStringExtra(FOOD_NAME)
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
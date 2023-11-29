package com.example.practicalandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PracticalExplicit : AppCompatActivity() {
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_explicit)

        val button: Button = findViewById(R.id.mainpage)
        editText= findViewById(R.id.textLink)
        val clickme: Button = findViewById(R.id.click)


        button.setOnClickListener {
            homeScreen()
        }

        clickme.setOnClickListener{
            search()
        }
    }
    fun search() {
        val url = editText.text.toString()
        val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(urlIntent)
    }
    fun homeScreen() {
        val i = Intent(applicationContext, MainActivity::class.java)
        startActivity(i)
    }
}
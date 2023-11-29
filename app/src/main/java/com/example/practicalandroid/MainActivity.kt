package com.example.practicalandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var salary: EditText
    private lateinit var designation: EditText

    private lateinit var saveButton: Button

    // Name of the SharedPreferences file
    private val PREFS_FILENAME = "my_prefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.nextpage)
        saveButton = findViewById(R.id.savedata)
        name = findViewById(R.id.name)
        salary = findViewById(R.id.salay)
        designation = findViewById(R.id.designation)

        // recyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val students = listOf(
            Student("John Doe", R.drawable.ic_launcher_background),
            Student("Jane Smith", R.drawable.ic_launcher_background),
            // Add more students as needed
        )

        val adapter = StudentAdapter(students)
        recyclerView.adapter = adapter

        // recyclerView

        button.setOnClickListener {
            newsScreen()
        }

        // Load data from SharedPreferences when the app starts
        loadData()

        saveButton.setOnClickListener {
            // Save data to SharedPreferences when the button is clicked
            saveData()
        }
    }

    override fun onResume() {
        super.onResume()
        // Load data from SharedPreferences when the activity is resumed
        loadData()
    }

    private fun saveData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        // Save the text from EditText with a key "textKey"
        editor.putString("name", name.text.toString())
        editor.putString("salary", salary.text.toString())
        editor.putString("designation", designation.text.toString())
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

        // Retrieve the text saved with the key "textKey", default value is an empty string
        val s1 = sharedPreferences.getString("name", "") ?: ""
        val s2 = sharedPreferences.getString("salary", "") ?: ""
        val s3 = sharedPreferences.getString("designation", "") ?: ""

        name.setText(s1)
        salary.setText(s2)
        designation.setText(s3)
    }

    fun newsScreen() {
        val i = Intent(applicationContext, PracticalExplicit::class.java)
        startActivity(i)
    }
}
package com.wik4apps.bookadvisordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.File.separator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn  = findViewById<Button>(R.id.button)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val tv = findViewById<TextView>(R.id.tv_books_by_topic)
        btn.setOnClickListener {
            val books = FindBooksByTopic(spinner.selectedItem.toString())
            tv.text = books.map( { it+"\n" }).joinToString(separator = "")
            Toast.makeText(this, spinner.selectedItem.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun FindBooksByTopic(topic : String): List<String> {
        val topics = resources.getStringArray(R.array.book_topics)
        return when (topic) {
            topics[0] -> listOf("Network 1", "Network 2")
            topics[1] -> listOf("Mobile 1", "Mobile 2")
            topics[2] -> listOf("Web 1", "Web 2")
            else -> listOf("No books found")
        }
    }

}


package com.example.event

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.markas_commerce)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.markas)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonBack = findViewById<Button>(R.id.btn_beli)
        val intent = Intent(this, DetailActivity::class.java)

//        buttonBack.setOnClickListener {
//            startActivity(intent)
//        }

        val buttonBackk = findViewById<Button>(R.id.btn_beli2)

        buttonBackk.setOnClickListener {
            startActivity(intent)
        }


    }
}
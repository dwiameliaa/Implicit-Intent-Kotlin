package com.example.event

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        Log.i("CobaLifecycle","Lifecycle Oncreate")

        val buttonDetail = findViewById<Button>(R.id.btn_detail)
        buttonDetail.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }
//        Log.i("cobaLog","Coba Log Info")
//        Log.d("cobaLog","Coba Log Debug")
//        Log.v("cobalog", "Coba Log Verbose")
//        Log.w("cobalog","Coba Log Warning")
//        Log.e("cobalog","Coba Log Error")
//        Log.wtf("cobalog","Coba Log wtf")


    }

    override fun onStart() {
        super.onStart()
        Log.i("CobaLifecycle","Lifecycle OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CobaLifecycle","Lifecycle OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CobaLifecycle","Lifecycle OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CobaLifecycle","Lifecycle OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CobaLifecycle","Lifecycle OnDestroy")
    }

}
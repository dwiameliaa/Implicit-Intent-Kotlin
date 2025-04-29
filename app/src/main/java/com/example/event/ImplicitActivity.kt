package com.example.event

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit)

        // membuka telepon
        val buttonTelepon = findViewById<Button>(R.id.btn_telepon)
        val buttonMapsApp = findViewById<Button>(R.id.btn_maps_app)

        buttonTelepon.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:083812345678")
            startActivity(intent)
        }

        val latitude = -7.3144002
        val longitude = 112.7495082

        val buttonMapsUrl = findViewById<Button>(R.id.btn_maps_url)

        buttonMapsUrl.setOnClickListener {
            val url = "https://www.google.com/maps/search/?api=1&query=$latitude,$longitude"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }


        // membuka google
        val btnGoogle = findViewById<Button>(R.id.btn_google)

        btnGoogle.setOnClickListener {
            val intent =
                packageManager.getLaunchIntentForPackage("com.google.android.googlequicksearchbox")
            if (intent != null) {
                startActivity(intent)
            } else {
                // Jika aplikasi Google tidak terpasang, buka URL di browser
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                startActivity(webIntent)
            }
        }

        // membuka kamera
        val btnKamera = findViewById<Button>(R.id.btn_kamera)

        btnKamera.setOnClickListener {
            // Membuat intent untuk membuka kamera
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.setPackage("com.android.camera")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Aplikasi tidak terinstall", Toast.LENGTH_LONG).show()
            }
        }


        // membuka peta/google maps

        buttonMapsApp.setOnClickListener {
            val uri = Uri.parse("geo:$latitude,$longitude?p=$latitude,$longitude")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Aplikasi tidak terinstall", Toast.LENGTH_LONG).show()
            }
        }


        // membuka whatsapp
        val etPhone = findViewById<EditText>(R.id.et_phone)
        val btnWA = findViewById<Button>(R.id.btn_whatsapp)
        val etPesan = findViewById<EditText>(R.id.et_pesan)

        btnWA.setOnClickListener {
            val phoneNumber = etPhone.text.toString()
            val message = etPesan.text.toString()

            if (phoneNumber.isNotEmpty() && message.isNotEmpty()) {
                // Membuka WhatsApp dengan pesan
                val uri = "https://wa.me/$phoneNumber?text=${Uri.encode(message)}"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                startActivity(intent)
            } else {
                // Menampilkan Toast jika nomor atau pesan kosong
                Toast.makeText(this, "Nomor atau pesan tidak boleh kosong", Toast.LENGTH_SHORT)
                    .show()
            }
        }

//        btnWA.setOnClickListener {
//            val number = etPhone.text.toString()
//            Toast.makeText(this, number, Toast.LENGTH_SHORT).show()
//        }

    }
}
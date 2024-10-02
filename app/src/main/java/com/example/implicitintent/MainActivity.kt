package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.implicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // enable viewBinding
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.R, version = 2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // open browser
        binding.openBrowser.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/"))
            startActivity(intent)
        }

        // open camera
        binding.openCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        // open phone call
        binding.openPhonecall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+1234567890")
            startActivity(intent)
        }

        // share text
        binding.textShareButton.setOnClickListener {

            val editText:String = binding.editText.toString()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type ="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,editText)
            startActivity(Intent.createChooser(intent,"Share Via"))

        }
    }
}





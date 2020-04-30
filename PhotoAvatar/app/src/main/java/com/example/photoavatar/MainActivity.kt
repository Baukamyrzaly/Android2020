package com.example.photoavatar

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var buttonProf: Button
    private lateinit var buttonMain: Button
    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonMain = findViewById(R.id.button2)
        buttonProf = findViewById(R.id.button1)

        buttonProf.setOnClickListener{
            fragment = ProfileFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frame_con,fragment).commit()
        }

        buttonMain.setOnClickListener{
            fragment = MainFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frame_con,fragment).commit()
        }
    }
}

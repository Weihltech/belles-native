package com.well.belles

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.well.belles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nativeInfo = NativeBellesInfo()
        val nativeNormal = NativeBellesNormal()

        binding.sampleText.text =
            "${nativeInfo.stringFromJNI()}\n${nativeNormal.stringFromJNI()}"
    }

}
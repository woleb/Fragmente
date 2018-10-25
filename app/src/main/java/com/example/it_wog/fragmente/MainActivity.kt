package com.example.it_wog.fragmente

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //Fragment Manager
    val mManager = supportFragmentManager
    val mFragment = ErstesFragment()

    val mTransaction = mManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("TEST", "onCreate")

        val fragmentButton = findViewById<Button>(R.id.fragmentBtn)
        fragmentButton.setOnClickListener {

            mTransaction.replace(R.id.fragmentPlatz, mFragment)
            mTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("TEST", "onStart")
    }
}

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
    val mFragment2 = ZweitesFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("TEST", "onCreate")

        //Button für erstes Fragment
        val fragmentButton = findViewById<Button>(R.id.fragmentBtn)
        fragmentButton.setOnClickListener {
            val mTransaction = mManager.beginTransaction()
            mTransaction.replace(R.id.fragmentPlatz, mFragment)
            mTransaction.addToBackStack(null)
            mTransaction.commit()
            //Log.i("TEST", "mFragment")
        }
        //Button für zweites Fragment
        val fragmentButton2 = findViewById<Button>(R.id.fragment2Btn)
        fragmentButton2.setOnClickListener {
            val mTransaction = mManager.beginTransaction()
            mTransaction.replace(R.id.fragmentPlatz, mFragment2)
            mTransaction.addToBackStack(null)
            mTransaction.commit()
            //Log.i("TEST", "mFragment2")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("TEST", "onStart")
    }
}

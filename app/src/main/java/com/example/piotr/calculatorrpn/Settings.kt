package com.example.piotr.calculatorrpn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_settings.*

class Settings : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)



        buttonAccept.setOnClickListener{
            //odebranie stosu i odeslanie spowrotem do main
            val intent = Intent(this,MainActivity::class.java)
            var stos=getIntent().getSerializableExtra("stosSave") as Stack
            intent.putExtra("stosReceive", stos)

            intent.putExtra("color", "cyan")
            startActivity(intent)
        }
    }


}

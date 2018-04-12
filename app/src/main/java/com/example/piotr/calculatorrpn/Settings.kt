package com.example.piotr.calculatorrpn

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_settings.*
import android.widget.RadioButton
import android.widget.RadioGroup




class Settings : AppCompatActivity() {

    var precision: Int=0
    var colorBackgroundStack: String = "#faf7e5"
    var colorBackgroundLayout : String = ""


    lateinit var editPrec : EditText
    lateinit var option: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        ScreenSet.setBackgroundColor(Color.parseColor("grey"))

        editPrec= findViewById(R.id.editPrec)



        option = findViewById(R.id.spinner1)
        val colors = arrayOf("Pomarańczowy", "Szary", "Pudrowy róż", "Zielony", "Błękitny")
        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, colors)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                when (position.toInt()) {
                    0 -> {
                        colorBackgroundLayout="#ff7f00"
                    }
                    1 -> {colorBackgroundLayout="#9c9c9c"
                    }
                    2 -> {colorBackgroundLayout="#f5ccb0"
                    }
                    3 -> {colorBackgroundLayout="#66ff66"
                    }
                    4 -> {colorBackgroundLayout="#00ccff"
                    }
                }
            }
        }

        buttonAccept.setOnClickListener{
            //odebranie stosu i odeslanie spowrotem do main
            val intent = Intent(this,MainActivity::class.java)
           var stos=getIntent().getSerializableExtra("stosSave") as Stack
            intent.putExtra("stosReceive", stos)
            //kolor tla
            //precyzja
            if (!editPrec.getText().toString().equals(""))
            precision =editPrec.getText().toString().toInt()
            else precision = 2
            intent.putExtra("precision", precision)
            //color stosu
            intent.putExtra("backColor" ,colorBackgroundLayout )
            intent.putExtra("stackColor" ,colorBackgroundStack )
            intent.putExtra("back", 1)
            //start main activity
            startActivity(intent)
        }

        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.orientation = RadioGroup.VERTICAL
        radioGroup.check(radioButton4.getId());

        radioGroup.setOnCheckedChangeListener({
            radioGroup, checkedId ->  val radioButton= findViewById<RadioButton>(checkedId)
            when(radioButton.text.toString()){
             "Fioletowy" ->{  colorBackgroundStack="#8080ff"}
                "Morski" ->{colorBackgroundStack="#00ffff"}
                "Koralowy"-> {colorBackgroundStack="#ff7f50"}
                "Wrzosowy" -> {colorBackgroundStack="#faf7e5"}

            }

        })





    }


}

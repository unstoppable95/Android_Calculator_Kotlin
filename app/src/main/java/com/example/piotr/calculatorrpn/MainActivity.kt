package com.example.piotr.calculatorrpn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.Toast
import java.util.function.DoubleBinaryOperator


class MainActivity : AppCompatActivity() {

    var stack = Stack()
    var tmp : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readButtons()
    }
    fun readButtons(){
        buttonZero.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 0" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,0)
        }

        buttonOne.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 1" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,1)
        }

        buttonTwo.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 2" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,2)
        }
        buttonThree.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 3" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,3)
        }
        buttonFour.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 4" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,4)
        }
        buttonFive.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 5" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,5)
        }
        buttonSix.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 6" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,6)
        }
        buttonSeven.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 7" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,7)
        }
        buttonEight.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 8" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,8)
        }
        buttonNine.setOnClickListener{

            Toast.makeText(getApplicationContext(),"Kliknalem 9" ,Toast.LENGTH_LONG ).show();
            tmp=makeNumberForStack(tmp,9)
        }
        buttonEnter.setOnClickListener(){
            stack.list.add(tmp)
            val x = stack.list.get(stack.list.size-1)
            Toast.makeText(getApplicationContext(),"$x" ,Toast.LENGTH_LONG ).show();
        }


    }

    fun makeNumberForStack(a:Double, b:Int): Double{

        val aPom = a.toInt()
        val aStr= aPom.toString()
        val sumStr = aStr+b.toString()
        val result = sumStr.toDouble()
        Toast.makeText(getApplicationContext(),"$result" ,Toast.LENGTH_LONG ).show();
        return result

    }


}

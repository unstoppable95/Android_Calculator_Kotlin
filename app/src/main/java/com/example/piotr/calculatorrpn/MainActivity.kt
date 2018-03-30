package com.example.piotr.calculatorrpn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.Toast
import java.util.function.DoubleBinaryOperator


class MainActivity : AppCompatActivity() {

    var stack = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonsClick()
    }
    fun buttonsClick(){
        buttonZero.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 0" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("0")
        }

        buttonOne.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 1" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("1")
        }

        buttonTwo.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 2" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("2")
        }
        buttonThree.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 3" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("3")
        }
        buttonFour.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 4" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("4")
        }
        buttonFive.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 5" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("5")
        }
        buttonSix.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 6" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("6")
        }
        buttonSeven.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 7" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("7")
        }
        buttonEight.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 8" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("8")
        }
        buttonNine.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem 9" ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add("9")
        }
        buttonDot.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Kliknalem ." ,Toast.LENGTH_LONG ).show();
            stack.listTmp.add(".")
        }
        buttonEnter.setOnClickListener(){
            var y  = stack.listTmp.joinToString(separator = "")
            stack.list.add(y.toDouble())
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
            stack.listTmp.clear()
        }
       buttonPlus.setOnClickListener(){
           stack.addiction(stack)
           Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
       }
        buttonMinus.setOnClickListener(){
            stack.subtraction(stack)
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
        }

        buttonMultiply.setOnClickListener(){
            stack.multiplication(stack)
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
        }
        buttonDivision.setOnClickListener(){
            stack.division(stack)
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
        }
        buttonSqrt.setOnClickListener(){
            stack.sqrt(stack)
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
        }
        buttonPow.setOnClickListener(){
            stack.pow(stack)
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
        }
        buttonAC.setOnClickListener(){
            stack.list.clear()
            stack.listTmp.clear()
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
        }
        buttonDrop.setOnClickListener(){
            stack.drop(stack)
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
        }
        buttonSwap.setOnClickListener(){
            stack.swap(stack)
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
        }
        buttonPlusMinus.setOnClickListener(){
            stack.plusMinus(stack)
            Toast.makeText(getApplicationContext(), "stos " + stack.list ,Toast.LENGTH_LONG ).show();
        }




    }





}

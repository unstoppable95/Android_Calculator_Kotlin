package com.example.piotr.calculatorrpn

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.function.DoubleBinaryOperator
import android.widget.RelativeLayout
import android.graphics.Color.parseColor
import android.app.Activity
import android.util.Log


class MainActivity : AppCompatActivity() {

    var stack = Stack()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Screen.setBackgroundColor(android.graphics.Color.YELLOW)

        //wysylane przez settings
        val bundle=intent.extras
        var samplename:String
        if(bundle!=null)
        {
            samplename = bundle.getString("color")

            Screen.setBackgroundColor(Color.parseColor(samplename))

            //powrot z aktywnosci setting
            stack =getIntent().getSerializableExtra("stosReceive") as Stack
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
            textView.text=stack.listTmp.joinToString(separator = "")

        }

        //obsluga guzikow
        buttonsClick()

    }
    fun buttonsClick(){
        buttonZero.setOnClickListener{
            stack.listTmp.add("0")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonOne.setOnClickListener{
            stack.listTmp.add("1")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonTwo.setOnClickListener{
            stack.listTmp.add("2")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonThree.setOnClickListener{
            stack.listTmp.add("3")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonFour.setOnClickListener{
            stack.listTmp.add("4")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonFive.setOnClickListener{
            stack.listTmp.add("5")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonSix.setOnClickListener{
            stack.listTmp.add("6")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonSeven.setOnClickListener{
            stack.listTmp.add("7")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonEight.setOnClickListener{
            stack.listTmp.add("8")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonNine.setOnClickListener{
            stack.listTmp.add("9")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonDot.setOnClickListener{
            stack.listTmp.add(".")
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonEnter.setOnClickListener(){
            if(stack.listTmp.size==0 && stack.list.lastIndex>=0 ){
                stack.list.add(stack.list.get(stack.list.lastIndex))
                val listView = findViewById<ListView>(R.id.listView)
                listView.adapter = MyCustomAdapter(this, stack.list)
                textView.text=stack.listTmp.joinToString(separator = "")
            }
            else if (stack.listTmp.size!=0  ){
                var y  = stack.listTmp.joinToString(separator = "")
                stack.list.add(y.toDouble())
                stack.listTmp.clear()
                val listView = findViewById<ListView>(R.id.listView)
                listView.adapter = MyCustomAdapter(this, stack.list)
                textView.text=stack.listTmp.joinToString(separator = "")
            }
        }
       buttonPlus.setOnClickListener(){
           val listHelp = stack.list.clone() as ArrayList<Double>
           stack.History.add(listHelp)
           if(stack.list.lastIndex>=1)
           stack.addiction(stack)
           val listView = findViewById<ListView>(R.id.listView)
           listView.adapter = MyCustomAdapter(this, stack.list)
       }
        buttonMinus.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.subtraction(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
        }
        buttonMultiply.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.multiplication(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
        }
        buttonDivision.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.division(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
        }
        buttonSqrt.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=0)
            stack.sqrt(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
        }
        buttonPow.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.pow(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
        }
        buttonAC.setOnClickListener(){
            stack.list.clear()
            stack.listTmp.clear()
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonDrop.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=0)
            stack.drop(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
        }
        buttonSwap.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.swap(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
        }
        buttonPlusMinus.setOnClickListener(){
            val listHelp = stack.list.clone()  as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=0)
            stack.plusMinus(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
        }
        buttonDel.setOnClickListener(){
            if(stack.listTmp.lastIndex>=0)
            stack.listTmp.removeAt(stack.listTmp.lastIndex)
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonUndo.setOnClickListener(){
            stack.list.clear()
            if(stack.History.lastIndex>=1){
                stack.list.addAll(stack.History.get(stack.History.lastIndex))
            stack.History.removeAt(stack.History.lastIndex)}
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list)
        }
        buttonMenu.setOnClickListener(){
            val intent = Intent(this,Settings::class.java)
            intent.putExtra("stosSave", stack)
            startActivity(intent)
        }




    }

    private class MyCustomAdapter(context: Context, list: ArrayList<Double>): BaseAdapter() {

        private val nContext: Context
        private val nlist: ArrayList<Double>
        init{
            nContext = context
            nlist = list

        }
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val textView = TextView(nContext)
            textView.text = "$position: ${nlist.get(position)}"
            return textView
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            //return 5
            return nlist.size

        }
    }



}


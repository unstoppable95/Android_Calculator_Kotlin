package com.example.piotr.calculatorrpn

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Process.myPid
import android.os.Process.killProcess





class MainActivity : AppCompatActivity() {

    var stack = Stack()
    var prec :Int = 2
    var backgroundLayoutColor: String ="#faf7e5"
    var backgroundStackColor : String = "#faf7a3"
    var backFromSett : Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //wysylane przez settings
        var bundle=intent.extras


        backFromSett = getIntent().getIntExtra("back",0)

        if(backFromSett==1)
        {   //powrot z aktywnosci setting
            prec = bundle.getInt("precision")
            backgroundLayoutColor= bundle.getString("backColor")
            stack =getIntent().getSerializableExtra("stosReceive") as Stack
            Screen.setBackgroundColor(Color.parseColor(backgroundLayoutColor))
           backgroundStackColor= bundle.getString("stackColor")
           val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
            listView.setBackgroundColor(Color.parseColor(backgroundStackColor))
            textView.text=stack.listTmp.joinToString(separator = "")
        }

        buttonsClick()


    }

    override  public fun onDestroy() {
        super.onDestroy()


    }


     override public fun onPause() {
        super.onPause()
    }


     override public fun onSaveInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState!!.putSerializable("Stos save", stack)
        super.onSaveInstanceState(savedInstanceState)
    }

     override public fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        stack = savedInstanceState!!.getSerializable("Stos save") as Stack
        textView.text=stack.listTmp.joinToString(separator = "")
        listView.adapter = MyCustomAdapter(this, stack.list,prec)
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
                listView.adapter = MyCustomAdapter(this, stack.list,prec)
                textView.text=stack.listTmp.joinToString(separator = "")
            }
            else if (stack.listTmp.size!=0  ){
                var y  = stack.listTmp.joinToString(separator = "")
                stack.list.add(y.toDouble())
                stack.listTmp.clear()
                val listView = findViewById<ListView>(R.id.listView)
                listView.adapter = MyCustomAdapter(this, stack.list,prec)
                textView.text=stack.listTmp.joinToString(separator = "")
            }
        }
       buttonPlus.setOnClickListener(){
           val listHelp = stack.list.clone() as ArrayList<Double>
           stack.History.add(listHelp)
           if(stack.list.lastIndex>=1)
           stack.addiction(stack)
           val listView = findViewById<ListView>(R.id.listView)
           listView.adapter = MyCustomAdapter(this, stack.list,prec)
       }
        buttonMinus.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.subtraction(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
        }
        buttonMultiply.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.multiplication(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
        }
        buttonDivision.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.division(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
        }
        buttonSqrt.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=0)
            stack.sqrt(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
        }
        buttonPow.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.pow(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
        }
        buttonAC.setOnClickListener(){
            stack.list.clear()
            stack.listTmp.clear()
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonDrop.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=0)
            stack.drop(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
        }
        buttonSwap.setOnClickListener(){
            val listHelp = stack.list.clone() as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=1)
            stack.swap(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
        }
        buttonPlusMinus.setOnClickListener(){
            val listHelp = stack.list.clone()  as ArrayList<Double>
            stack.History.add(listHelp)
            if(stack.list.lastIndex>=0)
            stack.plusMinus(stack)
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
        }
        buttonDel.setOnClickListener(){
            if(stack.listTmp.lastIndex>=0)
            stack.listTmp.removeAt(stack.listTmp.lastIndex)
            textView.text=stack.listTmp.joinToString(separator = "")
        }
        buttonUndo.setOnClickListener(){


            if(stack.History.lastIndex>=0){
                stack.list.clear()
                stack.list.addAll(stack.History.get(stack.History.lastIndex))
            stack.History.removeAt(stack.History.lastIndex)}
            val listView = findViewById<ListView>(R.id.listView)
            listView.adapter = MyCustomAdapter(this, stack.list,prec)
        }
        buttonMenu.setOnClickListener(){
            val intent = Intent(this,Settings::class.java)
            intent.putExtra("stosSave", stack)
            startActivity(intent)
        }




    }

    private class MyCustomAdapter(context: Context, list: ArrayList<Double>, prec: Int): BaseAdapter() {

        private val nContext: Context
        private val nlist: ArrayList<Double>
        private val precNum :Int

        init{
            nContext = context

            if ( list.size<=4) nlist = list
            else {
                var listpom= ArrayList<Double>()
                for (i in 3 downTo 0 step 1) {
                    listpom.add(list.get(list.lastIndex-i))

                }

                nlist=listpom
            }
            precNum = prec

        }
        fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val textView = TextView(nContext)
            val x = nlist.get(position)
            val y = x.format(precNum)

            textView.text = "$position: ${y}"

            return textView
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
           if (nlist.size <=4) return nlist.size
            else {
                return 4
           }
        }
    }



}


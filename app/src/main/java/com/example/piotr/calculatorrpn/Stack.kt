package com.example.piotr.calculatorrpn

import java.io.Serializable


class Stack : Serializable {

    var list = ArrayList<Double>()
    var listTmp = ArrayList<String>()
    var History = ArrayList<ArrayList<Double>>()

    fun addiction( stack : Stack){
        val a = stack.list.get(stack.list.lastIndex)
        val b = stack.list.get(stack.list.lastIndex-1)
        val result = a+b
        stack.list.removeAt(stack.list.lastIndex-1)
        stack.list.removeAt(stack.list.lastIndex)
        stack.list.add(result)

    }
    fun subtraction( stack : Stack){
        val a = stack.list.get(stack.list.lastIndex)
        val b = stack.list.get(stack.list.lastIndex-1)
        val result = a-b
        stack.list.removeAt(stack.list.lastIndex-1)
        stack.list.removeAt(stack.list.lastIndex)
        stack.list.add(result)
    }
    fun multiplication( stack : Stack){
        val a = stack.list.get(stack.list.lastIndex)
        val b = stack.list.get(stack.list.lastIndex-1)
        val result = a*b
        stack.list.removeAt(stack.list.lastIndex-1)
        stack.list.removeAt(stack.list.lastIndex)
        stack.list.add(result)
    }
    fun division( stack : Stack){
        val a = stack.list.get(stack.list.lastIndex)
        val b = stack.list.get(stack.list.lastIndex-1)
        val result = a/b
        stack.list.removeAt(stack.list.lastIndex-1)
        stack.list.removeAt(stack.list.lastIndex)
        stack.list.add(result)
    }
    fun sqrt(stack : Stack){
        val a = stack.list.get(stack.list.lastIndex)
        val result = Math.sqrt(a)
        stack.list.removeAt(stack.list.lastIndex)
        stack.list.add(result)
    }
    fun pow(stack:Stack) {
        val a = stack.list.get(stack.list.lastIndex) //potega
        val b = stack.list.get(stack.list.lastIndex - 1)
        val result = Math.pow(b, a)
        stack.list.removeAt(stack.list.lastIndex - 1)
        stack.list.removeAt(stack.list.lastIndex)
        stack.list.add(result)
    }
    fun drop (stack:Stack){
        stack.list.removeAt(stack.list.lastIndex)
    }
    fun swap(stack:Stack){
        val a = stack.list.get(stack.list.lastIndex) //potega
        val b = stack.list.get(stack.list.lastIndex - 1)
        stack.list.set(stack.list.lastIndex - 1,a)
        stack.list.set(stack.list.lastIndex ,b)
    }
    fun plusMinus(stack:Stack){
        val a = -(stack.list.get(stack.list.lastIndex) )
        stack.list.set(stack.list.lastIndex,a)
    }

}
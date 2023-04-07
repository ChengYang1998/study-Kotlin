package com.android.studykotlin

import kotlin.math.max

/**
 *    author : cy
 *    time   : 2023/3/31
 *    desc   :
 */
fun main() {
    println("Hello Kotlin ")
    println(max(213, 123))
}

fun largerNumber(num1: Int, num2: Int): Int {
    return max(num1, num2)
}

//语法糖
fun largerNumber2(num1: Int, num2: Int) = max(num1, num2)


fun getScore(name: String) = when (name) {
    "Tom" -> 86
    "Jim" -> 77
    "Jack" -> 95
    "Lily" -> 100
    else -> 0
}












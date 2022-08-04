package org.nuna

import java.util.Stack

interface Value {
    val stack: Stack<Int>

    val string: String

    fun getResultByStack(): Stack<Int>

    fun getResultByString(): String
}
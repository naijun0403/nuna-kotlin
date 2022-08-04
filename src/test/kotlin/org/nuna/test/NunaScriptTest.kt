/*
 * MIT License
 *
 * Copyright (c) 2022 naijun0403
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.nuna.test

import org.nuna.NunaContext
import org.nuna.Value
import java.util.*
import kotlin.properties.Delegates
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class NunaScriptTest {

    private var context: NunaContext by Delegates.notNull()

    @BeforeTest
    fun before() {
        context = NunaContext.create()
    }

    @Test
    fun exampleNunNu() {
        val res: Value = context.exec("""
            눈
            누..
        """.trimIndent())

        assertTrue {
            res.stack.toString() == "[1, 2]"
        }
    }

    @Test
    fun exampleNanNa() {
        val stack = Stack<Int>()
        stack.push(1)

        context.setStack(stack)

        val res = context.exec("""
            나...
            누난....
            누나...으
        """.trimIndent())

        assertTrue {
            res.stack.toString() == "[3, 4, 7]"
        }
    }

    @Test
    fun exampleJu() {
        val stack = Stack<Int>()
        stack.push(1)

        context.setStack(
            stack
        )

        val res = context.exec("주...")

        assertTrue {
            res.stack.toString() == "[-2]"
        }
    }

    @Test
    fun exampleGeo() {
        val stack = Stack<Int>()
        stack.push(1)

        context.setStack(
            stack
        )

        val res = context.exec("""
            거.....
            눈거..으
        """.trimIndent())

        assertTrue {
            res.stack.toString() == "[6, 9]"
        }
    }

    @Test
    fun exampleHae() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        context.setStack(
            stack
        )

        val res = context.exec("헤")

        assertTrue {
            res.stack.toString() == "[1, 2]"
        }
    }

    @Test
    fun exampleEu() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)

        context.setStack(
            stack
        )

        val res = context.exec("주..으")

        assertTrue {
            res.stack.toString() == "[1, -1]"
        }
    }

    @Test
    fun exampleEung() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        context.setStack(
            stack
        )

        val res = context.exec("응")

        assertTrue {
            res.stack.toString() == "[1, null, 1]"
        }
    }

    @Test
    fun exampleHeuEus() {
        val stack = Stack<Int>()
        stack.push(3)

        context.setStack(
            stack
        )

        val res = context.exec("흐...읏")

        assertTrue {
            res.stack.toString() == "[27]"
        }
    }

    @Test
    fun exampleHeart() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        context.setStack(
            stack
        )

        val res = context.exec("""💕""")

        assertTrue {
            res.stack.toString() == "[1, null, 5]"
        }
    }

    @Test
    fun exampleEtc1() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        context.setStack(
            stack
        )

        val res = context.exec("읏...")

        assertTrue {
            res.stack.toString() == "[1, 2, 3]"
        }
    }

    @Test
    fun exampleEtc2() {
        val res = context.exec("누흐읏")

        assertTrue {
            res.stack.toString() == "[0]"
        }
    }

}
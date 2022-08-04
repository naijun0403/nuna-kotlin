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
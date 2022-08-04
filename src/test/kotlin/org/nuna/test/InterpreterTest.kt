package org.nuna.test

import org.nuna.ir.Interpreter
import kotlin.test.Test
import kotlin.test.assertTrue

class InterpreterTest {

    @Test
    fun interpreterTest() {
        val script = """
            눈나..흐.....읏..나주..거....흐...읏...
            누..나..나...흐....읏..나주..거....💕
            눈나.....나..흐...읏나.....주거...💕
            누나..흐..읏나.......주..거......응읏..!

            눈나..으흐읏
            누으나.....주..흐....읏나....응
            누나.....나..주...읏나......응!
        """.trimIndent()

        val irList = Interpreter(script).interpretingByScript()

        assertTrue {
            irList.size == 170
        }
    }

}
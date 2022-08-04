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
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

package org.nuna

import org.nuna.ir.Interpreter
import org.nuna.option.OptionManager
import org.nuna.parser.Parser
import java.io.Closeable
import java.util.*

class NunaContext private constructor(
    val options: Map<String, String>
) : Closeable {

    private var stack: Stack<Int> = Stack()

    companion object {

        fun newBuilder(): Builder {
            return Builder()
        }

        fun create(): NunaContext {
            val builder = Builder()
            return builder.build()
        }

    }

    fun setStack(stack: Stack<Int>) {
        this.stack = stack
    }

    fun exec(script: String): Value {
        val irList = Interpreter(script).interpretingByScript()
        val option = OptionManager(options)
        val parser = Parser.createByIRModelList(irList, stack, option)
        parser.parseTokens() // run
        return ValueImpl(
            parser
        )
    }

    override fun close() {
        stack = Stack()
    }

    class Builder {

        private val map = HashMap<String, String>()

        fun addOption(key: String, value: String): Builder {
            map[key] = value
            return this
        }

        fun build(): NunaContext {
            return NunaContext(map)
        }

    }

}
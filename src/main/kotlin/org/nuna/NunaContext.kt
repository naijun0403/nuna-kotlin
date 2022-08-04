package org.nuna

import org.nuna.ir.Interpreter
import org.nuna.parser.Parser
import java.io.Closeable
import java.util.*

class NunaContext private constructor() : Closeable {

    private var stack: Stack<Int> = Stack()

    companion object {

        fun create(): NunaContext {
            return NunaContext()
        }

    }

    fun setStack(stack: Stack<Int>) {
        this.stack = stack
    }

    fun exec(script: String): Value {
        val irList = Interpreter(script).interpretingByScript()
        val parser = Parser.createByIRModelList(irList, stack)
        parser.parseTokens() // run
        return ValueImpl(
            parser
        )
    }

    override fun close() {
        stack = Stack()
    }

}
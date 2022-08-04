package org.nuna

import org.nuna.parser.Parser
import java.util.*

internal class ValueImpl(
    private val parser: Parser
) : Value {

    override val stack: Stack<Int> = parser.getResultByStack()

    override val string: String = parser.getResultByString()

    override fun getResultByStack(): Stack<Int> {
        return parser.getResultByStack()
    }

    override fun getResultByString(): String {
        return parser.getResultByString()
    }

}
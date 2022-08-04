package org.nuna.parser

import org.nuna.exception.SyntaxException
import org.nuna.model.IRDataModel
import org.nuna.token.Token
import org.nuna.util.CharUtil
import java.util.Stack
import kotlin.math.pow

internal class Parser(
    private val irList: List<IRDataModel>,
    private val stack: Stack<Int> = Stack()
) {

    private var current = 0
    private var next = 0

    private val stringBuilder = StringBuilder()

    /**
     * parse token
     */
    private fun parseOneToken(token: Token) {
        when (token) {
            Token.NUN, Token.NU -> {
                val count = getAfterDotCount()
                stack.push(if (count == 0) {
                    1
                } else count)
            }

            Token.NAN, Token.NA -> {
                val value = stack.pop()
                val dotCount = getAfterDotCount()
                val operand = if (dotCount == 0) {
                    1
                } else dotCount

                stack.push(
                    value * operand
                )
            }

            Token.JU -> {
                val value = stack.pop()
                val dotCount = getAfterDotCount()
                val operand = if (dotCount == 0) {
                    1
                } else dotCount

                stack.push(
                    value - operand
                )
            }

            Token.GEO -> {
                val value = stack.pop()
                val dotCount = getAfterDotCount()
                val operand = if (dotCount == 0) {
                    1
                } else dotCount

                stack.push(
                    value + operand
                )
            }

            Token.HAE -> {
                stack.pop()
            }

            Token.EUNG -> {
                val current = stack.pop()
                val before = stack.pop()

                stack.push(null)
                stack.push(
                    current - before
                )
            }

            Token.HEU -> {
                val value = stack.pop()

                val dotCount = getAfterDotCount()
                val peek = peekToken(next)

                if (peek != Token.EUS) {
                    throw SyntaxException("Expected ${Token.EUS.name} but ${peek.name}")
                }

                if (dotCount == 0) {
                    stack.push(
                        0
                    )
                } else {
                    stack.push(
                        value.toFloat().pow(dotCount).toInt()
                    )
                }
            }

            Token.HEART -> {
                val value = stack.pop()
                val before = stack.pop()

                stack.push(null)
                stack.push(
                    value + before
                )
            }

            Token.EXCLAMATION_MARK -> {
                println(stack)

                val charCode = stack.pop()

                val char = CharUtil.toStringUTF16(charCode)

                stringBuilder.append(char)
            }

            Token.EU -> {
                // 표준에 따라 아무것도 하지 않아도 됩니다.
            }

            Token.EUS -> {
                // 표준안에 따르면 해당 토큰은 `흐`을 위한 토큰이므로 아무것도 안해도 됩니다.
            }

            Token.DOT -> {
                // 표준안에 따르면 해당 토큰은 다른 토큰을 위한 부가 기능일뿐 아무것도 안해도 됩니다.
            }

            else -> {
                throw SyntaxException("Unexpected Token: ${token.name}")
            }
        }
    }

    fun parseTokens() {
        while (current < irList.size) {
            val token = irList[current].data

            parseOneToken(token)
            next = 0
            ++current
        }
    }

    fun getResultByStack(): Stack<Int> {
        return stack
    }

    fun getResultByString(): String {
        return stringBuilder.toString()
    }

    private fun getAfterDotCount(): Int {
        var count = 0
        while (peekToken() == Token.DOT) {
            ++count
        }
        if (peekToken(next) == Token.EU) {
            count += try {
                stack[stack.size - 1]
            } catch (e: ArrayIndexOutOfBoundsException) {
                0
            } ?: 0
        }

        return count
    }

    private fun peekToken(): Token {
        return try {
            ++next
            irList[current + next].data
        } catch (e: IndexOutOfBoundsException) {
            Token.NULL
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun peekToken(index: Int): Token {
        return try {
            irList[current + index].data
        } catch (e: IndexOutOfBoundsException) {
            Token.NULL
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    companion object {
        fun createByIRModelList(irList: List<IRDataModel>, stack: Stack<Int> = Stack()): Parser {
            return Parser(
                irList,
                stack
            )
        }
    }

}
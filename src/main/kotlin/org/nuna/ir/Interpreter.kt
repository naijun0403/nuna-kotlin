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

package org.nuna.ir

import org.nuna.model.IRDataModel
import org.nuna.token.Token

internal class Interpreter(
    private var script: String
) {

    private fun prepareScript() {
        script = script.replace("\uD83D\uDC95", "\u2665")
    }

    fun interpretingByScript(): List<IRDataModel> {
        prepareScript() // 💕를 토크나이저가 이해할 수 있는 형태로 변경

        var current = 0

        val charArray = script.toCharArray()

        val irList = ArrayList<IRDataModel>()

        val whiteSpace = Regex("\\s")

        while (current < charArray.size) {
            val char = charArray[current]

            if (whiteSpace.matches(char.toString())) {
                ++current
                continue
            }

            val token = Token.valueToToken(char.toString())

            irList.add(
                IRDataModel(
                    token
                )
            )

            ++current
        }

        return irList
    }

}
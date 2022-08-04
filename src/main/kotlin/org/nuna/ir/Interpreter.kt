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
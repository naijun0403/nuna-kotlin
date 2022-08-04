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

package org.nuna.token

import org.nuna.exception.SyntaxException

/** @see <a href="https://github.com/nunalang/nuna#%ED%82%A4%EC%9B%8C%EB%93%9C-keywards--operations">keyword</a> **/
enum class Token {

    NUN, // 눈
    NU, // 누
    NAN, // 난
    NA, // 나
    JU, // 주
    GEO, // 거
    DOT, // .
    HAE, // 헤
    EU, // 으
    EUNG, // 응
    HEU, // 흐
    EUS, // 읏
    HEART, // 💕
    EXCLAMATION_MARK, // !
    NULL; // 내부에 쓰이는 토큰, 실제에서는 영향 무

    companion object {
        fun valueToToken(value: String): Token {
            return when (value) {
                "눈" -> {
                    NUN
                }

                "누" -> {
                    NU
                }

                "난" -> {
                    NAN
                }

                "나" -> {
                    NA
                }

                "주" -> {
                    JU
                }

                "거" -> {
                    GEO
                }

                "." -> {
                    DOT
                }

                "헤" -> {
                    HAE
                }

                "으" -> {
                    EU
                }

                "응" -> {
                    EUNG
                }

                "흐" -> {
                    HEU
                }

                "읏" -> {
                    EUS
                }

                "\u2665" -> {
                    HEART
                }

                "!" -> {
                    EXCLAMATION_MARK
                }

                else -> {
                    throw SyntaxException("Unexpected token: $value")
                }
            }
        }
    }

}
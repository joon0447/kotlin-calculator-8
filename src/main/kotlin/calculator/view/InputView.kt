package calculator.view

import calculator.model.Delimiter
import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readInput(): String{
        println("덧셈할 문자열을 입력해 주세요.")
        val input = Console.readLine()
        val delimiter = Delimiter()
        delimiter.parseCustomDelimiter(input)
        return input
    }
}
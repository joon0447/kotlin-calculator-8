package calculator.view

import calculator.model.Delimiter
import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readInput(): String{
        val input = Console.readLine()
        val delimiter = Delimiter()
        delimiter.parseCustomDelimiter(input)
        return input
    }
}
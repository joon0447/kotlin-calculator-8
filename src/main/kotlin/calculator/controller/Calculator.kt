package calculator.controller

import calculator.model.Delimiter
import calculator.model.StringParser
import calculator.view.InputView

class Calculator(
    private val inputView: InputView = InputView()
) {

    fun run() {
        val input = inputView.readInput()

        val delimiter = Delimiter()
        delimiter.parseCustomDelimiter(input)

        val parser = StringParser(delimiter)
        val numbers = parser.extractNumbers(input)

        println(numbers)
    }
}
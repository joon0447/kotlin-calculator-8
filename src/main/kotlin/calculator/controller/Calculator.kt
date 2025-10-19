package calculator.controller

import calculator.model.Delimiter
import calculator.model.StringCalculator
import calculator.model.StringParser
import calculator.view.InputView
import calculator.view.OutputView

class Calculator(
    private val inputView: InputView = InputView()
) {

    fun run() {
        val input = inputView.readInput()
        val delimiter = Delimiter()
        if (!delimiter.isValidCustomDelimiterFormat(input)) {
            throw IllegalArgumentException("커스텀 구분자가 정상적으로 입력되지 않았습니다.")
        }
        delimiter.parseCustomDelimiter(input)

        val parser = StringParser(delimiter)
        val numbers = parser.extractNumbers(input)

        val sc = StringCalculator()
        val total = sc.addNumbers(numbers)

        val output = OutputView()
        output.printOutput(total)
    }
}
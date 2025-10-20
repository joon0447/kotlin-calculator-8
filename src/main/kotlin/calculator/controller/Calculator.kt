package calculator.controller

import calculator.model.Delimiter
import calculator.model.StringCalculator
import calculator.model.StringParser
import calculator.view.InputView
import calculator.view.OutputView

class Calculator(
    private val inputView: InputView = InputView(),
    private val delimiter: Delimiter = Delimiter(),
    private val parser : StringParser = StringParser(delimiter),
    private val sc : StringCalculator = StringCalculator(),
    private val outputView : OutputView = OutputView(),
) {

    fun run() {
        val input = inputView.readInput()
        if (!delimiter.isValidCustomDelimiterFormat(input)) {
            throw IllegalArgumentException("커스텀 구분자가 정상적으로 입력되지 않았습니다.")
        }
        delimiter.parseCustomDelimiter(input)
        val numbers = parser.extractNumbers(input)
        val total = sc.addNumbers(numbers)

        outputView.printOutput(total)
    }
}
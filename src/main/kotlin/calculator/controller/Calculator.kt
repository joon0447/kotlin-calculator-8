package calculator.controller

import calculator.view.InputView

class Calculator(
    private val inputView: InputView = InputView()
) {

    fun run() {
        val input = inputView.readInput()
        println(input)
    }
}
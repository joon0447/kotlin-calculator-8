package calculator.model

class StringCalculator {

    fun addNumbers(input : String) : Int {
        var total = 0
        for(ch in input) {
            total += ch.toString().toInt()
        }
        return total
    }
}
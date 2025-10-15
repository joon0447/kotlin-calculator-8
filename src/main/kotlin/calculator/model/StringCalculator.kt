package calculator.model

class StringCalculator {

    fun addNumbers(input : List<String>) : Int {
        var total = 0
        for(num in input) {
            total += num.toInt()
        }
        return total
    }
}
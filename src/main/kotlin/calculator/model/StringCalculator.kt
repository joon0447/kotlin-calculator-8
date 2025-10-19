package calculator.model

import java.math.BigDecimal

class StringCalculator {

    fun addNumbers(input : List<String>): BigDecimal {
        var total = BigDecimal.ZERO
        for (num in input) {
            total = total.add(num.toBigDecimal())
        }
        return total
    }
}
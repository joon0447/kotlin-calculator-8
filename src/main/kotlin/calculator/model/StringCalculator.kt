package calculator.model

import java.math.BigInteger

class StringCalculator {

    fun addNumbers(input : List<String>) : BigInteger {
        var total = BigInteger.ZERO
        for(num in input) {
            total = total.add(num.toBigInteger())
        }
        return total
    }
}
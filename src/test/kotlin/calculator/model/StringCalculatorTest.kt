package calculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun addNumbersTest() {
        val calculator = StringCalculator()
        val num = calculator.addNumbers(listOf("1", "105"))
        assertEquals(106.toBigDecimal(), num)
    }
}
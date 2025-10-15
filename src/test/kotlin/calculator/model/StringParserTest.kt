package calculator.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class StringParserTest {

    @Test
    fun extractNumbersTest() {
        val delimiter = Delimiter()
        val sp = StringParser(delimiter)
        assertEquals(listOf("1","2","3"), sp.extractNumbers("1,2:3"))
    }

    @Test
    fun `문자열이 숫자인지 확인하기` () {
        val delimiter = Delimiter()
        val sp = StringParser(delimiter)
        assertEquals(false, sp.isNumber(listOf("1,a,3")))
    }
}
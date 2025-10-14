package calculator.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class StringParserTest {

    @Test
    fun extractNumbersTest() {
        val delimiter = Delimiter()
        val sp = StringParser(delimiter)
        assertEquals("123", sp.extractNumbers("1,2:3"))
    }
}
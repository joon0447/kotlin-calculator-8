package calculator.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class DelimiterTest {

    @Test
    fun defaultDelimiterTest() {
        val delimiter = Delimiter()
        assertEquals(",:", delimiter.getDelimiter())
    }

    @Test
    fun parseCustomDelimiterTest() {
        val delimiter = Delimiter()
        val input = "//;\\n1;2;3"

        delimiter.parseCustomDelimiter(input)

        assertEquals(",:;", delimiter.getDelimiter())
    }

    @Test
    fun multiCustomDelimiterTest() {
        val delimiter = Delimiter()
        delimiter.addCustomDelimiter("$")
        delimiter.addCustomDelimiter("&")

        assertEquals(",:$&", delimiter.getDelimiter())
    }

    @Test
    fun noCustomDelimiterTest() {
        val delimiter = Delimiter()
        delimiter.parseCustomDelimiter("1,2,3")
        assertEquals(",:", delimiter.getDelimiter())
    }

}
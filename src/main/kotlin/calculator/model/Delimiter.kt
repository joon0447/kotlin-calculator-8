package calculator.model

class Delimiter {
    private var delimiter = ",:"

    fun parseCustomDelimiter(input: String) {
        if(input.substring(0, 2) == "//"){
            var start = 2
            while(input.substring(start, start+2) != "\\n"){
                start++
            }
            addCustomDelimiter(input.substring(2, start))
        }
    }

    fun addCustomDelimiter(input: String) {
        delimiter += input
        println(getDelimiter())
    }

    fun getDelimiter() : String {
        return delimiter
    }

}
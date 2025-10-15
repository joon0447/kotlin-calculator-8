package calculator.model

class Delimiter {
    private var delimiter = ",:"

    fun parseCustomDelimiter(input: String) {
        if(input.startsWith("//")){
            var start = 2
            while(input.substring(start, start+2) != "\\n"){
                start++
            }
            addCustomDelimiter(input.substring(2, start))
        }

    }

    fun addCustomDelimiter(input: String) {
        delimiter += input
    }

    fun getDelimiter() : String {
        return delimiter
    }

}
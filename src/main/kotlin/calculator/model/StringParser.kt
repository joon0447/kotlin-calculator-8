package calculator.model

class StringParser(val delimiter: Delimiter) {

    fun extractNumbers(input: String): String {
        val delimiters = delimiter.getDelimiter()
        var result = input
        for(delimiter in delimiters) {
            for(char in input){
                if(delimiter == char){
                    result = result.replace(char.toString(), "")
                    continue
                }
            }
        }

        if (result.startsWith("//")) {
            val endIndex = result.indexOf("\\n")
            if (endIndex != -1) {
                result = result.substring(endIndex + 2)
            }
        }

        if(!isNumber(result)) throw IllegalArgumentException("문자가 포함되어 있습니다.")

        return result
    }

    fun isNumber(input: String) : Boolean {
        return input.matches(Regex("[0-9]+$"))
    }
}
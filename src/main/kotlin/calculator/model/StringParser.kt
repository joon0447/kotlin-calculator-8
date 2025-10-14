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

        return result
    }
}
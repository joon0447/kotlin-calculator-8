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
        return result
    }
}
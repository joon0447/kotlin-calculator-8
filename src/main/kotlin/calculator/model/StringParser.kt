package calculator.model

class StringParser(val delimiter: Delimiter) {

    fun extractNumbers(input: String): List<String> {
        val list = ArrayList<String>()
        val delimiters = delimiter.getDelimiter()
        var result = input
        var str = ""

        if (result.startsWith("//")) {
            val endIndex = result.indexOf("\\n")
            if (endIndex != -1) {
                result = result.substring(endIndex + 2)
            }
        }

        for(char in result){
            var isDelimiter = false
            for(delimiter in delimiters){
                if(delimiter == char){
                    isDelimiter = true
                    break
                }
            }
            if(isDelimiter){
                list.add(str)
                str = ""
            }else{
                str += char
            }
        }

        if(str.isNotEmpty()) list.add(str)

        if(!isNumber(list)) throw IllegalArgumentException("문자가 포함되어 있습니다.")
        return list
    }

    fun isNumber(input: List<String>) : Boolean {
        for(str in input){
            if(!str.matches(Regex("[0-9]+"))) return false
        }
        return true
    }
}
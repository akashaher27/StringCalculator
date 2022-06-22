import java.util.regex.Matcher
import java.util.regex.Pattern

fun String.toNumbers(): List<Int> {
    if (this.contains("\\[(.*?)\\]".toRegex())){
        var delimiter = ""
        var split_numbers = listOf<String>()
        val start_index: Int = this.indexOf("//")
        val end_index: Int = this.indexOf("\n")

        // checking if delimiters exists in first line
        if (start_index != -1) {
            delimiter = this.substring(start_index + 2, end_index)
            var number = this.substring(end_index + 1)
            if (delimiter.endsWith("]") && delimiter.indexOf("[") == 0) {
                val pattern: Pattern = Pattern.compile("\\[(.*?)\\]")
                val matcher: Matcher = pattern.matcher(delimiter)
                val groupCount: Int = matcher.groupCount()
                while (matcher.find()) {
                    for (i in 0..groupCount) {
                        val m: String = matcher.group(i)
                        number = number.replace(m, ",");
                    }
                }
                delimiter = ","
            }

            // Splitting numbers with delimiter, Pattern to avoid chaos of *
            split_numbers = number.split(delimiter)
        } else {
            split_numbers = this.split(delimiter);  // To support | no "Pattern"}

        }
        return split_numbers.map { it.toInt() }
    }else{
        val delimeter1 = ","
        val delimeter2 = "\n"
        var delimeter3: String? = null
        var inputString: String? = null
        val pattern = "^//(.*)\n(.*)"
        Regex(pattern).find(this)?.run {
            delimeter3 = destructured.component1()
            inputString = destructured.component2()
        }
        return delimeter3?.let { delimeter ->
            inputString!!.split(delimeter1, delimeter2, delimeter).map {
                it.toInt()
            }
        } ?: this.split(delimeter1, delimeter2).map { it.toInt() }
    }
}

fun List<Int>.validate(): Result<Throwable, List<Int>> {
    val negativeNumbers = this.filter { it < 0 }

    if (negativeNumbers.isEmpty()) return Success(this)

    return Failure(
        IllegalArgumentException(
            "Negative numbers not allowed " +
                    negativeNumbers.joinToString(separator = ",")
        )
    )
}

fun List<Int>.removeNumbersGreaterThan1000(): List<Int> {
    return this.filter { it <= 1000 }
}



fun String.toNumbers(): List<Int> {
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

fun List<Int> .validate(): Result<Throwable, List<Int>> {
    val negativeNumbers = this.filter { it < 0 }

    if (negativeNumbers.isEmpty()) return Success(this)

    return Failure(
        IllegalArgumentException(
            "Negative numbers not allowed " +
                    negativeNumbers.joinToString(separator = ",")
        )
    )
}


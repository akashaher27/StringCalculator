class StringCalculator {

    fun add(number: String): Long {
        if (number.isEmpty()) {
            return 0
        }
        return number.toLong()
    }
}
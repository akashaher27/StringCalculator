class StringCalculator {

    fun add(number: String): Int {
        if (number.isEmpty()) {
            return 0
        }
        return number.toNumbers().sum()
    }
}
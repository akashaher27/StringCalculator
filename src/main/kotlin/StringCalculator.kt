class StringCalculator {

    fun add(number: String): Result<Throwable, Int> {
        if (number.isEmpty()) {
            return Success(0)
        }
        return number.toNumbers().validate().mapSuccess {
            it.sum()
        }
    }


}
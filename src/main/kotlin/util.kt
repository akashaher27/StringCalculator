fun String.toNumbers(): List<Int> {
    return this.split(",").map {
        it.toInt()
    }
}
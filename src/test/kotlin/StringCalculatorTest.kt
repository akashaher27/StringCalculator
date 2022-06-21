import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class StringCalculatorTest {

    private lateinit var calculator: StringCalculator

    @Before
    fun setup() {
        calculator = StringCalculator()
    }

    @Test
    fun emptyStringReturnZero() {
        assertEquals(0, calculator.add(""))
    }

    @Test
    fun singleNumberStringReturnNumber() {
        assertEquals(1, calculator.add("1"))
    }

}
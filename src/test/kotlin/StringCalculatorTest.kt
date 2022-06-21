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

    @Test
    fun twoNumberStringReturnSum() {
        assertEquals(2, calculator.add("1,1"))
    }

    @Test
    fun multipleNumberStringReturnSum() {
        assertEquals(3, calculator.add("1,2"))
        assertEquals(6, calculator.add("1,2,3"))
        assertEquals(5, calculator.add("1,4"))
        assertEquals(5, calculator.add("1,1,1,1,1"))
    }

}
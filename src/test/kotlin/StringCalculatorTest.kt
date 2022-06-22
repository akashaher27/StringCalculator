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
        assertEquals(0, calculator.add("").expectSuccess())
    }

    @Test
    fun singleNumberStringReturnNumber() {
        assertEquals(1, calculator.add("1").expectSuccess())
    }

    @Test
    fun twoNumberStringWithDelimeterCommaReturnSum() {
        assertEquals(2, calculator.add("1,1").expectSuccess())
    }

    @Test
    fun multipleNumberStringReturnSum() {
        assertEquals(3, calculator.add("1,2").expectSuccess())
        assertEquals(6, calculator.add("1,2,3").expectSuccess())
    }

    @Test
    fun numberDelimitedByCommaAndNewLineReturnSum() {
        assertEquals(6, calculator.add("1,2\n3").expectSuccess())
    }

    @Test
    fun numberDelimitedByCustomDelimitersReturnSum() {
        assertEquals(3, calculator.add("//;\n1;2").expectSuccess())
    }

    @Test
    fun negativeNumbersReturnException() {
        assertEquals("Negative numbers not allowed -1", calculator.add("//;\n-1;2").expectFailure().message)
    }


}
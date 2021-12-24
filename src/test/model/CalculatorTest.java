package test.model;

import main.exceptions.InvalidInput;
import main.model.Calculator;
import main.model.Operations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the calculator class
public class CalculatorTest {

//    @BeforeEach
//    public void runBefore() {
//        calc = new Calculator();
//    }

    @Test
    public void testSum() {
        Assertions.assertEquals("3", Calculator.sum("1", "2"));
        Assertions.assertEquals("-2", Calculator.sum("1", "-3"));
    }

    @Test
    public void testSub() {
        Assertions.assertEquals("-1", Calculator.sub("1", "2"));
        Assertions.assertEquals("4", Calculator.sub("1", "-3"));
    }

    @Test
    public void testMultiply() {
        Assertions.assertEquals("2", Calculator.multiply("1", "2"));
        Assertions.assertEquals("-12", Calculator.multiply("4", "-3"));
    }

    @Test
    public void testParseTwoInt() {
        Operations operations = Calculator.parse("1 + 2");
        assertArrayEquals(new String[]{"1", "+", "2"}, operations.getOp());
    }

    @Test
    public void testParseMultipleInt() {
        Operations operations = Calculator.parse("1 + 2 _ 5 x 17 x 5 + 1");
        assertArrayEquals(new String[]{"1", "+", "2", "_", "5", "x", "17", "x", "5", "+", "1"}, operations.getOp());
    }

    @Test
    public void testCalculateEmpty() {
        try {
            assertEquals("0", Calculator.calculate(""));
        } catch (InvalidInput e) {
            fail("Error should not have been thrown");
        }
    }

    @Test
    public void testCalculateTwoInt() {
        try {
            assertEquals("3", Calculator.calculate("1 + 2"));
        } catch (InvalidInput e) {
            fail("Error should not have been thrown");
        }
    }

    @ParameterizedTest
    @CsvSource({"2, 1 + 4 _ 3", "10, 5 x 2 _ 10 + 3 x 3 + 1", "2, 1 _ -1"})
    public void testCalculateMultipleInt(String answer, String input) {
        try {
            assertEquals(answer, Calculator.calculate(input));
        } catch (InvalidInput e) {
            fail("Error should not have been thrown");
        }
    }

    @Nested
    class OperateNestedTest {

        @Test
        public void testOperateSum() {
            Assertions.assertEquals("3", Calculator.operate("+", "1", "2"));
            Assertions.assertEquals("-2", Calculator.operate("+", "1", "-3"));
        }

        @Test
        public void testOperateSub() {
            Assertions.assertEquals("-1", Calculator.operate("_", "1", "2"));
            Assertions.assertEquals("4", Calculator.operate("_", "1", "-3"));
        }

        @Test
        public void testOperateMultiply() {
            Assertions.assertEquals("2", Calculator.operate("x", "1", "2"));
            Assertions.assertEquals("-12", Calculator.operate("x", "4", "-3"));
        }
    }
}

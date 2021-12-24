package test.model;

import main.model.Operations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsTest {

    @Test
    public void validOperations() {
        Operations oper = new Operations(new String[]{"1", "+", "2", "_", "5", "x", "17", "x", "5", "+", "1"});
        assertTrue(oper.isValid());
    }

    @Test
    public void inValidDoubleOperation() {
        Operations oper = new Operations(new String[]{"1", "+", "2", "_", "+", "5", "x", "17", "x", "5", "+", "1"});
        assertFalse(oper.isValid());
    }

    @Test
    public void inValidLeadingOperation() {
        Operations oper = new Operations(new String[]{"x", "1", "+", "2", "_", "5", "x", "17", "x", "5", "+", "1"});
        assertFalse(oper.isValid());
    }

    @Test
    public void inValidTailingOperation() {
        Operations oper = new Operations(new String[]{"1", "+", "2", "-", "5", "x", "17", "x", "5", "+", "1", "_"});
        assertFalse(oper.isValid());
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest extends AbstractParent {
    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(3, calculator.calculate(Calculator.Operation.ADD, 1, 2), "1 + 2 = 3");
        assertEquals(0, calculator.calculate(Calculator.Operation.ADD, -2, 2), "-2 + 2 = 0");
        assertEquals(-3, calculator.calculate(Calculator.Operation.ADD, -1, -2), "-1 + -2 = -3");
    }

    @Test
    void testSubtract() {
        assertEquals(-1, calculator.calculate(Calculator.Operation.SUBTRACT, 1, 2), "1 - 2 = -1");
        assertEquals(-4, calculator.calculate(Calculator.Operation.SUBTRACT, -2, 2), "-2 - 2 = -4");
        assertEquals(1, calculator.calculate(Calculator.Operation.SUBTRACT, -1, -2), "-1 - -2 = 1");
    }

    @Test
    void testMultiply() {
        assertEquals(2, calculator.calculate(Calculator.Operation.MULTIPLY, 1, 2), "1 * 2 = 2");
        assertEquals(-4, calculator.calculate(Calculator.Operation.MULTIPLY, -2, 2), "-2 * 2 = -4");
        assertEquals(2, calculator.calculate(Calculator.Operation.MULTIPLY, -1, -2), "-1 * -2 = 2");
    }

    @Test
    void testDivide() {
        assertEquals(0, calculator.calculate(Calculator.Operation.DIVIDE, 1, 2), "1 / 2 = 0");
        assertEquals(-1, calculator.calculate(Calculator.Operation.DIVIDE, -2, 2), "-2 / 2 = -1");
        assertEquals(0, calculator.calculate(Calculator.Operation.DIVIDE, -1, -2), "-1 / -2 = 0");
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(Calculator.Operation.DIVIDE, 1, 0), "Cannot divide by zero");
    }

    @Test
    void testInvalidOperation() {
        assertThrows(NullPointerException.class, () -> calculator.calculate(null, 1, 2), "Invalid operation");
    }
}
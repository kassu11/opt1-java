public class Calculator {

    public int calculate(Operation operation, int a, int b) {
        return switch (operation) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> {
                if (b == 0) throw new IllegalArgumentException("Cannot divide by zero");
                yield a / b;
            }
        };
    }

    public enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}

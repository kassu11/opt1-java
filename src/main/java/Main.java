

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(Calculator.Operation.ADD, 1, 2));
        System.out.println(calculator.calculate(Calculator.Operation.SUBTRACT, 1, 2));
        System.out.println(calculator.calculate(Calculator.Operation.MULTIPLY, 1, 2));
        System.out.println(calculator.calculate(Calculator.Operation.DIVIDE, 1, 2));
    }
}

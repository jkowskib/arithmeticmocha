package jkowski.arithmocha;

import jkowski.arithmocha.exceptions.InvalidSymbol;
import jkowski.arithmocha.exceptions.IncompleteExpression;

import java.util.ArrayList;

/**
 * A mathematical expression
 */
public class Expression {
    private static final String[] EXTRA_SYMBOLS = { "(", ")" };
    private static final String[] FUNCTION_NAMES = {
            "sqrt", "sin", "cos", "tan", "arcsin", "arccos", "arctan"
    };
    private static final String[] OPERATION_ORDER = { "^", "/", "*", "+", "-" };

    /**
     * Evaluate an expression
     * @param expression the expression to evaluate
     * @throws InvalidSymbol if an invalid math symbol is given
     * @throws IncompleteExpression if an expression is incomplete or broken
     * @return double
     */
    public static double evaluate(String expression) throws InvalidSymbol, IncompleteExpression {
        ArrayList<String> stack = Expression.compile(expression);
        evaluateSubExpressions(stack);
        return eval(stack);
    }

    /**
     * Evaluates a compiled expression
     * @return double
     * @throws InvalidSymbol if an unknown symbol is given
     * @throws IncompleteExpression if an expression is incomplete or broken
     */
    private static double eval(ArrayList<String> stack) throws InvalidSymbol, IncompleteExpression {
        for (String function : FUNCTION_NAMES) {
            while (stack.contains(function)) {
                int index = stack.indexOf(function);
                String right = stack.get(index + 1);

                double result = Expression.function(function, right);

                stack.set(index, Double.toString(result));
                stack.remove(index + 1);
            }
        }

        for (String searchOperation : OPERATION_ORDER) {
            while (stack.contains(searchOperation)) {
                int index = stack.indexOf(searchOperation);
                String left = stack.get(index - 1);
                String right = stack.get(index + 1);
                char operation = stack.get(index).charAt(0);

                if (!isValidOperator(operation)) {
                    throw new InvalidSymbol(
                            String.format("'%s' is not a valid operator", operation)
                    );
                }

                double result = Expression.operate(operation, left, right);

                    // Set left to the result
                stack.set(index - 1, Double.toString(result));
                stack.remove(index); // Remove index
                stack.remove(index); // Remove right (the index shifts when removed)
            }
        }

        // We can't have an expression two values and no operators, the expression is broken
        if (stack.size() == 2) {
            throw new IncompleteExpression("the given expression is incomplete");
        }

        return Double.parseDouble(stack.getFirst());
    }

    /**
     * Evaluates sub expressions inside a larger expression
     * @param stack the compiled stack
     * @throws IncompleteExpression if an expression is incomplete or broken
     */
    private static void evaluateSubExpressions(ArrayList<String> stack) throws IncompleteExpression {
        while (stack.contains("(")) {
            int startIndex = stack.lastIndexOf("(");
            int endIndex = startIndex + stack.subList(startIndex, stack.size()).indexOf(")");

            if (startIndex > endIndex) {
                throw new IncompleteExpression("the given expression is incomplete");
            }

            ArrayList<String> newExpression = new ArrayList<>(
                    stack.subList(startIndex + 1, endIndex)
            );

            double result = eval(newExpression);

            stack.set(startIndex, Double.toString(result));

            for (int i = 0; i < endIndex - startIndex; i++) {
                stack.remove(startIndex + 1);
            }
        }
    }

    /**
     * Executes a function
     * @param function the function to run
     * @param argument the argument
     * @return double
     * @throws InvalidSymbol if the function is unknown
     */
    private static double function(String function, String argument) throws InvalidSymbol {
        return switch (function) {
            case "sqrt" -> Math.sqrt(Double.parseDouble(argument));
            case "sin" -> Math.sin(Double.parseDouble(argument));
            case "cos" -> Math.cos(Double.parseDouble(argument));
            case "tan" -> Math.tan(Double.parseDouble(argument));
            case "arcsin" -> Math.asin(Double.parseDouble(argument));
            case "arccos" -> Math.acos(Double.parseDouble(argument));
            case "arctan" -> Math.toDegrees(Double.parseDouble(argument));
            default -> throw new InvalidSymbol(
                    String.format("unknown function '%s'", function));
        };
    }

    /**
     * Performs an operation on strings and returns the result
     * @param operation the operation char
     * @param left left item
     * @param right right item
     * @return double
     */
    private static double operate(char operation, String left, String right) {
        return switch (operation) {
            case '+' -> Double.parseDouble(left) + Double.parseDouble(right);
            case '-' -> Double.parseDouble(left) - Double.parseDouble(right);
            case '*' -> Double.parseDouble(left) * Double.parseDouble(right);
            case '/' -> Double.parseDouble(left) / Double.parseDouble(right);
            case '^' -> Math.pow(Double.parseDouble(left), Double.parseDouble(right));
            default -> 0.0;
        };
    }

    /**
     * Takes in a mathematical expression and compiles it into an expression
     * @param expression string expression
     * @return Expression object
     */
    private static ArrayList<String> compile(String expression) {
        ArrayList<String> operations = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();

        for (char pos : expression.toCharArray()) {
            // Converts (5 + 2 + 1) to (5+2+1)
            if (pos == ' ') {
                continue;
            }

            /*
            If we hit an operator the buffer needs to be added and cleared if anything was
            current being parsed, and the operator needs to be added to our compiled stack.
             */
            if (isValidOperator(pos)) {
                if (!buffer.isEmpty()) {
                    operations.add(buffer.toString());
                    buffer = new StringBuilder();
                }
                operations.add(String.valueOf(pos));
                continue;
            }

            buffer.append(pos);
        }

        if (!buffer.isEmpty()) {
            operations.add(buffer.toString());
        }

        return operations;
    }

    /**
     * Checks if the given character is a known operator
     * @param operator the operation char
     * @return boolean
     */
    private static boolean isValidOperator(char operator) {
        for (String symbol : EXTRA_SYMBOLS) {
            if (symbol.equals(String.valueOf(operator))) {
                return true;
            }
        }

        for (String operation : OPERATION_ORDER) {
            if (operation.equals(String.valueOf(operator))) {
                return true;
            }
        }
        return false;
    }
}

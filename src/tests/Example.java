package tests;

import jkowski.arithmocha.Expression;

public class Example {
    public static void main() {
        double result = Expression.evaluate("10 + 2 + 7 * 15");
        System.out.println(result);
    }
}
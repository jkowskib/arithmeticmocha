package tests;

import jkowski.arithmocha.Expression;

public class Main {
    public static void main(String[] args) {
        double result = Expression.evaluate("10 + 2 + 7 * 15");
        System.out.println(result);
    }
}
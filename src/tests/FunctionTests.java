package tests;

import jkowski.arithmocha.Expression;
import jkowski.arithmocha.Function;

public class FunctionTests {
    public static void main(String[] args) {
        Function pythagoreanFormula = new Function(
                "pythagoreanFormula", "(a^2) + (b^2)", "a", "b"
        );

        System.out.println(pythagoreanFormula); // pythagoreanFormula(a, b) = (a^2) + (b^2)

        String compiledFormula = pythagoreanFormula.compile(
                2, 4 // a, b
        );

        System.out.println(compiledFormula); // (2.0^2) + (4.0^2)
        System.out.println(
                Expression.evaluate(compiledFormula)
        ); // 20.0
    }
}

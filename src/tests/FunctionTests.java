package tests;

import jkowski.arithmocha.Function;
import jkowski.arithmocha.Expression;

public class FunctionTests {
    public static void main(String[] args) {
        Function pythagoreanFormula = new Function(
                "c", "sqrt((a^2) + (b^2))", "a", "b"
        );

        System.out.println(pythagoreanFormula); // c(a, b) = (a^2) + (b^2)

        String compiledFormula = pythagoreanFormula.compile(
                2, 4 // a, b
        );

        System.out.println(compiledFormula); // sqrt((2.0^2) + (4.0^2))
        System.out.println(
                Expression.evaluate(compiledFormula)
        ); // sqrt(20) or 4.47213595499958
    }
}

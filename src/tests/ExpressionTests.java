import jkowski.arithmocha.Expression;

public class ExpressionTests {
    public static void main(String[] args) {
        System.out.println(
                Expression.evaluate("10 + 2 + 7 * 15")
        ); // 117.0

        System.out.println(
                Expression.evaluate("10 * (5 + 5) - (4 + 1)")
        ); // 95.0

        System.out.println(
                Expression.evaluate("5 + (4 + (3 + (2 + 1)))")
        ); // 15.0
    }
}
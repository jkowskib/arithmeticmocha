import jkowski.arithmocha.Expression;

public class ExpressionTests {
    public static void main(String[] args) {
        double result117 = Expression.evaluate("10 + 2 + 7 * 15");
        assert result117 == 117.0;

        double result95 = Expression.evaluate("10 * (5 + 5) - (4 + 1)");
        assert result95 == 95.0;

        double result15 = Expression.evaluate("5 + (4 + (3 + (2 + 1)))");
        assert result15 == 15.0;

        System.out.println(result117);
        System.out.println(result95);
        System.out.println(result15);
    }
}
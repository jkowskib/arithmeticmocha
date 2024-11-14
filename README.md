# ArithmeticMocha (arithmocha)
Mathematics expression evaluation tools for Java

## How it works
This library uses String parsing to be able to take in an
equation such as `8 + 2` to give you `10`.

```java
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
```

This will evaluate and return the result of the expression.

## Goals
Some things to work on

- [x] Simple expression evaluation
- [x] Nested expression evaluation
- [x] Function definitions
- [x] Functions with variables
- [x] Functions with multiple variables
- ~~[ ] Functions inside expressions~~ (Not sure if this is in scope, may come back later)
- [x] sqrt and other common functions
# ArithmeticMocha (arithmocha)
Mathematics expression evaluation tools for Java

## How it works
This library uses String parsing to be able to take in an
equation such as `8 + 2` to give you `10`.

An example usage would be for example;
```java
double result = Expression.evaluate("10 + 2 + 7 * 15");
```

This will evaluate and return the result of the expression.

## Goals
Some things to work on

- [x] Simple expression evaluation
- [x] Nested expression evaluation
- [ ] Function definitions
- [ ] Functions with variables
- [ ] Functions with multiple variables
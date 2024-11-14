package jkowski.arithmocha;

import jkowski.arithmocha.exceptions.MissingVariables;

/**
 * Mathematical functions
 */
public class Function {
    private final String name;
    private final String expression;
    private final String[] variables;

    /**
     * Function that contains an expression with variables
     * @param expression the expression with variables
     * @param variables the used variables
     */
    public Function(String name, String expression, String... variables) {
        this.name = name;
        this.expression = expression;
        this.variables = variables;
    }

    /**
     * Compiles the expression with the variable values filled
     * (output can be passed to Expression)
     * @return String of the compiled expression
     * @throws MissingVariables if the given variables does not match the amount in the function
     */
    public String compile(double... variables) throws MissingVariables {
        if (this.variables.length != variables.length) {
            throw new MissingVariables("Number of variables and variables do not match");
        }

        String compiledString = expression;

        for (int position = 0; position < this.variables.length; position++) {
            String name = this.variables[position];
            double value = variables[position];

            compiledString = compiledString.replaceAll(
                    name, Double.toString(value));
        }

        return compiledString;
    }

    /**
     * Get the functions name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Get the internal expression of function
     * @return String
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Get the listed variables of function
     * @return String[]
     */
    public String[] getVariables() {
        return variables;
    }

    @Override
    public String toString() {
        return String.format("%s(%s) = %s", name, String.join(", ", this.variables), expression);
    }
}

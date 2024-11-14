package jkowski.arithmocha.exceptions;

/**
 * Used for broken or incomplete expressions such as missing an operator or not closing a sub expressions
 */
public class IncompleteExpression extends RuntimeException {
    /**
     * IncompleteExpression
     * @param message message
     */
    public IncompleteExpression(String message) {
        super(message);
    }
}

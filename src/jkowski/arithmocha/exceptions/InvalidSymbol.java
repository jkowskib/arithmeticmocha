package jkowski.arithmocha.exceptions;

/**
 * For if an unknown symbol is given in an expression
 */
public class InvalidSymbol extends RuntimeException {
    /**
     * InvalidSymbol
     * @param message message
     */
    public InvalidSymbol(String message) {
        super(message);
    }
}

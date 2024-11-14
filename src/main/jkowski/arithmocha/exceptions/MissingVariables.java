package jkowski.arithmocha.exceptions;

/**
 * For if a function is not given enough values for the amount of variables
 */
public class MissingVariables extends RuntimeException {
    /**
     * MissingVariables
     * @param message message
     */
    public MissingVariables(String message) {
        super(message);
    }
}

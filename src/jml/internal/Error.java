/*
 * Error.java
 * belicfr
 */
package jml.internal;

/**
 * Compiler internal error class.
 *
 * <p>
 *     This class allows the compiler to display detailed
 *     and accessible internal errors to output when the
 *     compiler is called and used.
 * </p>
 *
 * <p>
 *     The print method use an ad hoc polymorphism to offer
 *     different level of information displaying.
 * </p>
 *
 * @author belicfr
 */
public class Error {
    /**
     * Internal error body with only the reason to display.
     */
    private static String ERROR_BODY_WITH_ONLY_REASON
        = "JML COMPILER INTERNAL ERROR:\n"
        + "Reason: %s\n"
        + "Error location: %s\n";

    /**
     * Internal error body with the reason and the
     * line to display.
     */
    private static String ERROR_BODY_WITH_REASON_AND_LINE
            = "JML COMPILER INTERNAL ERROR:\n"
            + "Reason: %s\n"
            + "Line: %d\n"
            + "Error location: %s\n";

    /**
     * Print an internal error with only the reason.
     *
     * @param reason The error reason to display
     * @param location The error trigger location
     */
    public static void print(String reason, Class location) {
        System.out.printf(ERROR_BODY_WITH_ONLY_REASON,
                          reason,
                          location.getName());
    }

    /**
     * Print an internal error with the reason and the
     * line number.
     *
     * @param reason The error reason to display
     * @param location The error trigger location
     * @param line The line number where the error is
     *             located
     */
    public static void print(String reason, Class location, int line) {
        System.out.printf(ERROR_BODY_WITH_REASON_AND_LINE,
                          reason,
                          location.getName(),
                          line);
    }
}

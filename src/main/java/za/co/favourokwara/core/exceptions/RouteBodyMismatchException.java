package za.co.favourokwara.core.exceptions;

/**
 * An exception representing a mismatch between the route parameter and the body property.
 */

public class RouteBodyMismatchException extends RuntimeException {

    /**
     * Creates a new {@link RouteBodyMismatchException}.
     * 
     * @param routeName The name of the value in the route.
     */
    public RouteBodyMismatchException(String routeName) {
        this(routeName, routeName);
    }

    /**
     * Creates a new {@link RouteBodyMismatchException}.
     * 
     * @param routeName    The name of the value in the route.
     * @param propertyName The name of the value in the body.
     */
    public RouteBodyMismatchException(String routeName, String propertyName) {
        super(String.format("%s: it doesn't match %s in the route.", propertyName, routeName));
    }
}

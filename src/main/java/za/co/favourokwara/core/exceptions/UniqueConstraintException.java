package za.co.favourokwara.core.exceptions;

import lombok.Getter;

/**
 * An exception representing a unique constraint violation.
 */

@Getter
public class UniqueConstraintException extends RuntimeException {
    
    private final String name;
    private final String value;

    public UniqueConstraintException(String name, String value) {
        super(String.format("%s: must be unique. {rejectedValue: %s}", name, value));
        this.name = name;
        this.value = value;
    }
}

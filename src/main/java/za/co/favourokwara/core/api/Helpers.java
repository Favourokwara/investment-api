package za.co.favourokwara.core.api;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;

/**
 * This interface contains helper methods for
 * {@link za.co.favourokwara.core.api} package.
 */
public interface Helpers {

    /**
     * Creates an error list from {@literal violations}.
     * 
     * @param violations the set of {@link ConstraintViolation}.
     * @return a {@link String} array containing error messages.
     */
    static String[] buildErrors(Set<ConstraintViolation<?>> violations) {

        String[] errors = new String[violations.size()];

        int i = 0;
        for (ConstraintViolation<?> violation : violations) {
            Optional<Path.Node> leafNode = getLeafNode(violation.getPropertyPath());
            errors[i++] = String.format("%s: %s.", leafNode.isPresent() ? leafNode.get().getName() : String.valueOf(i),
                    violation.getMessage());
        }

        return errors;
    }

    /**
     * Creates an error list from {@literal objectErrors}.
     * 
     * @param violations the set of {@link ObjectError}.
     * @return a {@link String} array containing error messages.
     */
    static String[] buildErrors(List<ObjectError> objectErrors) {

        String[] errors = new String[objectErrors.size()];

        int i = 0;
        for (ObjectError objectError : objectErrors) {
            errors[i++] = String.format("%s: %s.",
                    objectError instanceof FieldError ? ((FieldError) objectError).getField()
                            : objectError.getObjectName(),
                    objectError.getDefaultMessage());
        }

        return errors;
    }

    /**
     * Return the leaf {@link Path.Node} of {@literal path}.
     * 
     * @param path the {@link Path} value.
     * @return the leaf {@link Path.Node} of {@literal path}.
     */
    private static Optional<Path.Node> getLeafNode(Path path) {
        return StreamSupport.stream(path.spliterator(), false).reduce((a, b) -> b);
    }
}

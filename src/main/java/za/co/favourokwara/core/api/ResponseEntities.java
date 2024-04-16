package za.co.favourokwara.core.api;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import za.co.favourokwara.core.results.Result;
import za.co.favourokwara.core.results.ResultData;

public class ResponseEntities {

    /**
     * Creates a {@link ResponseEntity} objects that produce a @link
     * {@link HttpStatus#OK} response without value.
     * 
     * @return the created {@link ResponseEntity} for the response.
     */
    public static ResponseEntity<Object> ok() {
        return ResponseEntity.ok(Result.ok(ResponseMessages.OK));
    }

    /**
     * Creates a {@link ResponseEntity} objects that produce a @link
     * {@link HttpStatus#OK} response without value.
     * 
     * @return the created {@link ResponseEntity} for the response.
     */
    public static <T> ResponseEntity<Object> ok(T value) {
        return ResponseEntity
                .ok(ResultData
                        .builder()
                        .payload(value)
                        .success(true)
                        .message(ResponseMessages.OK)
                        .build());
    }

    /**
     * Creates a {@link ResponseEntity} object that produces a
     * {@link HttpStatus#CREATED} response with value.
     * 
     * @param <T>   the type of value.
     * @param uri   the URI at which the content has been created.
     * @param value the content value to format in the entity body.
     * @return the created {@link Responsibility} for the response.
     */
    public static <T> ResponseEntity<Object> created(URI uri, T value) {
        return ResponseEntity.created(uri)
                .body(ResultData
                        .builder()
                        .payload(value)
                        .success(true)
                        .message(ResponseMessages.CREATED)
                        .build());
    }

    /**
     * Creates a {@link ResponseEntity} object that produces a link
     * {@link HttpStatus#NO_CONTENT}.
     * 
     * @return the created {@link ResponseEntity} for the response.
     */
    public static ResponseEntity<Object> noContent() {
        return ResponseEntity.noContent().build();
    }
}

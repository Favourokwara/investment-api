package za.co.favourokwara.core.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.ConstraintViolationException;
import za.co.favourokwara.core.exceptions.CreateInstanceException;
import za.co.favourokwara.core.exceptions.ForeignKeyConstraintException;
import za.co.favourokwara.core.exceptions.InvalidFieldException;
import za.co.favourokwara.core.exceptions.InvalidValueException;
import za.co.favourokwara.core.exceptions.NoSuchDeclaredFieldException;
import za.co.favourokwara.core.exceptions.RecordNotFoundException;
import za.co.favourokwara.core.exceptions.RouteBodyMismatchException;
import za.co.favourokwara.core.exceptions.UniqueConstraintException;
import za.co.favourokwara.core.results.Result;

public abstract class RestControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    Result handle(ConstraintViolationException e) {
        return Result.fail(ResponseMessages.ERR_VALIDATION, Helpers.buildErrors(e.getConstraintViolations()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    Result handle(MethodArgumentNotValidException e) {
        return Result.fail(ResponseMessages.ERR_VALIDATION, Helpers.buildErrors(e.getBindingResult().getAllErrors()));
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ForeignKeyConstraintException.class)
    @ResponseBody
    Result handle(ForeignKeyConstraintException e) {
        return Result.fail(ResponseMessages.ERR_VALIDATION, e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseBody
    Result handle(RecordNotFoundException e) {
        return Result.fail(ResponseMessages.ERR_NOT_FOUND, e.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UniqueConstraintException.class)
    @ResponseBody
    Result handle(UniqueConstraintException e) {
        return Result.fail(ResponseMessages.ERR_UNIQUE_CONSTRAINT, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            RouteBodyMismatchException.class,
            InvalidFieldException.class,
            InvalidValueException.class
    })
    @ResponseBody
    Result handleBadRequest(RuntimeException e) {
        return Result.fail(ResponseMessages.ERR_BAD_REQUEST, e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            NoSuchDeclaredFieldException.class,
            CreateInstanceException.class
    })
    @ResponseBody
    Result handleInternalServer(RuntimeException e) {
        return Result.fail(ResponseMessages.ERR_INTERNAL_SERVER, e.getMessage());
    }
}

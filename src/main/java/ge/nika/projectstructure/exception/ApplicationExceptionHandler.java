package ge.nika.projectstructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Annotation indicating that this class provides global exception handling for Spring MVC controllers
@RestControllerAdvice
// Method: handleInvalidArgument
// Description: This method serves as a global exception handler for MethodArgumentNotValidException.
// It takes a MethodArgumentNotValidException as a parameter, which is thrown when validation
// on an argument annotated with @Valid fails. The method extracts field errors from the
// BindingResult of the exception, creates a map of field names and their corresponding error
// messages, and returns this map. The map will be serialized to JSON in the response.
public class ApplicationExceptionHandler {

    // Annotation specifying that this method handles MethodArgumentNotValidException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
        // Map to store field names and their corresponding error messages
        Map<String, String> errorMap = new HashMap<>();

        // Extracting field errors from the BindingResult of the exception
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            // Populating the errorMap with field name and error message
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        // Returning the errorMap, which will be serialized to JSON in the response
        return errorMap;
    }
}
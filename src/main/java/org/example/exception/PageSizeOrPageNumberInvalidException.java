package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.BAD_REQUEST, reason = "Page size and page number must be valid numbers.")
public class PageSizeOrPageNumberInvalidException extends Exception {


    public PageSizeOrPageNumberInvalidException() {
        super("Page size and page number must be valid numbers.");
    }
}

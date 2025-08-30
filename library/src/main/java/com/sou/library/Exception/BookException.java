package com.sou.library.Exception;

public class BookException extends RuntimeException {
    public BookException(Throwable cause) {
        super(cause);
    }
    public BookException(String message) {
        super(message);
    }
}


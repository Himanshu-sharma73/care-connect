package org.careconnect.careconnectcommon.exception;

public class BookingDtoException extends RuntimeException {
    private String errorDetails;

    public BookingDtoException(String errorDetails) {
        super(String.format("%s",errorDetails));
        this.errorDetails = errorDetails;
    }
}

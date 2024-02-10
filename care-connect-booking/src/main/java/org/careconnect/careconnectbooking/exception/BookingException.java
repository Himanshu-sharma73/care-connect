package org.careconnect.careconnectbooking.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingException {
    private String errorCode;
    private String errorDetails;
    private String errorDescription;
}

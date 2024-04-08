package org.careconnect.careconnectpatient.exceptionfeign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessage {
    private String errorCode;
    private String errorDetails;
    private String errorDescription;
}
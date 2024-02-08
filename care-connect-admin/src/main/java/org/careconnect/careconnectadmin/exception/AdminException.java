package org.careconnect.careconnectadmin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminException {
    private String errorCode;
    private String errorDetails;
    private String errorDescription;
}

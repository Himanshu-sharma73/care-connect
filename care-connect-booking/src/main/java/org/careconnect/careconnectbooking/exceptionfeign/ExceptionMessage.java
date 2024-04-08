package org.careconnect.careconnectbooking.exceptionfeign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionMessage {
    private String errorCode;
    private String errorDetails;
    private String errorDescription;
}
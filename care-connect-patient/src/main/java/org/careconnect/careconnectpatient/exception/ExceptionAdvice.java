package org.careconnect.careconnectpatient.exception;

import org.careconnect.careconnectpatient.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(PatientExitException.class)
    public ResponseEntity<ApiResponse> exitException(PatientExitException e){
        CareConnectException careConnectException=new CareConnectException("1000",e.getMessage(),
                "These details are already taken");
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setError(careConnectException);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> validationError(MethodArgumentNotValidException e){
        CareConnectException careConnectException=new CareConnectException("1001",e.getFieldError().getDefaultMessage(),
                "You are entering wrong details please check them ");
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setError(careConnectException);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceError(ResourceNotFoundException e){
        CareConnectException careConnectException=new CareConnectException("1002",e.getMessage(),
                "You are entering wrong details please check them ");
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setError(careConnectException);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_ACCEPTABLE);
    }
}

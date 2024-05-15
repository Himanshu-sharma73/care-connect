package org.careconnect.careconnectcommon.exception;

public class DoctorExitException extends RuntimeException{

    private String resource; //patient //doctor

    private String fieldName;  // like email adhar and other

    private  String fieldValue;  //and the values

    public DoctorExitException(String resource, String fieldName, String fieldValue) {
        super(String.format("%s found with %s: %s",resource,fieldName,fieldValue ));
        this.resource = resource;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

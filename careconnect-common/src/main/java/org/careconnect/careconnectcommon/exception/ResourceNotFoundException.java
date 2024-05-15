package org.careconnect.careconnectcommon.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resource; //patient //doctor

    private String fieldName;  //like id and other

    private  String fieldValue; //its values

    public ResourceNotFoundException(String resource, String fieldName, String fieldValue) {
        super(String.format("%s not found With %s: %s",resource,fieldName,fieldValue));
        this.resource = resource;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

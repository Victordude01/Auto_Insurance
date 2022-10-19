package com.insurance.Config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExpectionNF extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String resource;
    private String fieldName;
    public  Object fieldValue;

    public ExpectionNF(String resource, String fieldName, Object fieldValue){
        super(String.format("%s not found with %s : '%s'",resource,fieldName,fieldValue));
        this.resource = resource;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResource(){
        return resource;
    }
    public void setResource(String resource){
        this.resource = resource;
    }
    public String getFieldName(){
        return fieldName;
    }
    public void setFieldName(String fieldName){
        this.fieldName = fieldName;
    }
    public Object getFieldValue(){
        return fieldValue;
    }
    public void setFieldValue(Object fieldValue){
        this.fieldValue = fieldValue;
    }
}

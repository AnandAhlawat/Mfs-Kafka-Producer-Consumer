package com.github.anand.domain;

import lombok.Data;

@Data
public class ServiceResponse {
    int code;
    String statusMessage;
    boolean success;

    public static ServiceResponse success(String statusMessage){
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setCode(0);
        serviceResponse.setSuccess(true);
        serviceResponse.setStatusMessage(statusMessage);
        return serviceResponse;
    }

    public static ServiceResponse failed(String statusMessage){
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setCode(99);
        serviceResponse.setSuccess(false);
        serviceResponse.setStatusMessage(statusMessage);
        return serviceResponse;
    }
}

package com.air_research.airwarningsystem.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author zwell
 */
@Data
public class ServerResponse<T> {

    private Boolean success;
    private Integer code;
    private String message;
    private T data;

    private ServerResponse() {}

    public ServerResponse(T data) {
        this.success = ResultEnum.OK.getSuccess();
        this.code = ResultEnum.OK.getCode();
        this.message = ResultEnum.OK.getMessage();
        this.data = data;
    }

    public ServerResponse(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity<ServerResponse> ok(T params) {
        ServerResponse serverResponse = new ServerResponse();

        serverResponse.setSuccess(ResultEnum.OK.getSuccess());
        serverResponse.setCode(ResultEnum.OK.getCode());
        serverResponse.setMessage(ResultEnum.OK.getMessage());
        serverResponse.setData(params);

        return new ResponseEntity<>(serverResponse, HttpStatus.OK);
    }

    public ResponseEntity<ServerResponse> badRequest(T params) {
        ServerResponse serverResponse = new ServerResponse();

        serverResponse.setSuccess(ResultEnum.BAD_REQUEST.getSuccess());
        serverResponse.setCode(ResultEnum.BAD_REQUEST.getCode());
        serverResponse.setMessage(ResultEnum.BAD_REQUEST.getMessage());
        serverResponse.setData(params);

        return new ResponseEntity<>(serverResponse, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ServerResponse> notFound(Object params) {
        ServerResponse serverResponse = new ServerResponse();

        serverResponse.setSuccess(ResultEnum.NOT_FOUND.getSuccess());
        serverResponse.setCode(ResultEnum.NOT_FOUND.getCode());
        serverResponse.setMessage(ResultEnum.NOT_FOUND.getMessage());
        serverResponse.setData(params);

        return new ResponseEntity<>(serverResponse, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ServerResponse> serverFault() {
        ServerResponse serverResponse = new ServerResponse();

        serverResponse.setSuccess(ResultEnum.SERVICE_UNAVAILABLE.getSuccess());
        serverResponse.setCode(ResultEnum.SERVICE_UNAVAILABLE.getCode());
        serverResponse.setMessage(ResultEnum.SERVICE_UNAVAILABLE.getMessage());
        serverResponse.setData(null);

        return new ResponseEntity<>(serverResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }
}

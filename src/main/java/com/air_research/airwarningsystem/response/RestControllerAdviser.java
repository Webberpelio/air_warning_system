package com.air_research.airwarningsystem.response;

import com.air_research.airwarningsystem.exception.CommonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author zwell
 */
@RestControllerAdvice(basePackages = "com.air_research.airwarningsystem")
public class RestControllerAdviser implements ResponseBodyAdvice<Object> {

    // type not is ResultMsg type.
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> converterType)
    {
        return !methodParameter.getParameterType().isAssignableFrom(ServerResponse.class);
    }

    // wrapper to ResultMsg
    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response)
    {
        // String类型不能直接包装
        if (returnType.getGenericParameterType().equals(String.class)) {
            return writeString(data);
        }

        // 否则直接包装成ResultMsg返回
        return new ServerResponse<>(data);
    }

    private Object writeString(Object data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.writeValueAsString(new ServerResponse<>(data));
        } catch (JsonProcessingException e) {
            throw new CommonException(ResultEnum.SERVICE_UNAVAILABLE, e.getMessage());
        }
    }
}

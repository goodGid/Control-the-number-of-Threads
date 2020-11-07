package dev.be.goodgid.entity;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto<T> {
    private String returnCode;
    private String returnMessage;
    private Map<String, String> errorDetailMap;
    private Map<String, Object> errorInfo;
    private T info;
}
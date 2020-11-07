package dev.be.goodgid.entity;

import lombok.Data;

@Data
public class RequestDto<T> {
    private T info;
}

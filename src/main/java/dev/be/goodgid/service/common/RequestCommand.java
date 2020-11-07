package dev.be.goodgid.service.common;

public interface RequestCommand<T, R> {

    R process(T request);

    boolean isSuccess(Object result);

}

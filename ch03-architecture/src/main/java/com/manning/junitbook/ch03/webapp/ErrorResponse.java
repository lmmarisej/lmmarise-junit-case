package com.manning.junitbook.ch03.webapp;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 10:44 下午
 */
public class ErrorResponse implements Response {
    private Request originalRequest;
    private Exception originalException;

    public ErrorResponse(Request request, Exception exception) {
        this.originalRequest = request;
        this.originalException = exception;
    }

    public Request getOriginalRequest() {
        return this.originalRequest;
    }

    public Exception getOriginalException() {
        return this.originalException;
    }
}

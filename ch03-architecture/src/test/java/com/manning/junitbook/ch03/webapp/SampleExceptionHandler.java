package com.manning.junitbook.ch03.webapp;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 11:41 下午
 */
public class SampleExceptionHandler implements RequestHandler {
    public Response process(Request request) throws Exception {
        throw new Exception("error processing request");
    }
}
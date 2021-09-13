package com.manning.junitbook.ch03.webapp;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 11:40 下午
 */
public class SampleHandler implements RequestHandler {
    public Response process(Request request) throws Exception {
        return new SampleResponse();
    }
}
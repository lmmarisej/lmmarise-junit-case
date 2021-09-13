package com.manning.junitbook.ch03.webapp;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 10:42 下午
 */
public interface RequestHandler {
    Response process(Request request) throws Exception;
}

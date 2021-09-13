package com.manning.junitbook.ch03.webapp;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 10:41 下午
 */
public interface Controller {
    Response processRequest(Request request);

    void addHandler(Request request, RequestHandler requestHandler);
}

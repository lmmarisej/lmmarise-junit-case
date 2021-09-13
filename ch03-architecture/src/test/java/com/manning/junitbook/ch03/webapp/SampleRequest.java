package com.manning.junitbook.ch03.webapp;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 11:39 下午
 */
public class SampleRequest implements Request {
    private static final String DEFAULT_NAME = "Test";
    private final String name;

    public SampleRequest(String name) {
        this.name = name;
    }

    public SampleRequest() {
        this(DEFAULT_NAME);
    }

    public String getName() {
        return this.name;
    }
}

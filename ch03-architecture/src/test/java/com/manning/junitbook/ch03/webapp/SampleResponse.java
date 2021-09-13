package com.manning.junitbook.ch03.webapp;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 11:41 下午
 */
public class SampleResponse implements Response {
    private static final String DEFAULT_NAME = "Test";
    private final String name;

    public String getName() {
        return this.name;
    }

    public SampleResponse(String name) {
        this.name = name;
    }

    public SampleResponse() {
        this(DEFAULT_NAME);
    }

    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof SampleResponse) {
            result = ((SampleResponse) object).getName().equals(getName());
        }
        return result;
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
package com.manning.junitbook.ch02.suite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 10:15 下午
 */
public class TestCaseA {
    @Test
    public void testA1() {
        assertEquals("Dummy test-case", 1 + 1, 2);
    }
}

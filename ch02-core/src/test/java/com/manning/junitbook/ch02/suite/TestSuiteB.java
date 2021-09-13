package com.manning.junitbook.ch02.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 10:14 下午
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = { TestCaseB.class })
public class TestSuiteB {
}

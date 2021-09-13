package com.manning.junitbook.ch03.webapp;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 11:55 下午
 */
public class HamcrestTest {
    private List<String> values;

    @Before
    public void setUpList() {
        values = new ArrayList<>();
        values.add("x");
        values.add("y");
        values.add("z");
    }

    @Test
    public void testWithoutHamcrest() {
        assertTrue(values.contains("one") || values.contains("two") || values.contains("three"));
    }

    @Test
    public void testWithHamcrest() {
        assertThat(values, JUnitMatchers.hasItem(CoreMatchers.anyOf(CoreMatchers.equalTo("one"),
                CoreMatchers.equalTo("two"),
                CoreMatchers.equalTo("three"))));

        assertThat(values, CoreMatchers.hasItem(CoreMatchers.anyOf(CoreMatchers.equalTo("one"),
                CoreMatchers.equalTo("two"),
                CoreMatchers.equalTo("three"))));
    }
}

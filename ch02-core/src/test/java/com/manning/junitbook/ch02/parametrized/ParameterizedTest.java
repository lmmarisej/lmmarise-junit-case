package com.manning.junitbook.ch02.parametrized;

import com.manning.junitbook.ch02.repeated.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/9/9 9:44 下午
 */
@RunWith(value = Parameterized.class)   // 0 使用 Parameterized 测试运行器 --可以使用不同参数来运行
public class ParameterizedTest {
    private double expected;
    private double valueOne;
    private double valueTwo;

    // 方法签名为固定写法（包括注解），参数为空
    // Collection 长度需要和唯一公共构造参数个数匹配
    @Parameters public static Collection<Integer[]> getTestParameters() {   // 1
        return Arrays.asList(new Integer[][]{
                {2, 1, 1},  //expected, valueOne, valueTwo
                {3, 2, 1},  //expected, valueOne, valueTwo
                {4, 3, 1},  //expected, valueOne, valueTwo
        });
    }

    // 将 Collection 的值从二维转为一维，有三组变量，将执行三次测试
    public ParameterizedTest(double expected, double valueOne, double valueTwo) {   // 2
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sum() {     // 3
        Calculator calc = new Calculator();
        assertEquals(expected, calc.add(valueOne, valueTwo), 0);
    }
}

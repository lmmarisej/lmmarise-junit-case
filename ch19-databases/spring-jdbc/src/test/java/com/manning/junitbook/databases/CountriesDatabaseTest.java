/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package com.manning.junitbook.databases;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.manning.junitbook.databases.dao.CountryDao;
import com.manning.junitbook.databases.model.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class CountriesDatabaseTest {



    @Autowired
    private CountriesLoader countriesLoader;

    @Autowired
    private CountryDao countryDao;

    @Test
    // 保证每个test class的执行上下文的独立性、隔离性
    // method-level:注解设置在test method上的才会生效，默认是AFTER_METHOD。
    // class-level:注解设置在test class上的才会生效，默认是AFTER_CLASS。
    @DirtiesContext // 整个测试类的所有测试执行结束后，该测试的application context会被关闭，同时缓存会清除。
    public void testCountryListStartsWithA() {
        List<Country> countryList = countryDao.getCountryListStartWith("A");
        assertNotNull(countryList);
        assertEquals(expectedCountryListStartsWithA.size(), countryList.size());
        for (int i = 0; i < expectedCountryListStartsWithA.size(); i++) {
            assertEquals(expectedCountryListStartsWithA.get(i), countryList.get(i));
        }
    }


    private List<Country> expectedCountryList = new ArrayList<Country>();
    private List<Country> expectedCountryListStartsWithA = new ArrayList<Country>();

    @BeforeEach
    public void setUp() {
        initExpectedCountryLists();
        countriesLoader.loadCountries();
    }


    @Test
    // 保证每个test class的执行上下文的独立性、隔离性
    // method-level:注解设置在test method上的才会生效，默认是AFTER_METHOD。
    // class-level:注解设置在test class上的才会生效，默认是AFTER_CLASS。
    @DirtiesContext // 整个测试类的所有测试执行结束后，该测试的application context会被关闭，同时缓存会清除。
    public void testCountryList() {
        List<Country> countryList = countryDao.getCountryList();
        assertNotNull(countryList);
        assertEquals(expectedCountryList.size(), countryList.size());
        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i), countryList.get(i));
        }
    }



    private void initExpectedCountryLists() {
        for (int i = 0; i < CountriesLoader.COUNTRY_INIT_DATA.length; i++) {
            String[] countryInitData = CountriesLoader.COUNTRY_INIT_DATA[i];
            Country country = new Country(countryInitData[0], countryInitData[1]);
            expectedCountryList.add(country);
            if (country.getName().startsWith("A")) {
                expectedCountryListStartsWithA.add(country);
            }
        }
    }
}
/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigtable;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Unit tests for {@link HelloAppEngine}.
 */

@RunWith(JUnit4.class)
public class BigtableHelloWorldTest {
  private static final String FAKE_URL = "fake.fk/hello";

  private static BigtableHelper helper;

  @Before
  public void setUp() throws Exception {
    helper = new BigtableHelper();
    helper.contextInitialized(null);
  }

  @After public void tearDown() {

  }

  @Test
  public void bigtable_test() {
    String result = BigtableHelloWorld.doHelloWorld();
    assertThat(result).contains("Write some greetings to the table");
    assertThat(result).contains("Get a single greeting by row key");
    assertThat(result).contains("greeting0= Hello World!");
    assertThat(result).contains("Hello Cloud Bigtable!");
    assertThat(result).contains("Hello HBase!");
  }

}

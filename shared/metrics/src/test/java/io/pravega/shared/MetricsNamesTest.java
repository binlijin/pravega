/**
 * Copyright (c) 2017 Dell Inc., or its subsidiaries. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package io.pravega.shared;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Slf4j
public class MetricsNamesTest {

  @Test
  public void testFailMetricName() {

    assertEquals(null, MetricsNames.failMetricName(null));
    assertEquals("", MetricsNames.failMetricName(""));
    assertEquals("tag_fail", MetricsNames.failMetricName("tag"));
    assertEquals("0_fail", MetricsNames.failMetricName("0"));
    assertEquals("tag1_fail", MetricsNames.failMetricName("tag1"));
    assertEquals("tag.tag_fail", MetricsNames.failMetricName("tag.tag"));
    assertEquals("tag_fail.1", MetricsNames.failMetricName("tag.1"));
    assertEquals("tag.tag1_fail", MetricsNames.failMetricName("tag.tag1"));
    assertEquals("tag1.tag2.tag3_fail", MetricsNames.failMetricName("tag1.tag2.tag3"));
    assertEquals("tag1.tag2_fail.3", MetricsNames.failMetricName("tag1.tag2.3"));
  }

}

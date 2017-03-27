package com.brianway.learning.java8.effective.optional;

import static com.brianway.learning.java8.effective.optional.ReadPositiveIntParam.readDurationImperative;
import static com.brianway.learning.java8.effective.optional.ReadPositiveIntParam.readDurationWithOptional;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

import java.util.Properties;

/**
 * Created by brian on 17/3/27.
 */
public class ReadPositiveIntParamTest {
    @Test
    public void testMap() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDurationImperative(props, "a"));
        assertEquals(0, readDurationImperative(props, "b"));
        assertEquals(0, readDurationImperative(props, "c"));
        assertEquals(0, readDurationImperative(props, "d"));

        assertEquals(5, readDurationWithOptional(props, "a"));
        assertEquals(0, readDurationWithOptional(props, "b"));
        assertEquals(0, readDurationWithOptional(props, "c"));
        assertEquals(0, readDurationWithOptional(props, "d"));
    }

}

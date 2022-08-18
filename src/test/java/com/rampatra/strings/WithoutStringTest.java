package com.rampatra.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WithoutStringTest {
    Method withoutStringMethod;

    @BeforeEach
    void getWithoutStringMethod() throws NoSuchMethodException {
        withoutStringMethod = WithoutString.class.getDeclaredMethod("withoutString", String.class, String.class);
        withoutStringMethod.setAccessible(true);
    }

    @Test
    void testRemoveString() {
        String result = (String) assertDoesNotThrow(() -> withoutStringMethod.invoke(null,"Hello there", "llo"));
        assertEquals("He there", result);
    }

    @Test
    void testRemoveAll() {
        String result = (String) assertDoesNotThrow(() -> withoutStringMethod.invoke(null,"xxx", "x"));
        assertEquals("", result);
    }

    @Test
    void testRemoveNone() {
        String result = (String) assertDoesNotThrow(() -> withoutStringMethod.invoke(null,"xxx", "a"));
        assertEquals("xxx", result);
    }

    @Test
    void testRemoveWithEmptySource() {
        String result = (String) assertDoesNotThrow(() -> withoutStringMethod.invoke(null,"", "a"));
        assertEquals("", result);
    }

    @Test
    void testRemoveWithEmpty() {
        String result = (String) assertDoesNotThrow(() -> withoutStringMethod.invoke(null,"ABC", ""));
        assertEquals("ABC", result);
    }

    @Test
    void testRemoveWithoutCaseSensitive() {
        String result = (String) assertDoesNotThrow(() -> withoutStringMethod.invoke(null,"ABC", "a"));
        assertEquals("BC", result);
    }
}
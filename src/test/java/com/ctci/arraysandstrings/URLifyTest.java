package com.ctci.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class URLifyTest {

    Method urlifyMethod;

    @BeforeEach
    void getWithoutStringMethod() throws NoSuchMethodException {
        urlifyMethod = URLify.class.getDeclaredMethod("urlify", String.class);
        urlifyMethod.setAccessible(true);
    }

    @Test
    void testReplaceASpaceBetween() {
        String result = (String) assertDoesNotThrow(() -> urlifyMethod.invoke(null,  "Mr John Smith    "));
        assertEquals("Mr%20John%20Smith", result);
    }

    @Test
    void testReplaceSpacesBetween() {
        String result = (String) assertDoesNotThrow(() -> urlifyMethod.invoke(null,  "Mr  Ram Patra      "));
        assertEquals("Mr%20%20Ram%20Patra", result);
    }

    @Test
    void testExceptionWhenNotEnoughAccommodateExtraSpace() {
        Exception e = assertThrows(Exception.class, () -> urlifyMethod.invoke(null,  "Mr  Ram Patra"));
        assertEquals("Index -1 out of bounds for length 13", e.getCause().getMessage());
    }

    @Test
    void testExceptionWhenEmptyString() {
        Exception e = assertThrows(Exception.class, () -> urlifyMethod.invoke(null,  ""));
        assertEquals("Index -1 out of bounds for length 0", e.getCause().getMessage());
    }

    @Test
    void testExceptionWhenAllSpacesString() {
        //add comment
        Exception e = assertThrows(Exception.class, () -> urlifyMethod.invoke(null,  "      "));
        assertEquals("Index -1 out of bounds for length 6", e.getCause().getMessage());
    }
}
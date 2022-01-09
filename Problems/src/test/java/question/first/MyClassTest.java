package question.first;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyClassTest {

    private static Date m_time;
    private static String m_name;
    private static ArrayList<Long> m_numbers;
    private static ArrayList<String> m_strings;

    private static MyClass testOne;
    private static MyClass testTwo;
    private static MyClass testThree;

    @BeforeAll
    static void init() {
        m_name = "Test";

        m_time = new Date();

//        m_numbers = (ArrayList<Long>) Arrays.asList(1L, 2L, 3L);
        m_numbers = new ArrayList<>(Arrays.asList(1L, 2L, 3L));

        m_strings = new ArrayList<>(Arrays.asList("Test1", "Test2", "Test3"));

        testOne = new MyClass(m_time, m_name, m_numbers, m_strings);
        testTwo = new MyClass(m_time, m_name, m_numbers, m_strings);
        testThree = testOne;
    }

    @Test
    @DisplayName("Test Case One MyClass.equals()")
    void testEqualsCaseOne() {
        assertEquals(testOne, testTwo);
    }

    @Test
    @DisplayName("Test Case Two MyClass.equals()")
    void testEqualsCaseTwo() {
        assertEquals(testOne, testThree);
    }

    @Test
    @DisplayName("Test Case One MyClass.removeString()")
    void testRemoveStringCaseOne() {
        testOne.removeString("Test1");
        List<String> stringList = testOne.getM_strings();
        assertEquals(stringList.indexOf("Test1"), -1);
    }

    @Test
    @DisplayName("Test Case One MyClass.containsNumber()")
    void testContainsNumberCaseOne() {
        assertTrue(testOne.containsNumber(1));
    }
}

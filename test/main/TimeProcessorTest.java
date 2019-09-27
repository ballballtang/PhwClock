package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeProcessorTest {

    @Test
    void addNormalTime() {
        String result = TimeProcessor.addTime("2019-9-27 18:26", -8);
        assertEquals("2019-09-27 10:26",result);
    }

    @Test
    void addInvalidTime() {
        Throwable exception = assertThrows(RuntimeException.class,()->TimeProcessor.addTime("2019 9 27 18 26", -8));
        assertEquals("The format of new time is wrong!",exception.getMessage());
    }
}
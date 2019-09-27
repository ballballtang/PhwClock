package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhwClockUITest {
    private PhwClockUI cUI;

    @BeforeEach
    void init(){
        cUI = new PhwClockUI();
    }

    @Test
    void changeFirstTime() {
        cUI.changeTime("2019-09-27 00:00");
        assertEquals("2019-09-27 00:00",cUI.phone.getTime(),"FirstTest: The time of phone is wrong.");
        assertEquals("2019-09-27 00:00",cUI.clocks[0].getTime(),"FirstTest: The time of BeiJing is wrong.");
        assertEquals("2019-09-26 16:00",cUI.clocks[1].getTime(),"FirstTest: The time of London is wrong.");
        assertEquals("2019-09-26 20:00",cUI.clocks[2].getTime(),"FirstTest: The time of Moscow is wrong.");
        assertEquals("2019-09-27 02:00",cUI.clocks[3].getTime(),"FirstTest: The time of Sydney is wrong.");
        assertEquals("2019-09-26 11:00",cUI.clocks[4].getTime(),"FirstTest: The time of NewYork is wrong.");
    }

    @Test
    void changeSecondTime() {
        cUI.changeTime("2019-09-27 23:00");
        assertEquals("2019-09-27 23:00",cUI.phone.getTime(),"SecondTest: The time of phone is wrong.");
        assertEquals("2019-09-27 23:00",cUI.clocks[0].getTime(),"SecondTest: The time of BeiJing is wrong.");
        assertEquals("2019-09-27 15:00",cUI.clocks[1].getTime(),"SecondTest: The time of London is wrong.");
        assertEquals("2019-09-27 19:00",cUI.clocks[2].getTime(),"SecondTest: The time of Moscow is wrong.");
        assertEquals("2019-09-28 01:00",cUI.clocks[3].getTime(),"SecondTest: The time of Sydney is wrong.");
        assertEquals("2019-09-27 10:00",cUI.clocks[4].getTime(),"SecondTest: The time of NewYork is wrong.");
    }

    @Test
    void changeThirdTime() {
        Throwable exception = assertThrows(RuntimeException.class,()->cUI.changeTime("2019 09-27 23:00"));
        assertEquals("The format of new time is wrong!",exception.getMessage());

    }
}
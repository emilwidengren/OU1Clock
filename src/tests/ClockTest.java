package tests;

import clock.Clock;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by dv16ewm on 2017-03-28.
 */
public class ClockTest {

    @Test
    public void testCreateClockArgs() throws Exception {

        assertEquals("10:10", new Clock(10,10).getTime());
    }

    @Test
    public void testCreateClockNoArgs() throws Exception {

        assertEquals("00:00", new Clock().getTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateClockInvalidArgs() throws Exception {

        Clock clock = new Clock(25,5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateClockInvalidArgs2() throws Exception {

        Clock clock = new Clock(24, 65);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateClockInvalidArgs3() throws Exception {

        Clock clock = new Clock(25, 65);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateClockInvalidArgs4() throws Exception {

        Clock clock = new Clock(-1, 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateClockInvalidArgs5() throws Exception {

        Clock clock = new Clock(15, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateClockInvalidArgs6() throws Exception {

        Clock alarm = new Clock(-1, -1);
    }

    @Test
    public void testTimeTickMinute() throws Exception {

        Clock clock = new Clock(10,10);
        clock.timeTick();
        assertEquals("10:11", clock.getTime());
    }

    @Test
    public void testTimeTickHour() throws Exception {

        Clock clock = new Clock(19,59);
        clock.timeTick();
        assertEquals("20:00", clock.getTime());
    }

    @Test
    public void testSetTime() throws Exception {

        Clock clock = new Clock();
        clock.setTime(10,10);
        assertEquals("10:10", clock.getTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTimeInvalidArgs() throws Exception {

        Clock clock = new Clock();
        clock.setTime(25,20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTimeInvalidArgs2() throws Exception {

        Clock clock = new Clock();
        clock.setTime(20,65);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTimeInvalidArgs3() throws Exception {

        Clock clock = new Clock();
        clock.setTime(-5,20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTimeInvalidArgs4() throws Exception {

        Clock clock = new Clock();
        clock.setTime(20,-20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTimeInvalidArgs5() throws Exception {

        Clock clock = new Clock();
        clock.setTime(-1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTimeInvalidArgs6() throws Exception {

        Clock clock = new Clock();
        clock.setTime(25,70);
    }

}

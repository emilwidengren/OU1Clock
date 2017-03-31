package tests;

import clockpackage.AlarmClock;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Emil on 2017-03-28.
 */
public class AlarmClockTest {

    @Test
    public void testCreateAlarmClockArgs() throws Exception {

        assertEquals("10:10", new AlarmClock(10,10).getTime());
    }

    @Test
    public void testCreateAlarmClockNoArgs() throws Exception {

        assertEquals("00:00", new AlarmClock().getTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAlarmClockInvalidArgs() throws Exception {

        AlarmClock alarm = new AlarmClock(25,5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAlarmClockInvalidArgs2() throws Exception {

        AlarmClock alarm = new AlarmClock(24, 65);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAlarmClockInvalidArgs3() throws Exception {

        AlarmClock alarm = new AlarmClock(25, 65);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAlarmClockInvalidArgs4() throws Exception {

        AlarmClock alarm = new AlarmClock(-1, 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAlarmClockInvalidArgs5() throws Exception {

        AlarmClock alarm = new AlarmClock(15, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAlarmClockInvalidArgs6() throws Exception {

        AlarmClock alarm = new AlarmClock(-1, -1);
    }

    @Test
    public void testTurnOnAlarm() throws Exception {

        AlarmClock alarm = new AlarmClock();
        assertFalse(alarm.isAlarmActivated());
        alarm.turnOn();
        assertTrue(alarm.isAlarmActivated());

    }

    @Test
    public void testTurnOffAlarm() throws Exception {

        AlarmClock alarm = new AlarmClock();
        assertFalse(alarm.isAlarmActivated());
        alarm.turnOn();
        assertTrue(alarm.isAlarmActivated());
        alarm.turnOff();
        assertFalse(alarm.isAlarmActivated());

    }

    @Test
    public void testSetAlarm() throws Exception {

        AlarmClock alarm = new AlarmClock();
        alarm.setAlarm(10,10);
        alarm.turnOn();
        assertEquals("10:10", alarm.getAlarmSetTime());
    }

    @Test
    public void testTimeTickMinute() throws Exception {

        AlarmClock alarm = new AlarmClock();
        assertEquals("00:00", alarm.getTime());
        alarm.timeTick();
        assertEquals("00:01", alarm.getTime());
    }

    @Test
    public void testTimeTickHour() throws Exception {

        AlarmClock alarm = new AlarmClock(19, 59);
        assertEquals("19:59", alarm.getTime());
        alarm.timeTick();
        assertEquals("20:00", alarm.getTime());
    }

    @Test
    public void testIsTriggered() throws Exception {

        AlarmClock alarm = new AlarmClock(10,0);
        alarm.setAlarm(10,10);
        alarm.turnOn();

        for (int i = 0; i < 10; i++){
            alarm.timeTick();
        }

        assertTrue(alarm.isTriggered());
    }

}

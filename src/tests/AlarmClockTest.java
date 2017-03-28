package tests;

import clock.AlarmClock;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Emil on 2017-03-28.
 */
public class AlarmClockTest {

    @Test
    public void testCreateAlarmClock(){
        assertEquals("10:10", new AlarmClock(10,10).getTime());
    }

    @Test
    public void testTurnOnAlarm() {
        AlarmClock alarm = new AlarmClock();
        alarm.turnOn();

    }
}

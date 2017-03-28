package clock;

/**
 * Created by dv16ewm on 2017-03-27.
 */
public class AlarmClock extends Clock {

    private NumberDisplay alarmsHours = new NumberDisplay(0,60);
    private NumberDisplay alarmMinutes = new NumberDisplay(0,60);
    private boolean alarmActivated;

    /**
     * Testing
     */
    public AlarmClock() {
    }

    public AlarmClock(int hour, int minute) {
        super(hour, minute);
    }

    public void setAlarm(int hour, int minute) {
        alarmsHours.setValue(hour);
        alarmMinutes.setValue(minute);
    }

    public boolean isTriggered() {
        if (alarmActivated)
            if (getTime().equals(alarmsHours.getDisplayValue() + ":" + alarmMinutes.getDisplayValue())) {
                System.out.println("RING RING");
                return true;
            }
        System.out.println(getTime());
            return false;
    }

    public void turnOn() {
        alarmActivated = true;
    }

    public void turnOff() {
        alarmActivated = false;
    }
}

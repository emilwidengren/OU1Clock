package clockpackage;

/**
 * Created by dv16ewm on 2017-03-27.
 */
public class AlarmClock extends Clock {

    private NumberDisplay alarmsHours = new NumberDisplay(0,24);
    private NumberDisplay alarmMinutes = new NumberDisplay(0,60);
    private boolean alarmActivated;
    private boolean alarmIsRinging;


    public AlarmClock() {

        super();

    }

    public AlarmClock(int hour, int minute) {

        super(hour, minute);

    }

    public void setAlarm(int hour, int minute) {

        alarmsHours.setValue(hour);
        alarmMinutes.setValue(minute);
    }

    public boolean isTriggered() {

        if (alarmActivated) {
            if (getTime().equals(alarmsHours.getDisplayValue() + ":" + alarmMinutes.getDisplayValue())) {

                alarmIsRinging = true;
                System.out.println("Alarm");
                return true;
            }

            if (alarmIsRinging) {
                System.out.println("Alarm");
                return true;
            }
        }

        return false;
    }

    public void turnOn() {

        alarmActivated = true;
    }

    public void turnOff() {

        alarmIsRinging = false;
        alarmActivated = false;
    }

    public boolean isAlarmActivated() {

        if (alarmActivated)
            return true;
        return false;
    }

    public String getAlarmSetTime() {

        if (alarmActivated)
            return alarmsHours.getDisplayValue() + ":" + alarmMinutes.getDisplayValue();

        else {
            return "Alarm is not set";
        }

    }

    public boolean isAlarmIsRinging() {
        if (alarmIsRinging)
            return true;
        return false;
    }
}

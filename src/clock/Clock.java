package clock;

/**
 * Created by dv16ewm on 2017-03-25.
 */
public class Clock {

    private NumberDisplay hours = new NumberDisplay(0,24);
    private NumberDisplay minutes = new NumberDisplay(0,60);
    private String displayString;

    public Clock() {

        updateDisplay();
    }

    public Clock(int hour, int minute) {

        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    public void timeTick() {

        minutes.increment();

        if (minutes.didWrapAround()){

            hours.increment();
        }
    }

    public void setTime(int hour, int minute) {

        hours.setValue(hour);
        minutes.setValue(minute);
    }

    public String getTime() {

        updateDisplay();
        return displayString;
    }

    private void updateDisplay() {

        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
    }
}

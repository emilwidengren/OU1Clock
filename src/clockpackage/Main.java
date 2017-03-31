package clockpackage;

/**
 * Created by dv16ewm on 2017-03-27.
 */
public class Main {
    public static void main(String[] args){

        AlarmClock AlarmClockOne = new AlarmClock(0,0);
        AlarmClockOne.setTime(23,47);
        AlarmClockOne.turnOn();
        AlarmClockOne.setAlarm(7,15);

        while (!AlarmClockOne.isTriggered()){

            AlarmClockOne.timeTick();
        }
    }
}

package clockpackage;

/**
 * Created by dv16ewm on 2017-03-27.
 */
public class Main {
    public static void main(String[] args){

        AlarmClock AlarmClockOne = new AlarmClock(0,0);
        AlarmClockOne.setTime(2,0);
        AlarmClockOne.turnOn();
        AlarmClockOne.setAlarm(2,15);

        /*while (!AlarmClockOne.isTriggered()) {

            AlarmClockOne.timeTick();
        }

            while (AlarmClockOne.isAlarmIsRinging()) {

                AlarmClockOne.isTriggered();
                AlarmClockOne.timeTick();

            }*/

        for (int i = 0; i < 60; i++) {
            AlarmClockOne.isTriggered();
            AlarmClockOne.timeTick();

            if (AlarmClockOne.isAlarmIsRinging()) {
                AlarmClockOne.turnOff();
            }
        }

    }
}


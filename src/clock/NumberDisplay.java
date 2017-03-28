package clock;

import java.text.DecimalFormat;

/**
 * Created by dv16ewm on 2017-03-25.
 */
public class NumberDisplay {

    private int minLimit;
    private int maxLimit;
    private int value;
    private DecimalFormat decFormat;
    private boolean didWrapAround;

    public NumberDisplay(int minLimit, int maxLimit){
        if (minLimit > maxLimit) {
            throw new IllegalArgumentException("minLimit must be lower than maxLimit");
        }

        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        value = minLimit;

        String maxString = String.valueOf(maxLimit);
        String format = "";

        for (int i = 0; i < maxString.length(); i++)
            format += "0";

        decFormat = new DecimalFormat(format);

    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        if (value >= minLimit && value < maxLimit-1)
            this.value = value;

        else throw new IllegalArgumentException("value must be higher or equal to minLimit AND " +
                "lower than maxLimit - 1");
    }

    public String getDisplayValue(){
        return decFormat.format(value);
    }

    public void increment(){
        value++;

        didWrapAround = false;

        if (value == maxLimit)
        {
            value = minLimit;
            didWrapAround = true;
        }
    }

    public boolean didWrapAround(){
        return didWrapAround;
    }

}

package tests;

import clock.NumberDisplay;
import junit.framework.Assert;
import org.junit.Test;

import java.util.IllegalFormatException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by dv16ewm on 2017-03-25.
 */
public class NumberDisplayTest {

    @Test
    public void testCreateNumberDisplay() throws Exception {

        new NumberDisplay(0, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberDisplayError() throws Exception {

        new NumberDisplay(20, 10);
    }

    @Test
    public void testCreateFormat() throws Exception {

        assertEquals("10", new NumberDisplay(10, 20).getDisplayValue());
        assertEquals("00", new NumberDisplay(0, 20).getDisplayValue());
        assertEquals("111", new NumberDisplay(111, 200).getDisplayValue());
        assertEquals("010", new NumberDisplay(10,200).getDisplayValue());
    }

    @Test
    public void testCreateFormatError() throws Exception {

        assertNotSame("10", new NumberDisplay(10, 200).getDisplayValue());
        assertNotSame("010", new NumberDisplay(10, 20).getDisplayValue());
    }

    @Test
    public void testSetValue() throws Exception {

        NumberDisplay display = new NumberDisplay(0,60);
        display.setValue(45);
        assertEquals("45", display.getDisplayValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueError() throws Exception {

        NumberDisplay display = new NumberDisplay(0,60);
        display.setValue(70);
    }

    @Test
    public void testGetValue() throws Exception {

        NumberDisplay display = new NumberDisplay(0,60);
        display.setValue(45);
        assertEquals(45, display.getValue());
    }

    @Test
    public void testGetValueError() throws Exception {

        NumberDisplay display = new NumberDisplay(10,60);
        assertThat(20,is(not(display.getValue())));
    }

    @Test
    public void testGetDisplayValue() throws Exception {

        NumberDisplay display = new NumberDisplay(0,60);
        display.setValue(45);
        assertEquals("45", display.getDisplayValue());
    }

    @Test
    public void testIncrement() throws Exception {

        NumberDisplay display = new NumberDisplay(10,20);
        display.increment();
        assertEquals(11, display.getValue());
    }

    @Test
    public void testDidWrapAround() throws Exception {

        NumberDisplay display = new NumberDisplay(58,60);
        display.increment();
        display.increment();
        assertEquals(display.didWrapAround(), true);
        assertEquals(display.getValue(), 58);
    }
}


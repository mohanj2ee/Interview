package com.ubs.opsit.interviews;

import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.junit.Assert.*;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You need to
 * edit this class to complete the exercise.
 */
public class BerlinClockFixture {

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @Test
    //Verify that 00:00:00 clock should look like
    public void testTopBottomHoursAndMinutesAndSecondsZero(){
        assertEquals("Y", berlinClock.getSeconds(0));
        assertEquals("OOOO", berlinClock.getTopHours(0));
        assertEquals("OOOO", berlinClock.getBottomHours(0));
        assertEquals("OOOOOOOOOOO", berlinClock.getTopMinutes(0));
        assertEquals("OOOO", berlinClock.getBottomMinutes(0));
    }

    @Test
    //Verify that 13:17:01 clock should look like
    public void testTopBottomHours13AndMinutes17AndSeconds1(){
        assertEquals("O", berlinClock.getSeconds(1));
        assertEquals("RROO", berlinClock.getTopHours(10));
        assertEquals("RRRO", berlinClock.getBottomHours(3));
        assertEquals("YYROOOOOOOO", berlinClock.getTopMinutes(15));
        assertEquals("YYOO", berlinClock.getBottomMinutes(2));
    }

    @Test
    //Verify that 23:59:59 clock should look like
    public void testTopBottomHours23AndMinutes59AndSeconds59(){
        assertEquals("O", berlinClock.getSeconds(59));
        assertEquals("RRRR", berlinClock.getTopHours(20));
        assertEquals("RRRO", berlinClock.getBottomHours(3));
        assertEquals("YYRYYRYYRYY", berlinClock.getTopMinutes(55));
        assertEquals("YYYY", berlinClock.getBottomMinutes(4));
    }

    @Test
    //Verify that 24:00:00 clock should look like
    public void testTopBottomHours24AndMinutesAndSecondsZero(){
        assertEquals("Y", berlinClock.getSeconds(0));
        assertEquals("RRRR", berlinClock.getTopHours(20));
        assertEquals("RRRR", berlinClock.getBottomHours(4));
        assertEquals("OOOOOOOOOOO", berlinClock.getTopMinutes(0));
        assertEquals("OOOO", berlinClock.getBottomMinutes(0));
    }
}
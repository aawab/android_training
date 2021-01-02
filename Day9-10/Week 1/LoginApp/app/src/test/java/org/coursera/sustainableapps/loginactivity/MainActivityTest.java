package org.coursera.sustainableapps.loginactivity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainActivityTest {

    private final MainActivity activity = new MainActivity();


    /**
     * Verifies requirement 8 along with following Test
     * @throws Exception
     */
    @Test
    public void isValidEmailAddressPassed() throws Exception{
        assertTrue(activity.isValidEmail("tester@test.com"));
        assertFalse(activity.isValidEmail("tester@test"));
        assertFalse(activity.isValidEmail("@gmail.com"));
        assertFalse(activity.isValidEmail("charlow@gm"));
    }

    /**
     * Verifies requirement 9
     * @throws Exception
     */
    @Test
    public void isValidEmailAddressFailed() throws Exception{
        assertFalse(activity.isValidEmail("invalidisinvalidemail"));
    }

    /**
     * Verifies allCharSame method works along with following Test
     * @throws Exception
     */
    @Test
    public void allCharSamePassed() throws Exception{
        assertTrue(activity.allCharSame("          "));
    }

    @Test
    public void allCharSameFailed() throws Exception{
        assertFalse(activity.allCharSame("pranjal023223"));
    }

    /**
     * Verifies requirement 11
     * @throws Exception
     */
    @Test
    public void checkValidPasswordPassed() throws Exception{
        assertEquals("Login success!",activity.checkValidPassword("pranjal12345"));
    }

    /**
     * Verifies requirement 6
     * @throws Exception
     */
    @Test
    public void checkValidPasswordShort() throws Exception{
        assertEquals("The provided password is too short",activity.checkValidPassword(
                "pranjl"));
    }

    /**
     * Verifies requirement 7
     * @throws Exception
     */
    @Test
    public void checkValidPasswordInvalid() throws Exception{
        assertEquals("The provided password is invalid",activity.checkValidPassword(
                "              "));
    }
}
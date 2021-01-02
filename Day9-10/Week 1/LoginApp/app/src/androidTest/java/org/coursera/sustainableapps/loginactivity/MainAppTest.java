package org.coursera.sustainableapps.loginactivity;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainAppTest {
    final Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

    /**
     * Verifies requirement 4
     * @throws Exception
     */
    @Test
    public void hasButtonTest() throws Exception{
        assertEquals("org.coursera.sustainableapps.loginactivity:id/button",
                appContext.getResources().getResourceName(R.id.button));
        assertEquals("Login",appContext.getResources().getString(R.string.button_name));
    }

    /**
     * Verifies requirement 1
     * @throws Exception
     */
    @Test
    public void hasEmailEntry() throws Exception{
        assertEquals("org.coursera.sustainableapps.loginactivity:id/emailInput",appContext.
                getResources().getResourceName(R.id.emailInput));
    }

    /**
     * Verifies requirement 2
     * @throws Exception
     */
    @Test
    public void hasPasswordEntry() throws Exception{
        assertEquals("org.coursera.sustainableapps.loginactivity:id/passInput",appContext.
                getResources().getResourceName(R.id.passInput));
    }

}
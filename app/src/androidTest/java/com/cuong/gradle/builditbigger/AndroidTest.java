package com.cuong.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import com.example.JokeSupplier;

import java.util.concurrent.ExecutionException;
/**
 * Created by Cuong on 8/6/2015.
 */
public class AndroidTest extends AndroidTestCase {
    public void testGetJoke(){
        String s = (new JokeSupplier()).getAJoke();
        Log.d("Test joke supplier lib", s);
        assertNotNull("Not getting any joke from the lib!", s);

        try {
            String joke = new EndPointsAsyncTask(this.getContext(), null, true).execute("give me the joke").get();

            assertNotNull("Not getting any joke from the gce!", joke);

            assertTrue("Exception in Async!", !joke.startsWith("EXCEPTION"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

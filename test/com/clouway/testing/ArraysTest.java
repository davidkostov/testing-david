package com.clouway.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class ArraysTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream stdout = System.out;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStream() {
        System.setOut(stdout);
    }

    @Test
    public void printArrayWorks(){
        new Array(new Integer[] {-1,2,-5,7,0}).printArray();
        assertEquals("-1, 2, -5, 7, 0", outContent.toString());
    }

    @Test
    public void getSumWorks(){
        assertThat(new Array(new Integer[] {-1,2,-5,7,0}).getSum(),
                equalTo(3));
    }

    @Test
    public void getMinElementWorks(){
        assertThat(new Array(new Integer[] {-1,2,-5,7,0}).getMinElement(),
                equalTo(-5));
    }
}

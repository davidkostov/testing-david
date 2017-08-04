package com.clouway.testing;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class SumatorTest {

    @Test
    public void sumTwoNumbers(){
        assertThat(new Sumator("").sum("2","3"), is(equalTo("5")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInvalidCharArguments(){
        new Sumator("").sum("x", "5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNullArgument(){
        new Sumator("").sum(null, "5");
    }

}

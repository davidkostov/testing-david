package com.clouway.mocks;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class FilterWithKeywordTests {

    @Test
    public void keywordMatches(){
        assertTrue(new EndpointFilter(new StartsWithKeyword("add")).shouldFilter("address"));
    }

    @Test
    public void keywordDoesNotMatch(){
        assertFalse(new EndpointFilter(new StartsWithKeyword("dda")).shouldFilter("address"));
    }

}

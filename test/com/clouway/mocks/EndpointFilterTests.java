package com.clouway.mocks;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class EndpointFilterTests {

    @Rule
    public JUnitRuleMockery mockery = new JUnitRuleMockery();

    @Test
    public void firstEndpointMatches(){
        final Endpoint endpoint1 = mockery.mock(Endpoint.class);
        final Endpoint endpoint2 = mockery.mock(Endpoint.class,"endpoint2");
        EndpointFilter filter = new EndpointFilter(endpoint1, endpoint2);

        mockery.checking(new Expectations(){{
            oneOf(endpoint1).matches("address");
            will(returnValue(true));
        }});

        assertTrue(filter.shouldFilter("address"));
    }

    @Test
    public void secondEndpointMatches(){
        final Endpoint endpoint1 = mockery.mock(Endpoint.class);
        final Endpoint endpoint2 = mockery.mock(Endpoint.class,"endpoint2");
        EndpointFilter filter = new EndpointFilter(endpoint1, endpoint2);

        mockery.checking(new Expectations(){{
            oneOf(endpoint1).matches("address");
            will(returnValue(false));
            oneOf(endpoint2).matches("address");
            will(returnValue(true));
        }});

        assertTrue(filter.shouldFilter("address"));
    }

    @Test
    public void noEndpointsMatch(){
        final Endpoint endpoint1 = mockery.mock(Endpoint.class);
        final Endpoint endpoint2 = mockery.mock(Endpoint.class,"endpoint2");
        EndpointFilter filter = new EndpointFilter(endpoint1, endpoint2);

        mockery.checking(new Expectations(){{
            oneOf(endpoint1).matches("address");
            will(returnValue(false));
            oneOf(endpoint2).matches("address");
            will(returnValue(false));
        }});

        assertFalse(filter.shouldFilter("address"));
    }

    @Test
    public void noEndpointsDetected(){
        EndpointFilter filter = new EndpointFilter();
        assertFalse(filter.shouldFilter("address"));
    }

}

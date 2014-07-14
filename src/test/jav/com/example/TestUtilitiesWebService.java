package com.example;

import static org.junit.Assert.*;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUtilitiesWebService
{

    private WebTarget target;

    @Before
    public void setUp() throws Exception
    {
        Client c = ClientBuilder.newClient();
        target = c.target(getBaseURI());
    }

    private static URI getBaseURI()
    {
        return UriBuilder.fromUri("http://localhost:8082/webapi/").build();
    }

    @After
    public void tearDown() throws Exception
    {
        target = null;
    }

    @Test
    public void testTempInFahrenheit()
    {

        Float tempInCelcius = target.path("utilities/celciusToFahrenheit/26").request().get(Float.class);

        Assert.assertEquals(78.8, tempInCelcius.byteValue(), 1);

    }

    @Test
    public void testFahrenheitToTemp()
    {

        Integer tempInFahrenheit = target.path("utilities/fahrenheitToCelcius/98.6").request().get(Integer.class);

        Assert.assertEquals(37, tempInFahrenheit.intValue(), 1);

    }

}

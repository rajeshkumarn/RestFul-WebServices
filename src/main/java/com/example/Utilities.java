package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "utilities" path)
 */
@Path("utilities")
public class Utilities
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("celciusToFahrenheit/{tempInCelcius}")
    public float celciusToFahrenheit(@PathParam("tempInCelcius") int tempInCelcius)
    {
        return ((float) tempInCelcius * 9 / 5) + 32;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("fahrenheitToCelcius/{tempInFahrenheit}")
    public int FahrenheitToCelcius(@PathParam("tempInFahrenheit") float tempInFahrenheit)
    {
        return (int) ((tempInFahrenheit - 32) * 5 / 9);
    }
}

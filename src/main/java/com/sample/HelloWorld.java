package com.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class HelloWorld {

    // Para puxar uma config. definida em application.properties
    //@ConfigProperty(name="mensagem.parte1")
    String msg1 = "Hello again.";
    String msg2 = "Welcome to your new playground.";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return msg1 + " " + msg2;
    }
    
}
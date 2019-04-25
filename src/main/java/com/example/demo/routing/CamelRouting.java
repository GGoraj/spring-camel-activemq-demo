package com.example.demo.routing;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouting extends RouteBuilder {
    @Override
    public void configure() throws Exception {


        /**
         **  Where the Camel magic happens and EIP are boring simple
         **/

        //queueing
        from("file:data/input?noop=true").to("activemq:queue:qdata");

        //dequeuing
        from("activemq:qdata").to("file:data/output");

    }

}

package com.my.learning.webflux;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

public class SpringWebfluxApplication {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(WebFluxConfig.class);
        HttpHandler httpHandler = WebHttpHandlerBuilder.applicationContext(applicationContext).build();
        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer.create().host("localhost").port(8080).handle(httpHandlerAdapter).bind().block();
        System.in.read();
    }
}

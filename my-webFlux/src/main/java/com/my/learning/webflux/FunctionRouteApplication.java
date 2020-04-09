package com.my.learning.webflux;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class FunctionRouteApplication {

    public static void main(String[] args) throws IOException {
        HttpHandler httpHandler = toHttpHandler(
                route(GET("/selectStudent").and(accept(MediaType.APPLICATION_JSON_UTF8)), StudentHandler::selectStudent).
                        and(route(GET("/saveStudent"), StudentHandler::insertStudent)));
        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer.create().host("localhost").port(8080).handle(httpHandlerAdapter).bind().block();
        System.in.read();
    }
}

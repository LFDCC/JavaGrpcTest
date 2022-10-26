package com.example.demo.controller;

import com.example.demo.greet.Greet;
import com.example.demo.greet.GreeterGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GrpcClient("GLOBAL")
    private GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    @GetMapping(path = {"/", "/hello"})
    public String Hello(String name) {
        Greet.HelloRequest request = Greet.HelloRequest.newBuilder()
                .setName(name)
                .build();
        String msg = greeterBlockingStub.sayHello(request).getMessage();
        return msg;
    }
}

package com.soap.testsoap.controllers;

import com.soap.testsoap.api.AddResponse;
import com.soap.testsoap.service.SendRequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallWSController {

    SendRequestService service;

    public CallWSController(SendRequestService service) {
        this.service = service;
    }

    @GetMapping("/call")
    public AddResponse call(){
        String url = "http://www.dneonline.com/calculator.asmx";
        return service.callAddService(url);

    }
}

package com.soap.testsoap.service;

import com.soap.testsoap.api.Add;
import com.soap.testsoap.api.AddResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;

@Service
public class SendRequestService {

    WebServiceTemplate webServiceTemplate;

    public SendRequestService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public AddResponse callAddService(String url){
        Add request = new Add();
        request.setIntA(100);
        request.setIntB(200);
        return (AddResponse) webServiceTemplate.marshalSendAndReceive(url, request,
                message -> {
                    if (message instanceof SoapMessage soapMessage) {
                        // Set the SOAPAction header
                        soapMessage.setSoapAction("http://tempuri.org/Add"); // Replace with your WSDL's SOAPAction
                    }
                });
    }
}

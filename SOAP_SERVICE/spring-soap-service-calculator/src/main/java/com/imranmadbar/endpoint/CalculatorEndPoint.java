package com.imranmadbar.endpoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.imranmadbar.soap.bindings.AdditionInput;
import com.imranmadbar.soap.bindings.DivisionInput;
import com.imranmadbar.soap.bindings.MultiplicationInput;
import com.imranmadbar.soap.bindings.ObjectFactory;
import com.imranmadbar.soap.bindings.Output;
import com.imranmadbar.soap.bindings.SubtractionInput;

@Endpoint
public class CalculatorEndPoint {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponsePayload
    @PayloadRoot(namespace = "http://imranmadbar.com/types/calculator", localPart = "AdditionInput")
    public Output addition(@RequestPayload AdditionInput input){
        logger.info("Request received for addition with input "+input);
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://imranmadbar.com/types/calculator", localPart = "SubtractionInput")
    public Output subtraction(@RequestPayload SubtractionInput input){
        logger.info("Request received for addition with input "+input);
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() - input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://imranmadbar.com/types/calculator", localPart = "MultiplicationInput")
    public Output multiplication(@RequestPayload MultiplicationInput input){
        logger.info("Request received for addition with input "+input);
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() * input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://imranmadbar.com/types/calculator", localPart = "DivisionInput")
    public Output division(@RequestPayload DivisionInput input){
        logger.info("Request received for addition with input "+input);
        if(input.getNumber2() == 0){
            throw new IllegalArgumentException("Divisor can't be null");
        }
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
    }
}
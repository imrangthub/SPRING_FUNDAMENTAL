package com.imranmadbar.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imranmadbar.domain.request.login.Request;
import com.imranmadbar.domain.response.login.LoginResponse;
import com.imranmadbar.repository.client.MyFeignClient;
import com.imranmadbar.util.MyUtils;
import lombok.RequiredArgsConstructor;
import com.imranmadbar.domain.request.categories.ExecuteScript;
import com.imranmadbar.domain.request.categories.ExecuteScriptRequest;
import com.imranmadbar.domain.request.categories.Item;
import com.imranmadbar.domain.request.categories.Parameters;
import com.imranmadbar.domain.request.login.Body;
import com.imranmadbar.domain.request.login.Login;
import com.imranmadbar.domain.response.categories.CategoryResponse;
import com.imranmadbar.domain.response.categories.ExecuteScriptResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemService {

    @Value("${backEndNode.username}")
    private String username;

    @Value("${backEndNode.password}")
    private String password;

    private static Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    private final MyFeignClient cmClient;

    public LoginResponse login() {

        LOGGER.info("Login Method call");

        String soapRequestString = convertSoapRequestToXmlString(this.loginRequest());

        String soapResponseString = cmClient.doRequest(soapRequestString);

        return this.convertSoapResponseFromString(soapResponseString);
    }

    public CategoryResponse getCategories(String msisdn, String channel) {

        LOGGER.info("Get Catagory claa");

        String soapRequestString = convertSoapRequestToXmlString(this.prepareCategoriesRequest(msisdn, channel));
        String soapResponseString = cmClient.doRequest(soapRequestString);
        ExecuteScriptResponse response = this.convertSoapResponseFromStringForCategories(soapResponseString);

        return mapCategoryResponse(response.getBody().getExecuteScriptResponseStruct().getOutput());

    }

    public CategoryResponse mapCategoryResponse(String response) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response, CategoryResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

  private String convertSoapRequestToXmlString(Object request) {
        try {
            return MyUtils.convertObjectToXml(request);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private LoginResponse convertSoapResponseFromString(String responseString) {
        try {
            return MyUtils.convertXmlToObject(responseString, LoginResponse.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private ExecuteScriptResponse convertSoapResponseFromStringForCategories(String responseString) {
        try {
            return MyUtils.convertXmlToObject(responseString, ExecuteScriptResponse.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private Request loginRequest(){
        Login login = new Login();
        login.setPassword(password);
        login.setUsername(username);
        Body body = new Body();
        body.setLogin(login);

        Request xmlRequest = new Request();
        xmlRequest.setBody(body);

        return xmlRequest;
    }



    private ExecuteScriptRequest prepareCategoriesRequest(String msisdn, String channel){

        LOGGER.info("prepareCategoriesRequest method call");


        ExecuteScriptRequest request = new ExecuteScriptRequest();
        com.imranmadbar.domain.request.categories.Body body = new com.imranmadbar.domain.request.categories.Body();
        ExecuteScript script = new ExecuteScript();
        Parameters parameters = new Parameters();
        List<Item> items = new ArrayList<>();
        Item item1 = new Item();
        item1.setField("MSISDN");
        item1.setValue(msisdn);

        Item item2 = new Item();
        item2.setField("channel");
        item2.setValue(channel);

        items.add(item1);
        items.add(item2);

        parameters.setItems(items);

        script.setPParameters(parameters);
        script.setPIncludeName("listCategories");
        script.setPSessionKey(login().getBody().getLoginResponseStruct().getSessionKey());

        body.setExecuteScript(script);
        request.setBody(body);
        return request;


    }






}

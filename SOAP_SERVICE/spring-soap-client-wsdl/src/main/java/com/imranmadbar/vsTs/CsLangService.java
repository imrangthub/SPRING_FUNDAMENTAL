package com.imranmadbar.vsTs;

import java.io.StringReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class CsLangService extends WebServiceGatewaySupport {

  public static final String SMS_LANGUAGE = "SMSLanguage";
  public static final String FAIL_CLAUSE = "0";

  private String version = "2.0";

  private String service = "selfCare";

  private String userId = "apiHub";

  private String password = "aPIhUb@1";

  private JAXBElement callWebService(Object request) {

    return (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(request);
  }

  public List<Item> getSMSLang(VasServiceRequest vasServiceRequest) {
    return process(SMS_LANGUAGE, vasServiceRequest);
  }


  private List<Item> process(String method, VasServiceRequest vasServiceRequest) {

    OpManager opManager = new OpManager();
    opManager.setVersion(version);
    opManager.setService(service);
    opManager.setMethod(method);
    opManager.getParam().add(vasServiceRequest.getMsisdn());
    opManager.setNumberofparam(1);
    opManager.setUserid(userId);
    opManager.setPassword(password);
    opManager.setFailclause(FAIL_CLAUSE);

    ItemRoot itemRoot;
    JAXBElement<OpManager> opManagerJAXBElement = new ObjectFactory().createOpManager(opManager);
    System.out.println("########ReqParam_opManagerJAXBElement: "+opManagerJAXBElement.getValue());
    
    OpManagerResponse opManagerResponse =
        (OpManagerResponse) callWebService(opManagerJAXBElement).getValue();
    System.out.println("########Response_opManagerResponse: "+opManagerResponse.toString());
    try {

      JAXBContext jaxbContext = JAXBContext.newInstance(ItemRoot.class);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      String withRootItem = "<items>" + opManagerResponse.getReturn() + "</items>";
      itemRoot = (ItemRoot) unmarshaller.unmarshal(new StringReader(withRootItem));

    } catch (JAXBException e) {

      e.printStackTrace();

      throw new RuntimeException("Service error.", e);
    }

    return itemRoot.getItems();
  }
}

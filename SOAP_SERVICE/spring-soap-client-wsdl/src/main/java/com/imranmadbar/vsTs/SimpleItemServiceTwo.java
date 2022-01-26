package com.imranmadbar.vsTs;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SimpleItemServiceTwo extends WebServiceGatewaySupport {

	public static final String XXXXX = "xxxxx";
	public static final String XXXXXXX = "0";

	private String version = "2.0";

	private String service = "xx";

	private String userId = "xx";

	private String password = "xxxxx";

	private JAXBElement callWebService(Object request) {

		return (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(request);
	}

	public List<Item> getItemLang(SimpleItemServiceRequest vasServiceRequest) {
		return process(XXXXX, vasServiceRequest);
	}

	private List<Item> process(String method, SimpleItemServiceRequest vasServiceRequest) {

		OpManager opManager = new OpManager();
		opManager.setVersion(version);
		opManager.setService(service);
		opManager.setMethod(method);
		opManager.getParam().add(vasServiceRequest.getMsisdn());
		opManager.setNumberofparam(1);
		opManager.setUserid(userId);
		opManager.setPassword(password);
		opManager.setFailclause(XXXXXXX);

		ItemRoot itemRoot;
		JAXBElement<OpManager> opManagerJAXBElement = new ObjectFactory().createOpManager(opManager);
		System.out.println("########ReqParam_opManagerJAXBElement: " + opManagerJAXBElement.getValue());

		OpManagerResponse opManagerResponse = (OpManagerResponse) callWebService(opManagerJAXBElement).getValue();
		System.out.println("########Response_opManagerResponse: " + opManagerResponse.toString());
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

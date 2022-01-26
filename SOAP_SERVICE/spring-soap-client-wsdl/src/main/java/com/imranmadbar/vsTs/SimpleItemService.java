package com.imranmadbar.vsTs;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SimpleItemService extends WebServiceGatewaySupport {

	public static final String XXXX = "xxxxx";
	public static final String XXXXX = "xxxxxx";
	public static final String XXXXXX = "0";

	private String version = "2.0";

	private String service = "xxxxxxxx";

	private String userId = "xxxxxx";

	private String password = "xxxxxx";

	private JAXBElement callWebService(Object request) {

		return (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(request);
	}

	public List<Item> getSimpleItem(SimpleItemServiceRequest vasServiceRequest) {

		return process(XXXX, vasServiceRequest);
	}

	public List<Item> findSimpleItem(SimpleItemServiceRequest vasServiceRequest) {

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
		opManager.setFailclause(XXXXXX);

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

			throw new RuntimeException("Soap Serice Error.", e);
		}

		return itemRoot.getItems();
	}
}

package com.imranmadbar.vsTs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
	private static final QName _Hello_QNAME = new QName("http://inhouse.productandservice/", "hello");
	private static final QName _HelloResponse_QNAME = new QName("http://inhouse.productandservice/", "helloResponse");
	private static final QName _OpManager_QNAME = new QName("http://inhouse.productandservice/", "opManager");
	private static final QName _OpManagerResponse_QNAME = new QName("http://inhouse.productandservice/",
			"opManagerResponse");

	public ObjectFactory() {
	}

	public OpManager createOpManager() {
		return new OpManager();
	}

	public OpManagerResponse createOpManagerResponse() {
		return new OpManagerResponse();
	}

	public JAXBElement<OpManager> createOpManager(OpManager value) {
		return new JAXBElement(_OpManager_QNAME, OpManager.class, (Class) null, value);
	}

	@XmlElementDecl(namespace = "http://inhouse.productandservice/", name = "opManagerResponse")
	public JAXBElement<OpManagerResponse> createOpManagerResponse(OpManagerResponse value) {
		return new JAXBElement(_OpManagerResponse_QNAME, OpManagerResponse.class, (Class) null, value);
	}
}

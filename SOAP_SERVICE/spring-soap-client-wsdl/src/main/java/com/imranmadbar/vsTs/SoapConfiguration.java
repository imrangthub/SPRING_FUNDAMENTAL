package com.imranmadbar.vsTs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

@Configuration
public class SoapConfiguration {

  //  @Value("${abbl.cbs.api.connect.package}")
  private String connectContextPath = "com.imranmadbar.vsTs";

  // @Value("${abbl.cbs.api.connect.uri}")
  private String connectUrl = "http://172.16.8.132:6695/iProvision/iProvision";

  @Bean
  public VasService connectClient() {

    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath(connectContextPath);

    VasService client = new VasService();
    client.setDefaultUri(connectUrl);
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    // client.setMessageFactory(messageFactory());

    return client;
  }
  
  @Bean
  public CsLangService getSmSLangConnectionClient() {

    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath(connectContextPath);
    CsLangService client = new CsLangService();
    client.setDefaultUri(connectUrl);
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);

    return client;
  }

  public SaajSoapMessageFactory messageFactory() {
    SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
    messageFactory.setSoapVersion(SoapVersion.SOAP_12);
    messageFactory.afterPropertiesSet();
    return messageFactory;
  }
}

# SPRING_FUNDAMENTAL



SPRING SOAP SERVICE
========================================================================



http://localhost:8080/user-soap-service/user.wsdl

http://localhost:8080/imranmadbar/ws/calculatorDemo.wsdl



Simple Soap Request:
--------------------------------------

            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
            xmlns:cal="http://imranmadbar.com/types/calculator">
                        <soapenv:Header/>
                        <soapenv:Body>
                                    <cal:SubtractionInput>
                                                <cal:number1>10</cal:number1>
                                                <cal:number2>4</cal:number2>
                                    </cal:SubtractionInput>
                        </soapenv:Body>
            </soapenv:Envelope>


            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:inh="http://com.imranmadbr/">
               <soapenv:Header/>
               <soapenv:Body>
                  <inh:opManager>
                     <!--Optional:-->
                     <version>2.0</version>
                     <service>xxx</service>
                     <method>xxx</method>
                     <param>xxxxxx</param>
                     <numberofparam>1</numberofparam>
                     <userid>xxxxxxx</userid>
                     <password>xxxxx</password>
                     <failclause>xxxx</failclause>
                  </inh:opManager>
               </soapenv:Body>
            </soapenv:Envelope>



            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                              xmlns:us="http://imranmadbar.com/spring-boot-soap-service">
                <soapenv:Header/>
                <soapenv:Body>
                    <us:getUserRequest>
                        <us:name>imran</us:name>
                    </us:getUserRequest>
                </soapenv:Body>
            </soapenv:Envelope>


		
Simple Soap Response:
-------------------------------------

            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
              <SOAP-ENV:Header/>
              <SOAP-ENV:Body>
                          <ns2:output xmlns:ns2="http://imranmadbar.com/types/calculator">
                                      <ns2:result>6</ns2:result>
                          </ns2:output>
              </SOAP-ENV:Body>
            </SOAP-ENV:Envelope>

# SPRING_FUNDAMENTAL



SPRING SOAP SERVICE
========================================================================

http://localhost:8080/imranmadbar/ws/calculatorDemo.wsdl


Simple Soap Request: 
            
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
          
          
Simple Soap Response: 

          <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
              <SOAP-ENV:Header/>
              <SOAP-ENV:Body>
                  <ns2:output xmlns:ns2="http://imranmadbar.com/types/calculator">
                      <ns2:result>6</ns2:result>
                  </ns2:output>
              </SOAP-ENV:Body>
          </SOAP-ENV:Envelope>

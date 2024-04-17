

Creating a SOAP Web Service with Spring:
	The contract-first approach requires us to create the domain (methods and parameters) for our service first. 
	We’ll use an XML schema file (XSD) that Spring-WS will export automatically as a WSDL:
	Then we’ll generate the Java classes from the XSD file defined in the previous section. The jaxb2-maven-plugin will do this automatically during build time. 
	then The SOAP web service endpoint class will handle all the incoming requests for the service. It’ll initiate the processing and send the response back.
	


SOAP webservice creating step:

step1: Add pom dependency
step2: Create student-details.xsd file, where defined request/response formate.
step3: Base on .xsd file generate java class file
step4: Add dependency "wsdl4j" for generate WSDL file and add config in WebServiceConfig
step5: Create EndPoint "StudentAppEndpoint" class for defined request url with request and response class


SimpleRequestXml1: POST:  URL: http://localhost:8080/ws
	<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
	    <Body>
	        <GetStudentRequest xmlns="http://madbarsoft.com/students">
	            <id>102321</id>
	        </GetStudentRequest>
	    </Body>
	</Envelope>
Response:
	<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
	    <SOAP-ENV:Header/>
	    <SOAP-ENV:Body>
	        <ns2:GetStudentDetailsResponse xmlns:ns2="http://madbarsoft.com/students">
	            <ns2:StudentDetails>
	                <ns2:id>0</ns2:id>
	                <ns2:name>MD IMRAN HOSSAIN</ns2:name>
	            </ns2:StudentDetails>
	        </ns2:GetStudentDetailsResponse>
	    </SOAP-ENV:Body>
	</SOAP-ENV:Envelope>





SimpleRequestXml2: POST:  URL: http://localhost:8080/ws
	<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
	    <Body>
	        <GetStudentDetailsRequest xmlns="http://madbarsoft.com/students">
	            <id>102321</id>
	        </GetStudentDetailsRequest>
	    </Body>
	</Envelope>

Response:
	<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
	    <SOAP-ENV:Header/>
	    <SOAP-ENV:Body>
	        <ns2:GetStudentDetailsResponse xmlns:ns2="http://madbarsoft.com/students">
	            <ns2:StudentDetails>
	                <ns2:id>102321</ns2:id>
	                <ns2:name>MD IMRAN HOSSAIN</ns2:name>
	                <ns2:passportNumber>PS4354M</ns2:passportNumber>
	            </ns2:StudentDetails>
	        </ns2:GetStudentDetailsResponse>
	    </SOAP-ENV:Body>
	</SOAP-ENV:Envelope>



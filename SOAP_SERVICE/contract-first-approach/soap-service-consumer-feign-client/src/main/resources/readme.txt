

Consuming a SOAP web service:


Let us now create a new Spring Boot Project. We need to have a spring-boot-starter-web-services dependency. 
We also need maven-jaxb2-plugin to parse the WSDL and generate the client code from the WSDL file.


Service Createion Step:

step1: add dependency in pom file
step2: collect and add .wsdl file in classpath, it will generate request/response class. wsdl file generate by producer, so it should collect from consumer site.
step3: Create Request client and config client class (StudentClient)
step4: call it from controller


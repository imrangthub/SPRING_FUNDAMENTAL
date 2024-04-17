
package com.imranmadbar.soap;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.imranmadbar.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.imranmadbar.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStudentRequest }
     * 
     * @return
     *     the new instance of {@link GetStudentRequest }
     */
    public GetStudentRequest createGetStudentRequest() {
        return new GetStudentRequest();
    }

    /**
     * Create an instance of {@link GetStudentDetailsRequest }
     * 
     * @return
     *     the new instance of {@link GetStudentDetailsRequest }
     */
    public GetStudentDetailsRequest createGetStudentDetailsRequest() {
        return new GetStudentDetailsRequest();
    }

    /**
     * Create an instance of {@link GetStudentDetailsResponse }
     * 
     * @return
     *     the new instance of {@link GetStudentDetailsResponse }
     */
    public GetStudentDetailsResponse createGetStudentDetailsResponse() {
        return new GetStudentDetailsResponse();
    }

    /**
     * Create an instance of {@link StudentDetails }
     * 
     * @return
     *     the new instance of {@link StudentDetails }
     */
    public StudentDetails createStudentDetails() {
        return new StudentDetails();
    }

}

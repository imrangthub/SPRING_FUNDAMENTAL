//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.26 at 03:42:29 PM BDT 
//


package com.imranmadbar.soap.bindings;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.imranmadbar.soap.bindings package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.imranmadbar.soap.bindings
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AdditionInput }
     * 
     */
    public AdditionInput createAdditionInput() {
        return new AdditionInput();
    }

    /**
     * Create an instance of {@link SubtractionInput }
     * 
     */
    public SubtractionInput createSubtractionInput() {
        return new SubtractionInput();
    }

    /**
     * Create an instance of {@link MultiplicationInput }
     * 
     */
    public MultiplicationInput createMultiplicationInput() {
        return new MultiplicationInput();
    }

    /**
     * Create an instance of {@link DivisionInput }
     * 
     */
    public DivisionInput createDivisionInput() {
        return new DivisionInput();
    }

    /**
     * Create an instance of {@link Output }
     * 
     */
    public Output createOutput() {
        return new Output();
    }

}

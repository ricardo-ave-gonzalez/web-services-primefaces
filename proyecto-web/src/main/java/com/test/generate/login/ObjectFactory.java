
package com.test.generate.login;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ave package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _GetTrueLogin_QNAME = new QName("http://repositories.ave.com/", "getTrueLogin");
    private final static QName _GetTrueLoginResponse_QNAME = new QName("http://repositories.ave.com/", "getTrueLoginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ave
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTrueLogin }
     * 
     */
    public GetTrueLogin createGetTrueLogin() {
        return new GetTrueLogin();
    }

    /**
     * Create an instance of {@link GetTrueLoginResponse }
     * 
     */
    public GetTrueLoginResponse createGetTrueLoginResponse() {
        return new GetTrueLoginResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTrueLogin }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTrueLogin }{@code >}
     */
    @XmlElementDecl(namespace = "http://repositories.ave.com/", name = "getTrueLogin")
    public JAXBElement<GetTrueLogin> createGetTrueLogin(GetTrueLogin value) {
        return new JAXBElement<GetTrueLogin>(_GetTrueLogin_QNAME, GetTrueLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTrueLoginResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTrueLoginResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://repositories.ave.com/", name = "getTrueLoginResponse")
    public JAXBElement<GetTrueLoginResponse> createGetTrueLoginResponse(GetTrueLoginResponse value) {
        return new JAXBElement<GetTrueLoginResponse>(_GetTrueLoginResponse_QNAME, GetTrueLoginResponse.class, null, value);
    }

}

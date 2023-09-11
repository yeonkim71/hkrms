/**
 * FI37_MIS_REQ_SOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hkilbo.hkrms.ECC.FI37;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class FI37_MIS_REQ_SOServiceLocator extends org.apache.axis.client.Service implements com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SOService {

    private java.lang.String FI37_MIS_REQ_SOPort_address = "";

    public FI37_MIS_REQ_SOServiceLocator() {
    }

    public FI37_MIS_REQ_SOServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FI37_MIS_REQ_SOServiceLocator(String xiIp, String xiPort, String xiFi37) {
        this.FI37_MIS_REQ_SOPort_address = "http://"+xiIp+":"+xiPort+"/XISOAPAdapter/MessageServlet?channel="+xiFi37+"&version=3.0&Sender.Service=HANKOOKILBO_MIS&Interface=http%3A%2F%2Fdongwha.co.kr%2FECC_FI%2FFI37%5EFI37_MIS_REQ_SO";
    }

    public FI37_MIS_REQ_SOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FI37_MIS_REQ_SOPort
    //private java.lang.String FI37_MIS_REQ_SOPort_address = "http://172.16.2.102:50000/XISOAPAdapter/MessageServlet?channel=:HANKOOKILBO_MIS:MIS_FI37_SOAP_Sender&version=3.0&Sender.Service=HANKOOKILBO_MIS&Interface=http%3A%2F%2Fdongwha.co.kr%2FECC_FI%2FFI37%5EFI37_MIS_REQ_SO";

    public java.lang.String getFI37_MIS_REQ_SOPortAddress() {
        return FI37_MIS_REQ_SOPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FI37_MIS_REQ_SOPortWSDDServiceName = "FI37_MIS_REQ_SOPort";

    public java.lang.String getFI37_MIS_REQ_SOPortWSDDServiceName() {
        return FI37_MIS_REQ_SOPortWSDDServiceName;
    }

    public void setFI37_MIS_REQ_SOPortWSDDServiceName(java.lang.String name) {
        FI37_MIS_REQ_SOPortWSDDServiceName = name;
    }

    public com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SO getFI37_MIS_REQ_SOPort() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URI(FI37_MIS_REQ_SOPort_address).toURL();
        }
        catch (MalformedURLException | URISyntaxException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFI37_MIS_REQ_SOPort(endpoint);
    }

    public com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SO getFI37_MIS_REQ_SOPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SOBindingStub _stub = new com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SOBindingStub(portAddress, this);
            _stub.setPortName(getFI37_MIS_REQ_SOPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFI37_MIS_REQ_SOPortEndpointAddress(java.lang.String address) {
        FI37_MIS_REQ_SOPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SO.class.isAssignableFrom(serviceEndpointInterface)) {
                com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SOBindingStub _stub = new com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SOBindingStub(new java.net.URI(FI37_MIS_REQ_SOPort_address).toURL(), this);
                _stub.setPortName(getFI37_MIS_REQ_SOPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FI37_MIS_REQ_SOPort".equals(inputPortName)) {
            return getFI37_MIS_REQ_SOPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://dongwha.co.kr/ECC_FI/FI37", "FI37_MIS_REQ_SOService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://dongwha.co.kr/ECC_FI/FI37", "FI37_MIS_REQ_SOPort"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

        if ("FI37_MIS_REQ_SOPort".equals(portName)) {
            setFI37_MIS_REQ_SOPortEndpointAddress(address);
        }
        else
        { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

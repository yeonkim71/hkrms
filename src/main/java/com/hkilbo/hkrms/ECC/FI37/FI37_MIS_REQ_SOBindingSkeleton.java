package com.hkilbo.hkrms.ECC.FI37;
/**
 * FI37_MIS_REQ_SOBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

public class FI37_MIS_REQ_SOBindingSkeleton implements com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SO, org.apache.axis.wsdl.Skeleton {
    private com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SO impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
     * Returns List of OperationDesc objects with this name
     */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
     * Returns Collection of OperationDescs
     */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://dongwha.co.kr/ECC_FI/FI37", "FI37_MIS_REQ_Msg"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dongwha.co.kr/ECC_FI/FI37", "FI37_MIS_REQ"), com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("FI37_MIS_REQ_SO", _params, new javax.xml.namespace.QName("http://dongwha.co.kr/ECC_FI/FI37", "FI37_MIS_RESP_Msg"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dongwha.co.kr/ECC_FI/FI37", "FI37_MIS_RESP"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "FI37_MIS_REQ_SO"));
        _oper.setSoapAction("http://sap.com/xi/WebService/soap1.1");
        _myOperationsList.add(_oper);
        if (_myOperations.get("FI37_MIS_REQ_SO") == null) {
            _myOperations.put("FI37_MIS_REQ_SO", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("FI37_MIS_REQ_SO")).add(_oper);
    }

    public FI37_MIS_REQ_SOBindingSkeleton() {
        this.impl = new com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SOBindingImpl();
    }

    public FI37_MIS_REQ_SOBindingSkeleton(com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SO impl) {
        this.impl = impl;
    }
    public com.hkilbo.hkrms.ECC.FI37.FI37_MIS_RESP FI37_MIS_REQ_SO(com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ FI37_MIS_REQ_Msg, String xiUserName, String xiPassword) throws java.rmi.RemoteException
    {
        com.hkilbo.hkrms.ECC.FI37.FI37_MIS_RESP ret = impl.FI37_MIS_REQ_SO(FI37_MIS_REQ_Msg,xiUserName,xiPassword);
        return ret;
    }

}

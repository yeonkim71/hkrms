/**
 * FI37_MIS_RESP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hkilbo.hkrms.ECC.FI37;

public class FI37_MIS_RESP  implements java.io.Serializable {
    private java.lang.String vrAcntNo;

    private java.lang.String successYN;

    private java.lang.String message;

    public FI37_MIS_RESP() {
    }

    public FI37_MIS_RESP(
            java.lang.String vrAcntNo,
            java.lang.String successYN,
            java.lang.String message) {
        this.vrAcntNo = vrAcntNo;
        this.successYN = successYN;
        this.message = message;
    }


    /**
     * Gets the vrAcntNo value for this FI37_MIS_RESP.
     *
     * @return vrAcntNo
     */
    public java.lang.String getVrAcntNo() {
        return vrAcntNo;
    }


    /**
     * Sets the vrAcntNo value for this FI37_MIS_RESP.
     *
     * @param vrAcntNo
     */
    public void setVrAcntNo(java.lang.String vrAcntNo) {
        this.vrAcntNo = vrAcntNo;
    }


    /**
     * Gets the successYN value for this FI37_MIS_RESP.
     *
     * @return successYN
     */
    public java.lang.String getSuccessYN() {
        return successYN;
    }


    /**
     * Sets the successYN value for this FI37_MIS_RESP.
     *
     * @param successYN
     */
    public void setSuccessYN(java.lang.String successYN) {
        this.successYN = successYN;
    }


    /**
     * Gets the message value for this FI37_MIS_RESP.
     *
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this FI37_MIS_RESP.
     *
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FI37_MIS_RESP)) return false;
        FI37_MIS_RESP other = (FI37_MIS_RESP) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.vrAcntNo==null && other.getVrAcntNo()==null) ||
                        (this.vrAcntNo!=null &&
                                this.vrAcntNo.equals(other.getVrAcntNo()))) &&
                ((this.successYN==null && other.getSuccessYN()==null) ||
                        (this.successYN!=null &&
                                this.successYN.equals(other.getSuccessYN()))) &&
                ((this.message==null && other.getMessage()==null) ||
                        (this.message!=null &&
                                this.message.equals(other.getMessage())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getVrAcntNo() != null) {
            _hashCode += getVrAcntNo().hashCode();
        }
        if (getSuccessYN() != null) {
            _hashCode += getSuccessYN().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(FI37_MIS_RESP.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dongwha.co.kr/ECC_FI/FI37", "FI37_MIS_RESP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vrAcntNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VrAcntNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("successYN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuccessYN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new  org.apache.axis.encoding.ser.BeanSerializer(
                        _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new  org.apache.axis.encoding.ser.BeanDeserializer(
                        _javaType, _xmlType, typeDesc);
    }

}

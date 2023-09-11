/**
 * FI37_MIS_REQ.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hkilbo.hkrms.ECC.FI37;

public class FI37_MIS_REQ  implements java.io.Serializable {
    /* 회사코드 */
    private java.lang.String compCd;

    /* 거래처코드 */
    private java.lang.String custCd;

    /* SAP고객 */
    private java.lang.String ERPCustCd;

    /* SAP밴더 */
    private java.lang.String ERPVendorCd;

    /* 거래처구분 */
    private java.lang.String custGu;

    /* 광고,지국,기타 */
    private java.lang.String custType;

    /* 거래처명1 */
    private java.lang.String custName1;

    /* 거래처명2 */
    private java.lang.String custName2;

    /* 사업자번호 */
    private java.lang.String bizNo;

    /* 법인번호 */
    private java.lang.String corpNo;

    /* 주민번호 */
    private java.lang.String personNo;

    /* 대표자명 */
    private java.lang.String repName;

    /* 업태 */
    private java.lang.String compType;

    /* 업종 */
    private java.lang.String compKind;

    /* 우편번호 */
    private java.lang.String zipNo;

    /* 우편주소 */
    private java.lang.String zipAddr;

    /* 주소 */
    private java.lang.String addr;

    /* 담당자이메일 */
    private java.lang.String emailAddr;

    /* 담당자명 */
    private java.lang.String recvName;

    /* 전화번호 */
    private java.lang.String telNo;

    /* 팩스번호 */
    private java.lang.String faxNo;

    /* 계좌승계거래처 */
    private java.lang.String orgERPCustCd;

    /* 은행코드 */
    private java.lang.String cmBankCd;

    /* 예금주 */
    private java.lang.String saverName;

    /* 지급계좌번호 */
    private java.lang.String acntNo;

    /* 가상계좌승계여부 */
    private java.lang.String vrAcntCopyYN;

    /* 가상계좌사용여부 */
    private java.lang.String vrAcntNoYN;

    /* 지급조건 */
    private java.lang.String payTerm;

    public FI37_MIS_REQ() {
    }

    public FI37_MIS_REQ(
            java.lang.String compCd,
            java.lang.String custCd,
            java.lang.String ERPCustCd,
            java.lang.String ERPVendorCd,
            java.lang.String custGu,
            java.lang.String custType,
            java.lang.String custName1,
            java.lang.String custName2,
            java.lang.String bizNo,
            java.lang.String corpNo,
            java.lang.String personNo,
            java.lang.String repName,
            java.lang.String compType,
            java.lang.String compKind,
            java.lang.String zipNo,
            java.lang.String zipAddr,
            java.lang.String addr,
            java.lang.String emailAddr,
            java.lang.String recvName,
            java.lang.String telNo,
            java.lang.String faxNo,
            java.lang.String orgERPCustCd,
            java.lang.String cmBankCd,
            java.lang.String saverName,
            java.lang.String acntNo,
            java.lang.String vrAcntCopyYN,
            java.lang.String vrAcntNoYN,
            java.lang.String payTerm) {
        this.compCd = compCd;
        this.custCd = custCd;
        this.ERPCustCd = ERPCustCd;
        this.ERPVendorCd = ERPVendorCd;
        this.custGu = custGu;
        this.custType = custType;
        this.custName1 = custName1;
        this.custName2 = custName2;
        this.bizNo = bizNo;
        this.corpNo = corpNo;
        this.personNo = personNo;
        this.repName = repName;
        this.compType = compType;
        this.compKind = compKind;
        this.zipNo = zipNo;
        this.zipAddr = zipAddr;
        this.addr = addr;
        this.emailAddr = emailAddr;
        this.recvName = recvName;
        this.telNo = telNo;
        this.faxNo = faxNo;
        this.orgERPCustCd = orgERPCustCd;
        this.cmBankCd = cmBankCd;
        this.saverName = saverName;
        this.acntNo = acntNo;
        this.vrAcntCopyYN = vrAcntCopyYN;
        this.vrAcntNoYN = vrAcntNoYN;
        this.payTerm = payTerm;
    }


    /**
     * Gets the compCd value for this FI37_MIS_REQ.
     *
     * @return compCd   * 회사코드
     */
    public java.lang.String getCompCd() {
        return compCd;
    }

    /**
     * Sets the compCd value for this FI37_MIS_REQ.
     *
     * @param compCd   * 회사코드
     */
    public void setCompCd(java.lang.String compCd) {
        this.compCd = compCd;
    }

    /**
     * Gets the custCd value for this FI37_MIS_REQ.
     *
     * @return custCd   * 거래처코드
     */
    public java.lang.String getCustCd() {
        return custCd;
    }


    /**
     * Sets the custCd value for this FI37_MIS_REQ.
     *
     * @param custCd   * 거래처코드
     */
    public void setCustCd(java.lang.String custCd) {
        this.custCd = custCd;
    }


    /**
     * Gets the ERPCustCd value for this FI37_MIS_REQ.
     *
     * @return ERPCustCd   * SAP고객
     */
    public java.lang.String getERPCustCd() {
        return ERPCustCd;
    }


    /**
     * Sets the ERPCustCd value for this FI37_MIS_REQ.
     *
     * @param ERPCustCd   * SAP고객
     */
    public void setERPCustCd(java.lang.String ERPCustCd) {
        this.ERPCustCd = ERPCustCd;
    }


    /**
     * Gets the ERPVendorCd value for this FI37_MIS_REQ.
     *
     * @return ERPVendorCd   * SAP밴더
     */
    public java.lang.String getERPVendorCd() {
        return ERPVendorCd;
    }


    /**
     * Sets the ERPVendorCd value for this FI37_MIS_REQ.
     *
     * @param ERPVendorCd   * SAP밴더
     */
    public void setERPVendorCd(java.lang.String ERPVendorCd) {
        this.ERPVendorCd = ERPVendorCd;
    }


    /**
     * Gets the custGu value for this FI37_MIS_REQ.
     *
     * @return custGu   * 거래처구분
     */
    public java.lang.String getCustGu() {
        return custGu;
    }


    /**
     * Sets the custGu value for this FI37_MIS_REQ.
     *
     * @param custGu   * 거래처구분
     */
    public void setCustGu(java.lang.String custGu) {
        this.custGu = custGu;
    }


    /**
     * Gets the custType value for this FI37_MIS_REQ.
     *
     * @return custType   * 광고,지국,기타
     */
    public java.lang.String getCustType() {
        return custType;
    }


    /**
     * Sets the custType value for this FI37_MIS_REQ.
     *
     * @param custType   * 광고,지국,기타
     */
    public void setCustType(java.lang.String custType) {
        this.custType = custType;
    }


    /**
     * Gets the custName1 value for this FI37_MIS_REQ.
     *
     * @return custName1   * 거래처명1
     */
    public java.lang.String getCustName1() {
        return custName1;
    }


    /**
     * Sets the custName1 value for this FI37_MIS_REQ.
     *
     * @param custName1   * 거래처명1
     */
    public void setCustName1(java.lang.String custName1) {
        this.custName1 = custName1;
    }


    /**
     * Gets the custName2 value for this FI37_MIS_REQ.
     *
     * @return custName2   * 거래처명2
     */
    public java.lang.String getCustName2() {
        return custName2;
    }


    /**
     * Sets the custName2 value for this FI37_MIS_REQ.
     *
     * @param custName2   * 거래처명2
     */
    public void setCustName2(java.lang.String custName2) {
        this.custName2 = custName2;
    }


    /**
     * Gets the bizNo value for this FI37_MIS_REQ.
     *
     * @return bizNo   * 사업자번호
     */
    public java.lang.String getBizNo() {
        return bizNo;
    }


    /**
     * Sets the bizNo value for this FI37_MIS_REQ.
     *
     * @param bizNo   * 사업자번호
     */
    public void setBizNo(java.lang.String bizNo) {
        this.bizNo = bizNo;
    }


    /**
     * Gets the corpNo value for this FI37_MIS_REQ.
     *
     * @return corpNo   * 법인번호
     */
    public java.lang.String getCorpNo() {
        return corpNo;
    }


    /**
     * Sets the corpNo value for this FI37_MIS_REQ.
     *
     * @param corpNo   * 법인번호
     */
    public void setCorpNo(java.lang.String corpNo) {
        this.corpNo = corpNo;
    }


    /**
     * Gets the personNo value for this FI37_MIS_REQ.
     *
     * @return personNo   * 주민번호
     */
    public java.lang.String getPersonNo() {
        return personNo;
    }


    /**
     * Sets the personNo value for this FI37_MIS_REQ.
     *
     * @param personNo   * 주민번호
     */
    public void setPersonNo(java.lang.String personNo) {
        this.personNo = personNo;
    }


    /**
     * Gets the repName value for this FI37_MIS_REQ.
     *
     * @return repName   * 대표자명
     */
    public java.lang.String getRepName() {
        return repName;
    }


    /**
     * Sets the repName value for this FI37_MIS_REQ.
     *
     * @param repName   * 대표자명
     */
    public void setRepName(java.lang.String repName) {
        this.repName = repName;
    }


    /**
     * Gets the compType value for this FI37_MIS_REQ.
     *
     * @return compType   * 업태
     */
    public java.lang.String getCompType() {
        return compType;
    }


    /**
     * Sets the compType value for this FI37_MIS_REQ.
     *
     * @param compType   * 업태
     */
    public void setCompType(java.lang.String compType) {
        this.compType = compType;
    }


    /**
     * Gets the compKind value for this FI37_MIS_REQ.
     *
     * @return compKind   * 업종
     */
    public java.lang.String getCompKind() {
        return compKind;
    }


    /**
     * Sets the compKind value for this FI37_MIS_REQ.
     *
     * @param compKind   * 업종
     */
    public void setCompKind(java.lang.String compKind) {
        this.compKind = compKind;
    }


    /**
     * Gets the zipNo value for this FI37_MIS_REQ.
     *
     * @return zipNo   * 우편번호
     */
    public java.lang.String getZipNo() {
        return zipNo;
    }


    /**
     * Sets the zipNo value for this FI37_MIS_REQ.
     *
     * @param zipNo   * 우편번호
     */
    public void setZipNo(java.lang.String zipNo) {
        this.zipNo = zipNo;
    }


    /**
     * Gets the zipAddr value for this FI37_MIS_REQ.
     *
     * @return zipAddr   * 우편주소
     */
    public java.lang.String getZipAddr() {
        return zipAddr;
    }


    /**
     * Sets the zipAddr value for this FI37_MIS_REQ.
     *
     * @param zipAddr   * 우편주소
     */
    public void setZipAddr(java.lang.String zipAddr) {
        this.zipAddr = zipAddr;
    }


    /**
     * Gets the addr value for this FI37_MIS_REQ.
     *
     * @return addr   * 주소
     */
    public java.lang.String getAddr() {
        return addr;
    }


    /**
     * Sets the addr value for this FI37_MIS_REQ.
     *
     * @param addr   * 주소
     */
    public void setAddr(java.lang.String addr) {
        this.addr = addr;
    }


    /**
     * Gets the emailAddr value for this FI37_MIS_REQ.
     *
     * @return emailAddr   * 담당자이메일
     */
    public java.lang.String getEmailAddr() {
        return emailAddr;
    }


    /**
     * Sets the emailAddr value for this FI37_MIS_REQ.
     *
     * @param emailAddr   * 담당자이메일
     */
    public void setEmailAddr(java.lang.String emailAddr) {
        this.emailAddr = emailAddr;
    }


    /**
     * Gets the recvName value for this FI37_MIS_REQ.
     *
     * @return recvName   * 담당자명
     */
    public java.lang.String getRecvName() {
        return recvName;
    }


    /**
     * Sets the recvName value for this FI37_MIS_REQ.
     *
     * @param recvName   * 담당자명
     */
    public void setRecvName(java.lang.String recvName) {
        this.recvName = recvName;
    }


    /**
     * Gets the telNo value for this FI37_MIS_REQ.
     *
     * @return telNo   * 전화번호
     */
    public java.lang.String getTelNo() {
        return telNo;
    }


    /**
     * Sets the telNo value for this FI37_MIS_REQ.
     *
     * @param telNo   * 전화번호
     */
    public void setTelNo(java.lang.String telNo) {
        this.telNo = telNo;
    }


    /**
     * Gets the faxNo value for this FI37_MIS_REQ.
     *
     * @return faxNo   * 팩스번호
     */
    public java.lang.String getFaxNo() {
        return faxNo;
    }


    /**
     * Sets the faxNo value for this FI37_MIS_REQ.
     *
     * @param faxNo   * 팩스번호
     */
    public void setFaxNo(java.lang.String faxNo) {
        this.faxNo = faxNo;
    }


    /**
     * Gets the orgERPCustCd value for this FI37_MIS_REQ.
     *
     * @return orgERPCustCd   * 계좌승계거래처
     */
    public java.lang.String getOrgERPCustCd() {
        return orgERPCustCd;
    }


    /**
     * Sets the orgERPCustCd value for this FI37_MIS_REQ.
     *
     * @param orgERPCustCd   * 계좌승계거래처
     */
    public void setOrgERPCustCd(java.lang.String orgERPCustCd) {
        this.orgERPCustCd = orgERPCustCd;
    }


    /**
     * Gets the cmBankCd value for this FI37_MIS_REQ.
     *
     * @return cmBankCd   * 은행코드
     */
    public java.lang.String getCmBankCd() {
        return cmBankCd;
    }


    /**
     * Sets the cmBankCd value for this FI37_MIS_REQ.
     *
     * @param cmBankCd   * 은행코드
     */
    public void setCmBankCd(java.lang.String cmBankCd) {
        this.cmBankCd = cmBankCd;
    }


    /**
     * Gets the saverName value for this FI37_MIS_REQ.
     *
     * @return saverName   * 예금주
     */
    public java.lang.String getSaverName() {
        return saverName;
    }


    /**
     * Sets the saverName value for this FI37_MIS_REQ.
     *
     * @param saverName   * 예금주
     */
    public void setSaverName(java.lang.String saverName) {
        this.saverName = saverName;
    }


    /**
     * Gets the acntNo value for this FI37_MIS_REQ.
     *
     * @return acntNo   * 지급계좌번호
     */
    public java.lang.String getAcntNo() {
        return acntNo;
    }


    /**
     * Sets the acntNo value for this FI37_MIS_REQ.
     *
     * @param acntNo   * 지급계좌번호
     */
    public void setAcntNo(java.lang.String acntNo) {
        this.acntNo = acntNo;
    }


    /**
     * Gets the vrAcntCopyYN value for this FI37_MIS_REQ.
     *
     * @return vrAcntCopyYN   * 가상계좌승계여부
     */
    public java.lang.String getVrAcntCopyYN() {
        return vrAcntCopyYN;
    }


    /**
     * Sets the vrAcntCopyYN value for this FI37_MIS_REQ.
     *
     * @param vrAcntCopyYN   * 가상계좌승계여부
     */
    public void setVrAcntCopyYN(java.lang.String vrAcntCopyYN) {
        this.vrAcntCopyYN = vrAcntCopyYN;
    }


    /**
     * Gets the vrAcntNoYN value for this FI37_MIS_REQ.
     *
     * @return vrAcntNoYN   * 가상계좌사용여부
     */
    public java.lang.String getVrAcntNoYN() {
        return vrAcntNoYN;
    }


    /**
     * Sets the vrAcntNoYN value for this FI37_MIS_REQ.
     *
     * @param vrAcntNoYN   * 가상계좌사용여부
     */
    public void setVrAcntNoYN(java.lang.String vrAcntNoYN) {
        this.vrAcntNoYN = vrAcntNoYN;
    }


    /**
     * Gets the payTerm value for this FI37_MIS_REQ.
     *
     * @return payTerm   * 지급조건
     */
    public java.lang.String getPayTerm() {
        return payTerm;
    }


    /**
     * Sets the payTerm value for this FI37_MIS_REQ.
     *
     * @param payTerm   * 지급조건
     */
    public void setPayTerm(java.lang.String payTerm) {
        this.payTerm = payTerm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FI37_MIS_REQ)) return false;
        FI37_MIS_REQ other = (FI37_MIS_REQ) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.compCd==null && other.getCompCd()==null) ||
                        (this.compCd!=null &&
                                this.compCd.equals(other.getCompCd()))) &&
                ((this.custCd==null && other.getCustCd()==null) ||
                        (this.custCd!=null &&
                                this.custCd.equals(other.getCustCd()))) &&
                ((this.ERPCustCd==null && other.getERPCustCd()==null) ||
                        (this.ERPCustCd!=null &&
                                this.ERPCustCd.equals(other.getERPCustCd()))) &&
                ((this.ERPVendorCd==null && other.getERPVendorCd()==null) ||
                        (this.ERPVendorCd!=null &&
                                this.ERPVendorCd.equals(other.getERPVendorCd()))) &&
                ((this.custGu==null && other.getCustGu()==null) ||
                        (this.custGu!=null &&
                                this.custGu.equals(other.getCustGu()))) &&
                ((this.custType==null && other.getCustType()==null) ||
                        (this.custType!=null &&
                                this.custType.equals(other.getCustType()))) &&
                ((this.custName1==null && other.getCustName1()==null) ||
                        (this.custName1!=null &&
                                this.custName1.equals(other.getCustName1()))) &&
                ((this.custName2==null && other.getCustName2()==null) ||
                        (this.custName2!=null &&
                                this.custName2.equals(other.getCustName2()))) &&
                ((this.bizNo==null && other.getBizNo()==null) ||
                        (this.bizNo!=null &&
                                this.bizNo.equals(other.getBizNo()))) &&
                ((this.corpNo==null && other.getCorpNo()==null) ||
                        (this.corpNo!=null &&
                                this.corpNo.equals(other.getCorpNo()))) &&
                ((this.personNo==null && other.getPersonNo()==null) ||
                        (this.personNo!=null &&
                                this.personNo.equals(other.getPersonNo()))) &&
                ((this.repName==null && other.getRepName()==null) ||
                        (this.repName!=null &&
                                this.repName.equals(other.getRepName()))) &&
                ((this.compType==null && other.getCompType()==null) ||
                        (this.compType!=null &&
                                this.compType.equals(other.getCompType()))) &&
                ((this.compKind==null && other.getCompKind()==null) ||
                        (this.compKind!=null &&
                                this.compKind.equals(other.getCompKind()))) &&
                ((this.zipNo==null && other.getZipNo()==null) ||
                        (this.zipNo!=null &&
                                this.zipNo.equals(other.getZipNo()))) &&
                ((this.zipAddr==null && other.getZipAddr()==null) ||
                        (this.zipAddr!=null &&
                                this.zipAddr.equals(other.getZipAddr()))) &&
                ((this.addr==null && other.getAddr()==null) ||
                        (this.addr!=null &&
                                this.addr.equals(other.getAddr()))) &&
                ((this.emailAddr==null && other.getEmailAddr()==null) ||
                        (this.emailAddr!=null &&
                                this.emailAddr.equals(other.getEmailAddr()))) &&
                ((this.recvName==null && other.getRecvName()==null) ||
                        (this.recvName!=null &&
                                this.recvName.equals(other.getRecvName()))) &&
                ((this.telNo==null && other.getTelNo()==null) ||
                        (this.telNo!=null &&
                                this.telNo.equals(other.getTelNo()))) &&
                ((this.faxNo==null && other.getFaxNo()==null) ||
                        (this.faxNo!=null &&
                                this.faxNo.equals(other.getFaxNo()))) &&
                ((this.orgERPCustCd==null && other.getOrgERPCustCd()==null) ||
                        (this.orgERPCustCd!=null &&
                                this.orgERPCustCd.equals(other.getOrgERPCustCd()))) &&
                ((this.cmBankCd==null && other.getCmBankCd()==null) ||
                        (this.cmBankCd!=null &&
                                this.cmBankCd.equals(other.getCmBankCd()))) &&
                ((this.saverName==null && other.getSaverName()==null) ||
                        (this.saverName!=null &&
                                this.saverName.equals(other.getSaverName()))) &&
                ((this.acntNo==null && other.getAcntNo()==null) ||
                        (this.acntNo!=null &&
                                this.acntNo.equals(other.getAcntNo()))) &&
                ((this.vrAcntCopyYN==null && other.getVrAcntCopyYN()==null) ||
                        (this.vrAcntCopyYN!=null &&
                                this.vrAcntCopyYN.equals(other.getVrAcntCopyYN()))) &&
                ((this.vrAcntNoYN==null && other.getVrAcntNoYN()==null) ||
                        (this.vrAcntNoYN!=null &&
                                this.vrAcntNoYN.equals(other.getVrAcntNoYN()))) &&
                ((this.payTerm==null && other.getPayTerm()==null) ||
                        (this.payTerm!=null &&
                                this.payTerm.equals(other.getPayTerm())));
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
        if (getCompCd() != null) {
            _hashCode += getCompCd().hashCode();
        }
        if (getCustCd() != null) {
            _hashCode += getCustCd().hashCode();
        }
        if (getERPCustCd() != null) {
            _hashCode += getERPCustCd().hashCode();
        }
        if (getERPVendorCd() != null) {
            _hashCode += getERPVendorCd().hashCode();
        }
        if (getCustGu() != null) {
            _hashCode += getCustGu().hashCode();
        }
        if (getCustType() != null) {
            _hashCode += getCustType().hashCode();
        }
        if (getCustName1() != null) {
            _hashCode += getCustName1().hashCode();
        }
        if (getCustName2() != null) {
            _hashCode += getCustName2().hashCode();
        }
        if (getBizNo() != null) {
            _hashCode += getBizNo().hashCode();
        }
        if (getCorpNo() != null) {
            _hashCode += getCorpNo().hashCode();
        }
        if (getPersonNo() != null) {
            _hashCode += getPersonNo().hashCode();
        }
        if (getRepName() != null) {
            _hashCode += getRepName().hashCode();
        }
        if (getCompType() != null) {
            _hashCode += getCompType().hashCode();
        }
        if (getCompKind() != null) {
            _hashCode += getCompKind().hashCode();
        }
        if (getZipNo() != null) {
            _hashCode += getZipNo().hashCode();
        }
        if (getZipAddr() != null) {
            _hashCode += getZipAddr().hashCode();
        }
        if (getAddr() != null) {
            _hashCode += getAddr().hashCode();
        }
        if (getEmailAddr() != null) {
            _hashCode += getEmailAddr().hashCode();
        }
        if (getRecvName() != null) {
            _hashCode += getRecvName().hashCode();
        }
        if (getTelNo() != null) {
            _hashCode += getTelNo().hashCode();
        }
        if (getFaxNo() != null) {
            _hashCode += getFaxNo().hashCode();
        }
        if (getOrgERPCustCd() != null) {
            _hashCode += getOrgERPCustCd().hashCode();
        }
        if (getCmBankCd() != null) {
            _hashCode += getCmBankCd().hashCode();
        }
        if (getSaverName() != null) {
            _hashCode += getSaverName().hashCode();
        }
        if (getAcntNo() != null) {
            _hashCode += getAcntNo().hashCode();
        }
        if (getVrAcntCopyYN() != null) {
            _hashCode += getVrAcntCopyYN().hashCode();
        }
        if (getVrAcntNoYN() != null) {
            _hashCode += getVrAcntNoYN().hashCode();
        }
        if (getPayTerm() != null) {
            _hashCode += getPayTerm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(FI37_MIS_REQ.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dongwha.co.kr/ECC_FI/FI37", "FI37_MIS_REQ"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CompCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CustCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERPCustCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERPCustCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERPVendorCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERPVendorCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custGu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CustGu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CustType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custName1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CustName1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custName2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CustName2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bizNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BizNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CorpNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PersonNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RepName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CompType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compKind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CompKind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zipNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ZipNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zipAddr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ZipAddr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Addr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailAddr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EmailAddr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recvName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RecvName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TelNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faxNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FaxNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgERPCustCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OrgERPCustCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmBankCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CmBankCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saverName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SaverName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acntNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AcntNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vrAcntCopyYN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VrAcntCopyYN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vrAcntNoYN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VrAcntNoYN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payTerm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PayTerm"));
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

package com.hkilbo.hkrms.customer.vo;

public class CodeVo {

    private String seqDiv = "";
    private String seqID = "";

    public void clean() throws Exception {
    }

    public void validate(int action) throws Exception {

    }

    public String getSeqDiv()
    {
        return seqDiv;
    }

    public void setSeqDiv(String seqDiv)
    {
        this.seqDiv = seqDiv;
    }

    public String getSeqID()
    {
        return seqID;
    }

    public void setSeqID(String seqID)
    {
        this.seqID = seqID;
    }
}
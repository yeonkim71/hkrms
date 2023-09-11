package com.hkilbo.hkrms.ECC.FI37;

import java.io.UnsupportedEncodingException;

/**
 * 한국일보 전용 util
 * @author lee
 *
 */
public class HkibUtil {

    /**
     * 들어온 파라미터가 string 이라도 string [] 로 강제로 변경해준다.
     * @param o
     * @return
     */
    public String [] getStringArray(Object o){
        if (o == null) {
            return null;
        }
        String str = o.getClass().getCanonicalName();
        if(str.equals("java.lang.String")){
            String rtn [] = { (String)o };
            return (String [])rtn;

        }else{
            return (String [])o;
        }
    }




    /**
     * 주어진 길이(iLength)만큼 주어진 문자(cPadder)를 strSource의 왼쪽에 붙혀서 보내준다.
     * ex) lpad("abc", 5, '^') ==> "^^abc"
     *     lpad("abcdefghi", 5, '^') ==> "abcde"
     *     lpad(null, 5, '^') ==> "^^^^^"
     *
     * @param strSource
     * @param iLength
     * @param cPadder
     */
    public static String lpad(String strSource, int iLength, String cPadder){
        StringBuffer sbBuffer = null;
        if (!"".equals(strSource)){
            int iByteSize = getByteSize(strSource);
            if (iByteSize > iLength){
                return strSource.substring(0, iLength);
            }else if (iByteSize == iLength){
                return strSource;
            }else{
                int iPadLength = iLength - iByteSize;
                sbBuffer = new StringBuffer();
                for (int j = 0; j < iPadLength; j++){
                    sbBuffer.append(cPadder);
                }
                sbBuffer.append(strSource);
                return sbBuffer.toString();
            }
        }
        //int iPadLength = iLength;
        sbBuffer = new StringBuffer();
        for (int j = 0; j < iLength; j++){
            sbBuffer.append(cPadder);
        }
        return sbBuffer.toString();
    }
    /**
     * 주어진 길이(iLength)만큼 주어진 문자(cPadder)를 strSource의 오른쪽에 붙혀서 보내준다.
     * ex) lpad("abc", 5, '^') ==> "abc^^"
     *     lpad("abcdefghi", 5, '^') ==> "abcde"
     *     lpad(null, 5, '^') ==> "^^^^^"
     *
     * @param strSource
     * @param iLength
     * @param cPadder
     */
    public static String rpad(String strSource, int iLength, String cPadder){
        StringBuffer sbBuffer = null;
        if (!"".equals(strSource)){
            int iByteSize = getByteSize(strSource);
            if (iByteSize > iLength){
                return strSource.substring(0, iLength);
            }else if (iByteSize == iLength){
                return strSource;
            }else{
                int iPadLength = iLength - iByteSize;
                sbBuffer = new StringBuffer(strSource);
                for (int j = 0; j < iPadLength; j++){
                    sbBuffer.append(cPadder);
                }
                return sbBuffer.toString();
            }
        }
        sbBuffer = new StringBuffer();
        for (int j = 0; j < iLength; j++){
            sbBuffer.append(cPadder);
        }
        return sbBuffer.toString();
    }

    /**
     *  byte size를 가져온다.
     *
     * @param str String target
     * @return int bytelength
     */
    public static int getByteSize(String str){
        if (str == null || str.length() == 0)
            return 0;
        byte[] byteArray = null;
        try{
            byteArray = str.getBytes("UTF-8");
        }catch (UnsupportedEncodingException ex){}
        if (byteArray == null) return 0;
        return byteArray.length;
    }

    // 공백문자만들기 함수
    public static String Addspace(String str, int size){
        String result = " ";
        if(size <= str.length())
            return str;
        for(int i = 0; i < size - str.length()-1 ; i++)
            result = result + " ";
        return  str + result ;
    }
}

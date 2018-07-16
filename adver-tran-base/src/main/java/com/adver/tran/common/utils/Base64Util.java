package com.adver.tran.common.utils;

import org.apache.commons.codec.binary.Base64;

import com.adver.tran.common.exception.BusinessException;

public class Base64Util {

	/**  
     * @param bytes  
     * @return  
     */    
    public static String decode(final byte[] bytes) throws BusinessException{
        return new String(Base64.decodeBase64(bytes));    
    }
    
    /**  
     * @param String  
     * @return  
     */    
    public static String decode(final String str) throws BusinessException{
        return new String(Base64.decodeBase64(str.getBytes()));    
    }
    
    /**  
     * 二进制数据编码为BASE64字符串  
     *  
     * @param bytes  
     * @return  
     * @throws Exception  
     */    
    public static String encode(final byte[] bytes) throws BusinessException{
        return new String(Base64.encodeBase64(bytes));    
    }
    
    /**  
     * 二进制数据编码为BASE64字符串  
     *  
     * @param String  
     * @return  
     * @throws Exception  
     */    
    public static String encode(final String str) throws BusinessException{
        return new String(Base64.encodeBase64(str.getBytes()));    
    } 
	
}

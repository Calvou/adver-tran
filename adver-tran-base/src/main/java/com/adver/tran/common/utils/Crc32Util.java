package com.adver.tran.common.utils;

import java.util.zip.CRC32;

/**
 * Created by wb-zhuxiongwei on 2017/4/5.
 */
public class Crc32Util {

    private static Crc32Util crc32Util = new Crc32Util();

    private Crc32Util(){

    }
    public static Crc32Util getInstance(){
        if(crc32Util == null){
            crc32Util = new Crc32Util();
        }
        return crc32Util;
    }
    public synchronized Long getCrc32Value(String userId,String channel){
        String str = userId+channel;
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }
    public synchronized Long getCrc32Value(String userId,Long now){
        String str = userId+now;
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getCrc32Value("10000000002",System.currentTimeMillis()));
        String value = String.format("%012d",getInstance().getCrc32Value("10000000002",System.currentTimeMillis()));
        System.out.println(value+":"+System.currentTimeMillis());

    }
}

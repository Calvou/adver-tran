package com.adver.tran.common.log;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import com.adver.tran.common.utils.DateUtil;

/**
 * Created by lgf
 */
public class MonitorLog {
    private String serAddr;
    private String level;
    private String category;
    private String path;
    private String msg;
    private Object meta;
    private String time;


    public enum MLogCategory {
        /**
         * 服务层
         */
        SERVICE
        /**
         * 数据层
         */
        ,DAO
        /**
         * 第三方
         */
        ,THIRD
        /**
         * 执行时间
         */
        ,EXEC_TIME
        /**
         * 最大值
         */
        ,MAX_VAL
        /**
         * 最小值
         */
        ,MIN_VAL
        /**
         * 核心
         */
        ,TXN
        /**
         * 操作平台
         */
        ,OPER
        ;
    }


    public MonitorLog() {
    }

    public MonitorLog(String level, String category, String path, String msg, Object meta) {
        this.serAddr = initSerAddr();
        this.level = level;
        this.category = category;
        this.path = path;
        this.msg = msg;
        this.meta = meta;
        this.time = DateUtil.toString(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public String initSerAddr() {
        try {
            return InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
        }
        return "";
    }

    public String getSerAddr() {
        return serAddr;
    }

    public void setSerAddr(String serAddr) {
        this.serAddr = serAddr;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

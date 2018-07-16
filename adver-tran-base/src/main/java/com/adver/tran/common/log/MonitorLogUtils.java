package com.adver.tran.common.log;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 监控日志帮助类
 * Created by lgf
 */
public class MonitorLogUtils {

    private static final Logger logger = LoggerFactory.getLogger("MonitorLog");

    public static MonitorLogUtils log;

    static {
        if(log==null){
            log = new MonitorLogUtils();
        }
    }


    public void error(Exception exception){
        _log("error",getPath(exception), exception.getMessage(),null,null);
    }

    public void error(Exception exception, String category, Object meta){
        _log("error",getPath(exception), exception.getMessage(),category,meta);
    }

    public void error(String path, String msg){
        _log("error",path,msg,null,null);
    }
    public void error(String path, String msg, String category, Object meta){
        _log("error",path,msg,category,meta);
    }
    public void error(String path, String msg, String category, Object req, Object resp){
        Map<String, Object> meta = new HashMap<String, Object>();
        meta.put("request", req);
        meta.put("response", resp);
        _log("error",path,msg,category,meta);
    }

    public void warn(String path, String msg){
        _log("warn",path,msg,null,null);
    }
    public void warn(String path, String msg, String category, Object meta){
        _log("warn",path,msg,category,meta);
    }


    private void _log(String level, String path, String msg, String category, Object meta){
        logger.error(JSONObject.fromObject(new MonitorLog(level,category,path,msg,meta)).toString());
    }

    public static String getPath(Exception exception){
        StackTraceElement[] stacks = exception.getStackTrace();
        StringBuffer sb = new StringBuffer();
        if(stacks.length>1){
            sb.append(stacks[0].getClassName());
            sb.append(".").append(stacks[0].getMethodName());
            sb.append(":").append(stacks[0].getLineNumber());
            sb.append(" ");
            sb.append(stacks[1].getClassName());
            sb.append(".").append(stacks[1].getMethodName());
            sb.append(":").append(stacks[1].getLineNumber());
        }
        return sb.toString();
    }

}

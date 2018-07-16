package com.adver.tran.web.base;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.common.exception.ErrorCode;
import com.adver.tran.common.log.MonitorLog;
import com.adver.tran.common.log.MonitorLogUtils;
import com.adver.tran.common.utils.DateUtil;
import com.adver.tran.domain.base.ApiRequest;
import com.adver.tran.domain.base.ApiResponse;
import com.alibaba.dubbo.rpc.RpcException;

public class BaseController {

	static Logger logger = LoggerFactory.getLogger(BaseController.class); 

    public String getHttpRequestParamStr(HttpServletRequest request, String key){
        return request.getParameterMap()!=null&&request.getParameterMap().containsKey(key)?request.getParameter(key):"";
    }


    /**
     * 获取ApiResponse
     * @return
     */
    public ApiResponse getApiResponse(ApiRequest request) {
        ApiResponse resp = new ApiResponse<>();
        resp.setBussSeqNo(request.getBussSeqNo());
        resp.setChannelId(request.getChannelId());
        resp.setReqTime(request.getReqTime());
        resp.setRecTime(DateUtil.format(new Date(),DateUtil.DT_YYYYMMDDHHMMSSSSS));
        return resp;
    }

    /**
     * 获取ApiResponse
     * @return
     */
    public ApiResponse getApiResponse(HttpServletRequest request) {
        ApiResponse resp = new ApiResponse<>();
        resp.setBussSeqNo(getHttpRequestParamStr(request,"bussSeqNo"));
        resp.setReqTime(getHttpRequestParamStr(request,"reqTime"));
        resp.setChannelId(getHttpRequestParamStr(request,"channelId"));
        resp.setRecTime(DateUtil.format(new Date(),DateUtil.DT_YYYYMMDDHHMMSSSSS));
        return resp;
    }
    
    /**
     * 获取ApiResponse
     * @return
     */
    public HttpServletResponse getApiResponse(HttpServletRequest request, HttpServletResponse resp) {
        resp.setHeader("bussSeqNo", getHttpRequestParamStr(request,"bussSeqNo"));
        resp.setHeader("reqTime", getHttpRequestParamStr(request,"reqTime"));
        resp.setHeader("channelId", getHttpRequestParamStr(request,"channelId"));
        resp.setHeader("recTime", DateUtil.format(new Date(),DateUtil.DT_YYYYMMDDHHMMSSSSS));
        return resp;
    }


    /**
     * 异常处理器
     *
     * @return ApiResponse 响应对象
     * @author linshaoyun
     */
    @ExceptionHandler
    @SuppressWarnings({ "unchecked"})
    public ApiResponse<Map<String, Object>> handleBaseException(HttpServletRequest request, Exception e) {    	
        ApiResponse<Map<String, Object>> resp = getApiResponse(request);
        logger.info(resp.getChannelId()+" - "+">>>>>>>>>>>>>>"+request.getRequestURI()+"<<<<<<<<<<<<<<<<");
        if (e instanceof MethodArgumentNotValidException) return methodArgumentNotValidExceptionHandlerMethod(resp,e);
        if (e instanceof BusinessException) return apiExceptionHandlerMethod(resp,e);
        return otherExceptionHandler(resp,e);
    }
    
    /**
     * 异常处理器
     *
     * @return ApiResponse 响应对象
     * @author linshaoyun
     */
    //@ExceptionHandler
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public ApiResponse handleBaseException(ApiResponse resp, Exception e) {
        if (e instanceof MethodArgumentNotValidException) return methodArgumentNotValidExceptionHandlerMethod(resp,e);
        if (e instanceof BusinessException) return apiExceptionHandlerMethod(resp,e);
        if (e instanceof RpcException) return RpcExceptionHandlerMethod(resp,e);
        return otherExceptionHandler(resp,e);
    }
    
    
	private ApiResponse RpcExceptionHandlerMethod(ApiResponse resp, Exception e) {
		resp.setCode(ErrorCode.DOUBBOERROR.getCode());
        resp.setMsg(ErrorCode.DOUBBOERROR.getMessage());
        
    	resp.setRespTime(DateUtil.format(new Date(),DateUtil.DT_YYYYMMDDHHMMSSSSS));
        MonitorLogUtils.log.error(e, MonitorLog.MLogCategory.SERVICE.toString(), resp.toString());
        logger.error(resp.getChannelId()+" - "+"错误信息:", e);
        return resp;
	}

	/**
     * 其他异常处理器
     * @param resp
     * @param e
     * @return
     */
    private ApiResponse<Map<String, Object>> otherExceptionHandler(ApiResponse<Map<String, Object>> resp,Exception e){
    	resp.setCode(ErrorCode.ERROR.getCode());
        resp.setMsg(ErrorCode.ERROR.getMessage());
        
    	resp.setRespTime(DateUtil.format(new Date(),DateUtil.DT_YYYYMMDDHHMMSSSSS));
        MonitorLogUtils.log.error(e, MonitorLog.MLogCategory.SERVICE.toString(), resp.toString());
        logger.error(resp.getChannelId()+" - "+"错误信息:", e);
        
        return resp;
    }
    
    /**
     * API异常处理器
     * @param resp
     * @param e
     * @author wb-wanghao
     */
     private ApiResponse<Map<String, Object>> apiExceptionHandlerMethod(ApiResponse<Map<String, Object>> resp,Exception e){
    	 BusinessException se = (BusinessException) e;
         resp.setCode(se.getErrorCode());
         resp.setMsg(se.getErrorMessage());
         
         resp.setRespTime(DateUtil.format(new Date(),DateUtil.DT_YYYYMMDDHHMMSSSSS));
         MonitorLogUtils.log.error(e, MonitorLog.MLogCategory.SERVICE.toString(), resp.toString());
         logger.error(resp.getChannelId()+" - "+"错误信息:", e);
         
         return resp;
    }
    
    /**
     * 参数验证异常处理器
     * @param resp
     * @param e
     * @author wb-wanghao
     */
    private ApiResponse methodArgumentNotValidExceptionHandlerMethod(ApiResponse resp,Exception e){
    	MethodArgumentNotValidException be = (MethodArgumentNotValidException) e;
        StringBuilder errStr = new StringBuilder();
        if(be.getBindingResult().getErrorCount()>0){
            for (ObjectError oe : be.getBindingResult().getAllErrors()) {
                errStr.append(oe.getDefaultMessage()).append(";");
            }
        }
        resp.setCode(ErrorCode.PARAM_ERROR.getCode());
        resp.setMsg(errStr.length()>0?errStr.toString():ErrorCode.PARAM_ERROR.getMessage());
        resp.setRespTime(DateUtil.format(new Date(),DateUtil.DT_YYYYMMDDHHMMSSSSS));
        MonitorLogUtils.log.error(e, MonitorLog.MLogCategory.SERVICE.toString(), resp.toString());
        logger.error(resp.getChannelId()+" - "+"错误信息:", e);
        return resp;
    }
	
}

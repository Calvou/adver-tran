package com.adver.tran.web.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.adver.tran.common.consts.RedisCachePreKeyEnum;
import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.common.utils.BaseCode;
import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.domain.base.ApiRequest;
import com.adver.tran.store.redis.RedisCacheService;

@Aspect
@Component
public class TokenAspect {
	
	String USER_INFO_SESSION_KEY = "userInfo";
    String SESSION_KEY = "x-auth-token";
    
    @Autowired
    private RedisCacheService redisService;  

    //本地异常日志记录对象
    private  static  final Logger logger = LoggerFactory.getLogger(TokenAspect.class);

    //Controller层切点
    @Pointcut("execution(* com.adver.tran.web.controller..*.*(..)) "
    		+ "&& !execution(* com.adver.tran.web.controller.SysController.oauthToken(..)) "
    		+ "&& !execution(* com.adver.tran.web.controller.ParamCodeController.paramCode(..)) ")
    public  void controllerAspect() {
    	
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     * @return 
     * @throws Throwable 
     */
    @Around("controllerAspect()")   
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
    	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //HttpServletResponse response = attributes.getResponse();
        //String classType = joinPoint.getTarget().getClass().getName();
        //Class<?> clazz = Class.forName(classType);
        //String clazzName = clazz.getName();
        //String methodName = joinPoint.getSignature().getName(); //获取方法名称
        Object[] args = joinPoint.getArgs();//参数
        //joinPoint.getTarget();
        
        //如果访问的渠道是 work 则检查权限
        if(!CheckParam.isNull(args)&&args.length>0 && "POST".equals(request.getMethod())){
        	//if("DMSALE001".equals(((ApiRequest)args[0]).getChannelId())){
        		String sessionId = request.getHeader(SESSION_KEY);
                if(org.apache.commons.lang3.StringUtils.isBlank(sessionId)){  
                    sessionId=(String) request.getSession().getAttribute(SESSION_KEY);  
                }  
                if (org.apache.commons.lang3.StringUtils.isNotBlank(sessionId)) {
                	
                    String session = redisService.get(RedisCachePreKeyEnum.adverUserToken.getKey()+""+sessionId);            
                    if (session == null) {
                    	throw new BusinessException(BaseCode.E_9999999999,"用户未登录或无权限访问");
                    }
                    redisService.set(RedisCachePreKeyEnum.adverUserToken.getKey()+""+sessionId, session, new Long(1*60*60));
                    request.setAttribute(USER_INFO_SESSION_KEY, session);  
                }
        	//}
        }
        //不需要拦截直接执行
        return joinPoint.proceed();
    }
	
}

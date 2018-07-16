package com.adver.tran.common.utils;

/**
 * @author 
 *         接口常用代码
 */
public class BaseCode {
	
    public static final String RESULT = "result";
    public static final String MESSAGE = "message";
    
    /*****************API对外异常码   1001业务领域码(信贷) 00系统编码(API系统) 0000业务异常码******************/
    //产品列表
    public static final String E_1001000000 = "1001000000";//成功!
    public static final String E_1001009999 = "1001009999";//业务处理异常
    public static final String E_1001000001 = "1001000001";//参数错误
    public static final String E_1001000002 = "1001000002";//服务无法调用
    public static final String E_9999999999 = "9999999999";//权限验证不通过
    
    
    /*****************BIZ对外异常码   1001业务领域码(信贷) 01系统编码(BIZ系统) 0000业务异常码******************/
    public static final String E_1001011001 = "1001011001";//协议反馈异常
    
    //识别模块 -biz
    public static final String E_1001012001 = "1001012001";//未检测到有效身份证！
    public static final String E_1001012002 = "1001012002";//识别模糊，请注意角度和反光等！
    public static final String E_1001012003 = "1001012003";//未正常识别，请重试！
    public static final String E_1001012004 = "1001012004";//无法认定为同一人
    
    
    public static final String E_1001013001 = "1001013001";//银卡保存异常
    public static final String E_1001013002 = "1001013002";//银卡列表获取失败
    
    public static final String E_1001014001 = "1001014001";//用户状态查询异常
    public static final String E_1001014002 = "1001014002";//手机服务码验证码异常
    public static final String E_1001014003 = "1001014003";//保存地址信息
    public static final String E_1001014004 = "1001014004";//用户联系人信息保存异常
    public static final String E_1001014005 = "1001014005";//职业信息保存异常
    public static final String E_1001014006 = "1001014006";//用户工作地址保存异常
    public static final String E_1001014007 = "1001014007";//房产信息保存异常
    public static final String E_1001014008 = "1001014008";//车辆信息保存异常
    public static final String E_1001014009 = "1001014009";//用户信息更新异常
    public static final String E_1001014010 = "1001014010";//获取数据异常
    public static final String E_1001014011 = "1001014011";//附件信息更新异常
    
    public static final String E_1001015001 = "1001015001";//文件标识设置出错
    public static final String E_1001015002 = "1001015002";//协议任务建立失败
    public static final String E_1001015003 = "1001015003";//文件状态回填异常
    public static final String E_1001015004 = "1001015004";//文件列表异常
    public static final String E_1001015005 = "1001015005";//文件不存在
    public static final String E_1001015006 = "1001015006";//文件数据保存异常
    public static final String E_1001015007 = "1001015007";//文件包生成异常
    
    public static final String E_1001016001 = "1001016001";//贷款信息保存异常
    
    public static final String E_1001017000 = "1001017000";//任务已正常提交
    public static final String E_1001017001 = "1001017001";//任务创建失败
    public static final String E_1001017002 = "1001017002";//手机号与服务密码不匹配
    public static final String E_1001017003 = "1001017003";//手机短信验证码错误或过期，稍后请重新输入
    public static final String E_1001017004 = "1001017004";//数据未上送
    public static final String E_1001017005 = "1001017005";//验证码处理异常请重新操作
    
    /*****************ATT对外异常码   1001业务领域码(信贷) 02系统编码(ATT系统) 0000业务异常码******************/
    public static final String E_1001020000 = "1001020000";//成功!
    
    //文件模块
    public static final String E_1001020001 = "1001020001";//文件路径初始化错误
    public static final String E_1001020002 = "1001020002" ; //文件无法下载，检查文件服务器是否异常或路径不存在
    public static final String E_1001020003 = "1001020003"; //文件下载发生错误
    public static final String E_1001020004 = "1001020004"; //文件MD5检查发生错误
    public static final String E_1001020005 = "1001020005"; //文件存储发生错误
    public static final String E_1001020006 = "1001020006";  //文件转换错误
    public static final String E_1001020007 = "1001020007"; //文件转换错误
    public static final String E_1001020008 = "1001020008"; //文件列表获取失败
    public static final String E_1001020009 = "1001020009"; //文件解压失败
    public static final String E_1001020010 = "1001020010"; //文件处理失败
    public static final String E_1001020011 = "1001020011"; //更新任务状态失败
    public static final String E_1001020012 = "1001020012"; //附件任务载入失败
    public static final String E_1001020013 = "1001020013"; //附件打包失败
    
    //协议模块
    public static final String E_1001021001 = "1001021001"; //协议路径初始化错误
    public static final String E_1001021002 = "1001021002"; //协议路径下载 aggLoad出错,返回异常
    public static final String E_1001021003 = "1001021003"; //协议路径下载 aggLoad出错
    public static final String E_1001021004 = "1001021004"; //协议无法下载，检查协议服务器是否异常或路径不存在
    public static final String E_1001021005 = "1001021005"; //协议下载发生错误
    public static final String E_1001021006 = "1001021006"; //协议MD5检查发生错误
    public static final String E_1001021007 = "1001021007"; //协议存储发生错误
    public static final String E_1001021008 = "1001021008"; //协议更新任务状态失败
    public static final String E_1001021009 = "1001021009"; //协议任务载入失败
    public static final String E_1001021010 = "1001021010"; //协议任务新增失败
    
    
    /*****************ITF对外异常码   1001业务领域码(信贷) 03系统编码(ITF系统) 0000业务异常码******************/
    //faceId
    public static final String E_1001030001 = "1001030001"; //协议路径初始化错误
    public static final String E_1001030002 = "1001030002"; //银行卡三要素检查失败
    public static final String E_1001030003 = "1001030003"; //银行卡四要素检查失败
    
    public static final String E_1001031001 = "1001031001"; //文件无法下载，检查文件服务器是否异常或路径不存在
    public static final String E_1001031002 = "1001031002"; //获取FaceId验证码出错
    public static final String E_1001031003 = "1001031003"; //文件下载发生错误
    public static final String E_1001031004 = "1001031004"; //MD5计算异常
    
    //签章平台
    public static final String E_1001032001 = "1001032001"; //注册异常，签章平台无返回
    public static final String E_1001032002 = "1001032002"; //信息已存在
    public static final String E_1001032003 = "1001032003"; //注册失败
    public static final String E_1001032004 = "1001032004"; //申请证书异常，签章平台无返回
    public static final String E_1001032005 = "1001032005"; //证书已存在
    public static final String E_1001032006 = "1001032006"; //签名图片上传异常
    public static final String E_1001032007 = "1001032007"; //创建签名异常
    public static final String E_1001032008 = "1001032008"; //上传合同文件异常
    public static final String E_1001032009 = "1001032009"; //创建合同异常
    public static final String E_1001032010 = "1001032010"; //添加合同签署者
    public static final String E_1001032011 = "1001032011"; //合同签署异常
    public static final String E_1001032012 = "1001032012"; //合同预览URL
    public static final String E_1001032013 = "1001032013"; //合同下载URL异常
    public static final String E_1001032014 = "1001032014"; //合同完成异常
    public static final String E_1001032015 = "1001032015"; //协议处理失败
    
    //用户管理
    public static final String E_1001041001 = "1001041001";//已存在用户
    public static final String E_1001041002 = "1001041002";//注册失败
    public static final String E_1001041003 = "1001041003";//不存在用户
    public static final String E_1001041004 = "1001041004";//登陆密码错误
    public static final String E_1001041005 = "1001041005";//登录失败
    public static final String E_1001041006 = "1001041006";//手机号格式不对
    public static final String E_1001041007 = "1001041007";//密码长度不够
    public static final String E_1001041008 = "1001041008";//更新密码时密码未变更
    public static final String E_1001041009 = "1001041009";//用户信息保存异常
    
}

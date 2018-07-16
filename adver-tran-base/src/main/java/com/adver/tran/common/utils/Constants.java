package com.adver.tran.common.utils;

/**
 * Created by lgf
 */
public class Constants {

    // 手机号正则
    public static final String MOBILE_REGULAR = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-8])|(147))\\d{8}$";
    // 身份证正则
    public static final String IDCARD_REGULAR = "((\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$)";
    // 邮箱正则
    public static final String EMAIL_REGULAR = "^(([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,})$";
    
    //系统编号 1001 API  1002 BIZ  1003 ATT  1004 ITF 1005 WORK 1006 SALE

	/**
	 * 业务中心系统服务URL
	 */
    public static final String BIZ_USER_CHECK = "/user/userCheck";
    public static final String BIZ_USER_USERINFO = "/user/userInfo";
    public static final String BIZ_CUST_CUSTBASEALLINFO = "/cust/custBaseAllInfo";
    public static final String BIZ_CUST_CUSTSTATUS = "/cust/custStatus";
    public static final String BIZ_CUST_CUSTBASEINFO = "/cust/custBaseInfo";
    public static final String BIZ_CUST_CUSTCAREERINFO = "/cust/custCareerInfo";
    public static final String BIZ_CUST_CUSTFINANCIALINFO = "/cust/custFinancialInfo";
    public static final String BIZ_CUST_CUSTMOBILEPWD = "/cust/mobileServicePwd";
    public static final String BIZ_CUST_SAVEYSDATA = "/cust/saveYsData";
    public static final String BIZ_RECOGNIZE_OCR = "/recognize/fileOCR";
    public static final String BIZ_RECOGNIZE_FACECODE = "/recognize/faceCode";
    public static final String BIZ_RECOGNIZE_FACEVERIFYVIDEO = "/recognize/faceVerifyVideo";
	public static final String BIZ_LOAN_LOANINFO = "/loan/loanInfo";
	public static final String BIZ_CODE_PARAMCODE = "/code/paramCode";
	public static final String BIZ_FILE_FILESCONFIRM = "/file/filesConfirm";
	public static final String BIZ_FILE_GETFILES = "/file/getFiles";
	public static final String BIZ_FILE_SAVEFILEDATA = "/file/saveFileData";
	public static final String BIZ_FILE_ZIPDOWN = "/file/caseFileZipDown";	
	public static final String BIZ_AGG_AGGBACKTRACK = "/aggremt/backtrack";
	public static final String BIZ_CARD_BINDBANKCARD = "/card/bindBankCard";
	public static final String BIZ_CARD_BANKCARDLIST = "/card/bindBankCardList";
	public static final String BIZ_CUST_GETCUSTALL = "/cust/getCustInfo";
	public static final String BIZ_RISK_RISKINFO = "/risk/riskIn";
	public static final String BIZ_MOBILE_MOBILEPWD = "/mobile/mobileServicePwd";
    
	public static final String BIZ_APPLY_APPLYLOANINFO = "/apply/applyLoanInfo";
	public static final String BIZ_APPLY_APPLYPROTOCHANL = "/apply/applyProToChanl";
	public static final String BIZ_FILE_CASEFILEDOWN = "/file/caseFileDown";
	public static final String BIZ_FILE_ZIPDOWNS2 = "/file/caseFileZipDownS2";

	public static final String BIZ_SALE_SALEAPPLYINFO = "/sale/saleApplyInfo";
	public static final String BIZ_SALE_SALEAPPLYDEAL = "/sale/saleApplyDeal";
	public static final String BIZ_SALE_SALECASEFLOW = "/sale/caseFlow";
	
	public static final String BIZ_SALE_INDEXSTATS = "/index/indexDataStats";

	public static final String BIZ_SALESYS_SALEUSERLIST = "/saleSys/saleUserList";
	public static final String BIZ_SALESYS_ADDSALEUSER = "/saleSys/addSaleUser";
	public static final String BIZ_SALESYS_DELETESALEUSER = "/saleSys/deleteSaleUser";
	public static final String BIZ_SALESYS_SALECHANNELLIST = "/saleSys/saleChannelList";
	public static final String BIZ_SALESYS_ADDSALECHANNEL = "/saleSys/addSaleChannel";
	public static final String BIZ_SALESYS_DELETESALECHANNEL = "/saleSys/deleteSaleChannel";
	public static final String WORK_SALESYS_ADDSALECHANNEL = "/saleSys/addSaleChannel";
	
	public static final String OPM_BUSSSAVE = "/opm/bussSave";
	public static final String OPM_SHOPSAVE = "/opm/shopSave";
	
    /**
     * 附件管理平台服务URL
     */
	public static final String ATT_FILE_OCRFILE = "/file/ocrFileStore";
	public static final String ATT_FILE_FILEREADB64 = "/file/fileReadBase64";
	public static final String ATT_FILE_FILEREADSTREAM = "/file/fileReadStream";
	public static final String ATT_FILE_FILEINFO = "/file/fileInfo";
	public static final String ATT_FILE_FACEVERIFYVIDEOSTORE = "/file/faceVerifyVideoStore";
	public static final String ATT_FILE_FILESLOAD = "/file/filesLoad";
	public static final String ATT_AGG_AGGADDTASK = "/aggremt/aggremtAddTask";
	public static final String ATT_FILE_FILESZIP = "/file/filesZip";
	
	/**
     * 互联网平台服务URL
     */
	public static final String ITF_FACEID_IDOCR = "/faceid/idCardOCR";
	public static final String ITF_FACEID_FACECODE = "/faceid/faceCode";
	public static final String ITF_FACEID_FACEVERIFYVEDIO = "/faceid/faceVerifyVedio";
	public static final String ITF_FACEID_FACEVERIFYIDCARD = "/faceid/faceVerifyIdCard";
	public static final String ITF_CARD_BANKCARDAUTH= "/card/bankCardAuth";
	public static final String ITF_MOBILESERVICE_STARTTESK= "/mobileService/startMobileTesk";
	public static final String ITF_MOBILESERVICE_SENDTESK= "/mobileService/sendMobileTesk";
	
	/**
     * 工作台服务URL
     */
	public static final String WORK_CASE_CASEAPPLY= "/case/caseApply";
	public static final String WORK_CASE_CASEAPPLYRISK= "/case/caseApplyRisk";
	
	public static final String WORK_OAUTH_TOKEN = "/sys/oauth2/token";
	public static final String WORK_USER_MENUS  = "/sys/user/menus";
	public static final String WORK_USER_MENUSN  = "/sys/user/menusn";
	public static final String WORK_USER_CHANGEPASSWORD = "/sys/user/changePassword";
	public static final String WORK_MOBILE_MOBILEDETAIL2 = "/mobile/mobileDetail2";
	public static final String WORK_CASE_CASEDETAIL = "/case/caseDetail";
	
	/**
     * 咨信服务URL OR 调度引擎服务URL
     */
	public static final String CSP_BANKCARD4E = "/riskManage/bankCard4E";
	public static final String CSP_BANKCARD3E = "/riskManage/bankCard3E";
	public static final String CSP_HOUSEVALUE = "/riskManage/getHousePrice";
	public static final String CSP_HOUSERENTCUR = "/riskManage/getCurrentHouseRent";
	public static final String CSP_STARTMOBILETESK = "/riskManage/startMobileTesk";
	public static final String CSP_SENDMOBILETESK = "/riskManage/sendMobileTesk";
	public static final String CSP_QUERYMOBILEDETAIL = "/riskManage/queryMobileDetail";
	public static final String CSP_QUERYMOBILEDETAIL2 = "/riskManage/queryMobileDetail2";
	public static final String CSP_QUERYMOVEDETAIL = "/riskManage/queryMoveDetailByMobile";
	public static final String CSP_QUERYCOSTDETAIL = "/riskManage/queryCostDetailByMobile";
	public static final String CSP_QUERYREPORTDETAIL = "/riskManage/queryReportDetail";
	
	public static final String SCHEDULE_CREDAPP = "/ControlCentre/duomi/CredApp";
	
	/**
	 * 微信二维码工作台URL
	 */
	public static final String QRCODE_GETQRCODETICKET = "/openUserInfo/getQrcodeTicket";
}

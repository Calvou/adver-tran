package com.domi.sale.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.junit.Test;

import com.adver.tran.common.utils.Base64Util;
import com.adver.tran.common.utils.HttpUtil;
import com.adver.tran.common.utils.HttpsUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class QrCodeTest {
	@Test
	public void test() {
		Map<String, Object> qRCodeReq = new HashMap<String, Object>();
		qRCodeReq.put("scene_str", "srdfth");
		String hres = HttpUtil.doGet("http://anyine.vicp.net/api/openUserInfo/getQrcodeTicket", qRCodeReq);
		JSONObject obj = JSON.parseObject(hres);
		System.out.println(obj.get("resData").toString());
		try {
			HttpResponse res = HttpsUtil.get(obj.get("resData").toString());
			byte[] buffer = new byte[1024];	
			int read = res.getEntity().getContent().read(buffer);
			String folder=System.getProperty("user.home");
			File file = new File(folder+File.separator+"123.jpg");
			FileOutputStream fileStream = new FileOutputStream(file);	
			byte[] qrByte = new byte[0];	
			while(read >= 0){
				//等于0的情况，是数据流没有结束，但是
				//因为网络问题，暂时还没有读到数据
				//这种情况下，100毫秒后再去读
				if(read == 0){
					Thread.sleep(100);
				}
				fileStream.write(buffer,0,read);		
				read = res.getEntity().getContent().read(buffer);								
			}
			fileStream.flush();
			FileInputStream inputFile = new FileInputStream(file);  
			byte[] buffer1 = new byte[(int) file.length()];  
			inputFile.read(buffer1);
			inputFile.close();
			String result = Base64.encodeBase64String(buffer1);
			System.out.println("base64:"+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

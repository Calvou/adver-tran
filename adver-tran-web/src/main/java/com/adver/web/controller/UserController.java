package com.adver.web.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adver.domain.req.TestReq;
import com.adver.service.user.IUserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Resource
	private IUserService userService;
	
	@ApiOperation(value = "测试post请求",notes="注意事项")
	@ApiImplicitParam(dataType = "TestReq",name = "treq",value = "测试post请求",required = true)
	@RequestMapping(value = "/testPost",method = RequestMethod.POST)
	public String testPost(@Validated @RequestBody TestReq treq) throws Exception{
		int uid = userService.saveUser();
		System.out.println("add success : "+ uid);
		return ""+uid;
	}
}

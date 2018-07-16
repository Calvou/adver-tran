package com.adver.tran.domain.res;

import java.util.List;

import com.adver.tran.domain.res.vo.FileVo;

import io.swagger.annotations.ApiModel;

@ApiModel()
public class FileRes extends BaseRes{

	private List<FileVo> filesVo;

	public List<FileVo> getFilesVo() {
		return filesVo;
	}

	public void setFilesVo(List<FileVo> filesVo) {
		this.filesVo = filesVo;
	}
	
}

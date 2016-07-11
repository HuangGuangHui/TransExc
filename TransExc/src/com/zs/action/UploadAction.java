package com.zs.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zs.file.Copy;

public class UploadAction extends ActionSupport{
	
	private File files;
	private String filesFileName;
	
	
	
	public File getFiles() {
		return files;
	}
	public void setFiles(File files) {
		this.files = files;
	}
	public String getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(String filesFileName) {
		this.filesFileName = filesFileName;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(files);
		System.out.println(filesFileName);
		String temp=new Copy().upload(files, filesFileName);
		System.out.println("-------action-------------"+temp);
		return SUCCESS;
	}
	
}

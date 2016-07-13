package com.zs.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MyBaseAction extends ActionSupport{
	
	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession session;
	
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public HttpServletRequest getRequest() throws UnsupportedEncodingException {
		request=ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
}

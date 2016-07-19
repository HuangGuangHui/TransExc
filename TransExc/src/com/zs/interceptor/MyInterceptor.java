package com.zs.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// 取得请求相关的ActionContext实例  
		HttpServletRequest request = ServletActionContext.getRequest();
        ActionContext ctx = arg0.getInvocationContext();  
        Map session = ctx.getSession();  
        //获得url
        String path = request.getRequestURI();//url
        String reqPamrs = request.getQueryString();//后面的参数
        
        
        
        Object user =session.get("user"); 
		System.out.println(path);  
		
		return arg0.invoke();
	}
	
}

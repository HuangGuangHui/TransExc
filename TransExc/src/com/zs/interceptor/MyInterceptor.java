package com.zs.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zs.dao.BaseDaoOfSpring;
import com.zs.dao.IBaseDaoOfSpring;
import com.zs.entity.Permission;
import com.zs.entity.Role;
import com.zs.entity.RolePermission;
import com.zs.entity.Users;

public class MyInterceptor extends AbstractInterceptor{

	
	IBaseDaoOfSpring dao=null;
	HttpServletRequest request;
	HttpServletResponse response;
	ApplicationContext appContext;
	Map session;
	String path;
	String reqPamrs;
	Object user;
	
	private void allInit(ActionInvocation arg0) {
		// 取得请求相关的ActionContext实例  
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		//获取bean
		appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
    	dao = (IBaseDaoOfSpring) appContext.getBean("zs_dao");
    	//获取其他信息
		ActionContext ctx = arg0.getInvocationContext();  
        session = ctx.getSession();  
        //获得url
        path = request.getRequestURI();//url
        reqPamrs = request.getQueryString();//后面的参数
        //获取登录者信息
        user =session.get("user"); 
	}
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		allInit(arg0);
		/*
        if (user==null) {
        	System.out.println("-----if (user==null) {----");
        }
        System.out.println(path);  
        */
		//以下是权限控制的核心代码
		if (user==null) {//将登录的url排除在外
			if ("/TransExc/login!login".equals(path)) {
				close();
				return arg0.invoke();
			}else {
				response.sendRedirect("error1.jsp");
				close();
				return null;
			}
		}else {
			//声明一些变量备用
			Role role=null;
			List<RolePermission> rps=null;
			//获取权限
			List<Role> roles=dao.find("from Role where id='"+((Users)user).getRole()+"'");
			if (roles.size()>0) {
				role=roles.get(0);
			}
			//以下是核心部分：根据权限+URL来决定登录者能否继续
			if ("/TransExc/file!uploadInData".equals(path) || "/TransExc/file!gotoInputInDate".equals(path)) {//上传源数据
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='1'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/file!gotoInputOutDate".equals(path) || "/TransExc/file!uploadOutData".equals(path)) {//上传最终模板
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='2'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/file!gotoInputOutDate".equals(path) || "/TransExc/file!selectModel".equals(path)) {//选择最终模板
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='3'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/file!outEndDate".equals(path)) {//处理数据
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='28'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/file!exportExc".equals(path)) {//生成文件
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='27'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!queryDx".equals(path)) {//查看电信表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='4'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!addOrUpdateDx".equals(path)) {//添加、修改电信表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='5'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!deleteDx".equals(path)) {//删除电信表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='7'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!queryYd".equals(path)) {//查看移动表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='8'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!addOrUpdateYd".equals(path)) {//添加和修改移动表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='9'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!deleteYd".equals(path)) {//删除移动表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='7'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!queryHz".equals(path)) {//查看汇总表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='12'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!addOrUpdateHz".equals(path)) {//添加和修改汇总表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='13'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!deleteHz".equals(path)) {//删除汇总表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='15'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!queryDetail".equals(path)) {//查看最终表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='16'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!addOrUpdateDe".equals(path)) {//添加和修改最终表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='17'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/manual!deleteDe".equals(path)) {//删除最终表
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='19'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/model!query".equals(path)) {//查看模版
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='20'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/model!addOrUpdateModel".equals(path)) {//添加和修改模板数据
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='21'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/model!deleteFromId".equals(path)) {//删除模板数据
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='23'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/model!add".equals(path)) {//添加模板
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='24'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/model!update".equals(path)) {//修改模板
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='25'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/model!delete".equals(path)) {//删除模板
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='26'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/users!query".equals(path)) {//查看用户
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='29'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/users!addOrUpdate".equals(path)) {//添加和修改用户
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='30'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/users!delete".equals(path)) {//添加和修改用户
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='31'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/role!query".equals(path)) {//查看角色
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='32'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/role!addOrUpdate".equals(path)) {//添加和修改角色
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='33'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/role!delete".equals(path)) {//删除角色
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='34'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/center!query".equals(path)) {//查看个人信息
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='35'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else if ("/TransExc/center!update".equals(path)) {//修改个人基本信息
				if (role!=null) {
					rps=dao.find("from RolePermission where RId='"+role.getId()+"' and PId='36'");
					if (rps.size()>0) {
						close();
						return arg0.invoke();
					}else {
						response.sendRedirect("error2.jsp");
						close();
						return null;
					}
				}
			}else {
				close();
				return arg0.invoke();
			}
		}
		
		close();
		return null;
	}
	
	private void close() {
		if (appContext!=null) {
			((ClassPathXmlApplicationContext)appContext).close();
		}

	}
}

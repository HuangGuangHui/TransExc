package com.zs.action;

import java.util.ArrayList;
import java.util.List;

import com.zs.dao.IBaseDaoOfSpring;
import com.zs.entity.InDx;
import com.zs.entity.InHz;
import com.zs.entity.InYd;
import com.zs.entity.OutDxDetail;
import com.zs.util.Page;


/*2016年7月12日15:32:35
 * 张顺
 * 手动模式的action
 * */
public class ManualModeAction extends MyBaseAction{
	
	IBaseDaoOfSpring dao;
	Page page;
	List<InDx> inDxs;
	List<InYd> inYds;
	List<InHz> inHzs;
	List<OutDxDetail> details;
	
	
	public List<InDx> getInDxs() {
		return inDxs;
	}
	public void setInDxs(List<InDx> inDxs) {
		this.inDxs = inDxs;
	}
	public List<InYd> getInYds() {
		return inYds;
	}
	public void setInYds(List<InYd> inYds) {
		this.inYds = inYds;
	}
	public List<InHz> getInHzs() {
		return inHzs;
	}
	public void setInHzs(List<InHz> inHzs) {
		this.inHzs = inHzs;
	}
	public List<OutDxDetail> getDetails() {
		return details;
	}
	public void setDetails(List<OutDxDetail> details) {
		this.details = details;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public IBaseDaoOfSpring getDao() {
		return dao;
	}
	public void setDao(IBaseDaoOfSpring dao) {
		this.dao = dao;
	}
	
	
	public String queryDx(){
		int count;
		if (0==dao.find("from InDx").size()%10) {
			count=dao.find("from InDx").size()/10;
		}else {
			count=dao.find("from InDx").size()/10+1;
		}
		if (getRequest().getParameter("pageOn")==null) {
			page=new Page(1,count, 10);
		}else {
			int no=Integer.valueOf(getRequest().getParameter("pageOn"));
			page=new Page(no,count, 10);
		}
		inDxs=dao.findOfFenYe("from InDx", (page.getPageOn()-1)*page.getSize(), page.getSize());
		return "manualInDx";
	}
	
	public String queryYd(){
		int count;
		if (0==dao.find("from InYd").size()%10) {
			count=dao.find("from InYd").size()/10;
		}else {
			count=dao.find("from InYd").size()/10+1;
		}
		if (getRequest().getParameter("pageOn")==null) {
			page=new Page(1,count, 10);
		}else {
			int no=Integer.valueOf(getRequest().getParameter("pageOn"));
			page=new Page(no,count, 10);
		}
		inYds=dao.findOfFenYe("from InYd", (page.getPageOn()-1)*page.getSize(), page.getSize());
		return "manualInYd";
	}
	
	public String queryHz(){
		int count;
		if (0==dao.find("from InHz").size()%10) {
			count=dao.find("from InHz").size()/10;
		}else {
			count=dao.find("from InHz").size()/10+1;
		}
		if (getRequest().getParameter("pageOn")==null) {
			page=new Page(1,count, 10);
		}else {
			int no=Integer.valueOf(getRequest().getParameter("pageOn"));
			page=new Page(no,count, 10);
		}
		inHzs=dao.findOfFenYe("from InHz", (page.getPageOn()-1)*page.getSize(), page.getSize());
		return "manualInHz";
	}
	
	public String queryDetail(){
		
		return "";
	}
	
	
}

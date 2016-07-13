package com.zs.action;

import java.io.UnsupportedEncodingException;
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
	
	//用于添加的对象
	InDx dx;
	InYd yd;
	InHz hz;
	OutDxDetail de;
	
	public InDx getDx() {
		return dx;
	}
	public void setDx(InDx dx) {
		this.dx = dx;
	}
	public InYd getYd() {
		return yd;
	}
	public void setYd(InYd yd) {
		this.yd = yd;
	}
	public InHz getHz() {
		return hz;
	}
	public void setHz(InHz hz) {
		this.hz = hz;
	}
	public OutDxDetail getDe() {
		return de;
	}
	public void setDe(OutDxDetail de) {
		this.de = de;
	}
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
	
	
	public String queryDx() throws NumberFormatException, UnsupportedEncodingException{
		//带上数据过去
		List<InDx> dxs=dao.find("from InDx group by month");
		getRequest().setAttribute("dxs", dxs);
		//---------------
		String hql="from InDx";
		String month=getRequest().getParameter("month");
		String number=getRequest().getParameter("number");
		if (month!=null && !"".equals(month)) {
			hql=hql+" where month='"+month+"'";
			getRequest().setAttribute("month", month);
		}
		if(number!=null && !"".equals(number.trim())) {
			hql=hql+" and equipmentNumber='"+number+"'";
		}
		//---------------
		int count;
		if (0==dao.find(hql).size()%10) {
			count=dao.find(hql).size()/10;
		}else {
			count=dao.find(hql).size()/10+1;
		}
		if (getRequest().getParameter("pageOn")==null) {
			page=new Page(1,count, 10);
		}else {
			int no=Integer.valueOf(getRequest().getParameter("pageOn"));
			page=new Page(no,count, 10);
		}
		inDxs=dao.findOfFenYe(hql, (page.getPageOn()-1)*page.getSize(), page.getSize());
		return "manualInDx";
	}
	
	public String queryYd() throws NumberFormatException, UnsupportedEncodingException{
		//带上数据过去
		List<InYd> yds=dao.find("from InYd group by month");
		getRequest().setAttribute("yds", yds);
		//---------------
		String hql="from InYd";
		String month=getRequest().getParameter("month");
		String number=getRequest().getParameter("number");
		if (month!=null && !"".equals(month)) {
			hql=hql+" where month='"+month+"'";
			getRequest().setAttribute("month", month);
		}
		if(number!=null && !"".equals(number.trim())) {
			hql=hql+" and equipmentNumber='"+number+"'";
		}
		//---------------
		int count;
		if (0==dao.find(hql).size()%10) {
			count=dao.find(hql).size()/10;
		}else {
			count=dao.find(hql).size()/10+1;
		}
		if (getRequest().getParameter("pageOn")==null) {
			page=new Page(1,count, 10);
		}else {
			int no=Integer.valueOf(getRequest().getParameter("pageOn"));
			page=new Page(no,count, 10);
		}
		inYds=dao.findOfFenYe(hql, (page.getPageOn()-1)*page.getSize(), page.getSize());
		return "manualInYd";
	}
	
	public String queryHz() throws NumberFormatException, UnsupportedEncodingException{
		//带上数据过去
		List<InHz> hzs=dao.find("from InHz group by month");
		getRequest().setAttribute("hzs", hzs);
		//---------------
		String hql="from InHz";
		String month=getRequest().getParameter("month");
		String number=getRequest().getParameter("number");
		if (month!=null && !"".equals(month)) {
			hql=hql+" where month='"+month+"'";
			getRequest().setAttribute("month", month);
		}
		if(number!=null && !"".equals(number.trim())) {
			hql=hql+" and equipmentNumber='"+number+"'";
		}
		//---------------
		int count;
		if (0==dao.find(hql).size()%10) {
			count=dao.find(hql).size()/10;
		}else {
			count=dao.find(hql).size()/10+1;
		}
		if (getRequest().getParameter("pageOn")==null) {
			page=new Page(1,count, 10);
		}else {
			int no=Integer.valueOf(getRequest().getParameter("pageOn"));
			page=new Page(no,count, 10);
		}
		inHzs=dao.findOfFenYe(hql, (page.getPageOn()-1)*page.getSize(), page.getSize());
		return "manualInHz";
	}
	
	public String queryDetail() throws NumberFormatException, UnsupportedEncodingException{
		//带上数据过去
		List<OutDxDetail> des=dao.find("from OutDxDetail group by month");
		getRequest().setAttribute("des", des);
		//---------------
		String hql="from OutDxDetail";
		String month=getRequest().getParameter("month");
		String number=getRequest().getParameter("number");
		if (month!=null && !"".equals(month)) {
			hql=hql+" where month='"+month+"'";
			getRequest().setAttribute("month", month);
		}
		if(number!=null && !"".equals(number.trim())) {
			hql=hql+" and equipmentNumber='"+number+"'";
		}
		//---------------
		int count;
		if (0==dao.find(hql).size()%10) {
			count=dao.find(hql).size()/10;
		}else {
			count=dao.find(hql).size()/10+1;
		}
		if (getRequest().getParameter("pageOn")==null) {
			page=new Page(1,count, 10);
		}else {
			int no=Integer.valueOf(getRequest().getParameter("pageOn"));
			page=new Page(no,count, 10);
		}
		details=dao.findOfFenYe(hql, (page.getPageOn()-1)*page.getSize(), page.getSize());
		return "manualDetail";
	}
	
	public String deleteDx() throws UnsupportedEncodingException {
		String id=getRequest().getParameter("id");
		if (id!=null) {
			InDx dx=(InDx) dao.get(InDx.class, Integer.valueOf(id));
			dao.delete(dx);
		}
		return queryDx();
	}
	
	public String deleteYd() throws UnsupportedEncodingException {
		String id=getRequest().getParameter("id");
		if (id!=null) {
			InYd yd=(InYd) dao.get(InYd.class, Integer.valueOf(id));
			dao.delete(yd);
		}
		return queryYd();
	}
	
	public String deleteHz() throws UnsupportedEncodingException {
		String id=getRequest().getParameter("id");
		if (id!=null) {
			InHz hz=(InHz) dao.get(InHz.class, Integer.valueOf(id));
			dao.delete(hz);
		}
		return queryHz();
	}
	
	public String deleteDe() throws UnsupportedEncodingException {
		String id=getRequest().getParameter("id");
		if (id!=null) {
			OutDxDetail de=(OutDxDetail) dao.get(OutDxDetail.class, Integer.valueOf(id));
			dao.delete(de);
		}
		return queryDetail();
	}
	
	
	public String addOrUpdateDx() throws NumberFormatException, UnsupportedEncodingException {
		//获取cz，根据cz来决定采取哪种操作
		String cz=getRequest().getParameter("cz");
		if (cz!=null) {
			if (cz.equals("add")) {
				if (dx.getEquipmentNumber()!=null 
						&& !"".equals(dx.getEquipmentNumber().trim())
						&& dx.getMonth()!=null 
						&& !"".equals(dx.getMonth().trim())) {
					dao.save(dx);
				}
			}else if (cz.equals("update")) {
				String id=getRequest().getParameter("id");
				if (dx.getEquipmentNumber()!=null 
						&& !"".equals(dx.getEquipmentNumber().trim())
						&& dx.getMonth()!=null 
						&& !"".equals(dx.getMonth().trim())) {
					dx.setId(Integer.valueOf(id));
					dao.update(dx);
				}
			}
		}
		return queryDx();
	}
	
	public String addOrUpdateYd() throws NumberFormatException, UnsupportedEncodingException {
		//获取cz，根据cz来决定采取哪种操作
		String cz=getRequest().getParameter("cz");
		if (cz!=null) {
			if (cz.equals("add")) {
				if (yd.getEquipmentNumber()!=null 
						&& !"".equals(yd.getEquipmentNumber().trim())
						&& yd.getMonth()!=null 
						&& !"".equals(yd.getMonth().trim())) {
					dao.save(yd);
				}
			}else if (cz.equals("update")) {
				String id=getRequest().getParameter("id");
				if (yd.getEquipmentNumber()!=null 
						&& !"".equals(yd.getEquipmentNumber().trim())
						&& yd.getMonth()!=null 
						&& !"".equals(yd.getMonth().trim())) {
					yd.setId(Integer.valueOf(id));
					dao.update(yd);
				}
			}
		}
		return queryYd();
	}
	
	public String addOrUpdateHz() throws NumberFormatException, UnsupportedEncodingException {
		//获取cz，根据cz来决定采取哪种操作
		String cz=getRequest().getParameter("cz");
		if (cz!=null) {
			if (cz.equals("add")) {
				if (hz.getEquipmentNumber()!=null 
						&& !"".equals(hz.getEquipmentNumber().trim())
						&& hz.getMonth()!=null 
						&& !"".equals(hz.getMonth().trim())) {
					dao.save(hz);
				}
			}else if (cz.equals("update")) {
				String id=getRequest().getParameter("id");
				if (hz.getEquipmentNumber()!=null 
						&& !"".equals(hz.getEquipmentNumber().trim())
						&& hz.getMonth()!=null 
						&& !"".equals(hz.getMonth().trim())) {
					hz.setId(Integer.valueOf(id));
					dao.update(hz);
				}
			}
		}
		return queryHz();
	}
	
	public String addOrUpdateDe() throws NumberFormatException, UnsupportedEncodingException {
		//获取cz，根据cz来决定采取哪种操作
		String cz=getRequest().getParameter("cz");
		if (cz!=null) {
			if (cz.equals("add")) {
				if (de.getEquipmentNumber()!=null 
						&& !"".equals(de.getEquipmentNumber().trim())
						&& de.getMonth()!=null 
						&& !"".equals(de.getMonth().trim())) {
					dao.save(de);
				}
			}else if (cz.equals("update")) {
				String id=getRequest().getParameter("id");
				if (de.getEquipmentNumber()!=null 
						&& !"".equals(de.getEquipmentNumber().trim())
						&& de.getMonth()!=null 
						&& !"".equals(de.getMonth().trim())) {
					de.setId(Integer.valueOf(id));
					dao.update(de);
				}
			}
		}
		return queryDetail();
	}
}

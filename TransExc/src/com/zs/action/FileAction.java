package com.zs.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;

import com.zs.dao.BaseDaoOfHibe;
import com.zs.dao.IBaseDaoOfSpring;
import com.zs.entity.InDx;
import com.zs.entity.InHz;
import com.zs.entity.InYd;
import com.zs.entity.ModelOutDxDetail;
import com.zs.entity.OutDxDetail;
import com.zs.file.Copy;
import com.zs.util.ExportExcOfJxl;
import com.zs.util.QueryExc;
import com.zs.util.QueryExcOfJxl_ZS;

public class FileAction extends MyBaseAction{

	private File files;
	private String filesFileName;
	private String month;
	private String year;
	private String time;
	String type;
	IBaseDaoOfSpring dao;
	//以下是用来保存出现异常的数据
	List<InDx> errorInDxs=null;
	List<InYd> errorInYds=null;
	List<InHz> errorInHzs=null;
	List<OutDxDetail> errorDetails=null;
	
	
	public String getTime() {
		return year+"/"+month;
	}
	public IBaseDaoOfSpring getDao() {
		return dao;
	}
	public List<InDx> getErrorInDxs() {
		return errorInDxs;
	}
	public void setErrorInDxs(List<InDx> errorInDxs) {
		this.errorInDxs = errorInDxs;
	}
	public List<InYd> getErrorInYds() {
		return errorInYds;
	}
	public void setErrorInYds(List<InYd> errorInYds) {
		this.errorInYds = errorInYds;
	}
	public List<InHz> getErrorInHzs() {
		return errorInHzs;
	}
	public void setErrorInHzs(List<InHz> errorInHzs) {
		this.errorInHzs = errorInHzs;
	}
	public List<OutDxDetail> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<OutDxDetail> errorDetails) {
		this.errorDetails = errorDetails;
	}
	public void setDao(IBaseDaoOfSpring dao) {
		this.dao = dao;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
	/*
	 * 2016年7月11日15:35:03
	 * 上传源数据,目前主要是处理电信和移动
	 * 张顺 
	 * */
	public String uploadInData() {
		QueryExcOfJxl_ZS excOfJxlZS=new QueryExcOfJxl_ZS();
		Sheet readsheet=excOfJxlZS.trans(files,0);
		//获取Sheet表中所包含的总列数   
        int rsColumns = readsheet.getColumns();   
        //获取Sheet表中所包含的总行数  
        int rsRows = readsheet.getRows();   
        //获取指定单元格的对象引用   
        //更具类型判断
		//是否是所需要的数据的标志，false否，true是
		boolean isBegin=false;
		if ("电信".equals(type)) {
			for (int i = 0; i < rsRows; i++){
				Cell cell = readsheet.getCell(0, i);
	    		String equNuber="";
	    		//找 【缴费编号】
	    		if ("缴费编号".equals(cell.getContents().trim())) {
	    			for (int j = 1; j < rsColumns; j++) {
						Cell celltemp=readsheet.getCell(j, i);
						if (!"".equals(celltemp.getContents().trim())) {
							System.out.println(celltemp.getContents());
							equNuber=celltemp.getContents();
							break;
						}
					}
				}
	    		//找纯数据，即所需要的数据
	    		if ("设备号".equals(cell.getContents().trim())) {
	    			isBegin=true;
	    			continue;
				}
	    		if ("合计:".equals(cell.getContents().trim())) {
					isBegin=false;
	    			continue;
				}
	    		//保存数据
	    		if (isBegin) {
	    			String str=readsheet.getCell(7, i).getContents().trim();
	    			String ss1[]=str.split(" ");
	    			ArrayList<String> ss2=new ArrayList<String>();
	    			
	    			for (int j = 0; j < ss1.length; j++) {
						if (!"".equals(ss1[j].trim())) {
							ss2.add(ss1[j]);
						}
					}
	    			/*
	    			 * 避免上传了重复的数据，每次遇到重复的，就会先删除原来的再上传现在的。
	    			 * */
	    			List<InDx> dxs=dao.find("from InDx where equipmentNumber='"+readsheet.getCell(0, i).getContents().trim()+"' and month='"+getTime()+"'");
	    			for (int j = 0; j < dxs.size(); j++) {
						dao.delete(dxs.get(j));
					}
	    			
					InDx inDx=new InDx(
							readsheet.getCell(0, i).getContents().trim(),
	    					readsheet.getCell(3, i).getContents().trim(),
	    					Double.valueOf(ss2.get(0).trim()),
	    					Double.valueOf(ss2.get(1).trim()),
	    					Double.valueOf(ss2.get(2).trim()),
	    					Double.valueOf(ss2.get(3).trim()),
	    					Double.valueOf(ss2.get(4).trim()),
	    					Double.valueOf(ss2.get(5).trim()),
	    					Double.valueOf(ss2.get(6).trim()),
	    					Double.valueOf(ss2.get(7).trim()),
	    					Double.valueOf(ss2.get(8).trim()),
	    					Double.valueOf(ss2.get(9).trim()),
	    					Double.valueOf(ss2.get(10).trim()),
	    					Double.valueOf(ss2.get(11).trim()),
	    					Double.valueOf(ss2.get(12).trim()),
	    					Double.valueOf(ss2.get(13).trim()),
	    					getTime());
					dao.save(inDx);
					
					
				}
			}
		}else if ("移动".equals(type)) {
			for (int i = 0; i < rsRows; i++){
				Cell cell = readsheet.getCell(0, i);
	    		//找纯数据，即所需要的数据
	    		if ("序号".equals(cell.getContents().trim())) {
	    			isBegin=true;
	    			continue;
				}
	    		//保存数据
	    		if (isBegin && !"".equals(readsheet.getCell(2, i).getContents().trim())) {
	    			double cost,costMust;
	    			if ("".equals(readsheet.getCell(4, i).getContents().trim())) {
						cost=0;
					}else {
						cost=Double.valueOf(readsheet.getCell(4, i).getContents().trim());
					}
	    			if ("".equals(readsheet.getCell(5, i).getContents().trim())) {
						costMust=0;
					}else {
						costMust=Double.valueOf(readsheet.getCell(5, i).getContents().trim());
					}
	    			/*
	    			 * 避免上传了重复的数据，每次遇到重复的，就会先删除原来的再上传现在的。
	    			 * */
	    			List<InYd> inYds=dao.find("from InYd where equipmentNumber='"+readsheet.getCell(2, i).getContents().trim()+"' and month='"+getTime()+"'");
	    			for (int j = 0; j < inYds.size(); j++) {
						dao.delete(inYds.get(j));
					}
	    			InYd inYd=new InYd(
	    					readsheet.getCell(1, i).getContents().trim(),
	    					readsheet.getCell(2, i).getContents().trim(),
	    					readsheet.getCell(3, i).getContents().trim(), 
	    					cost,
	    					costMust,
	    					getTime());
					dao.save(inYd);
				}
			}
		}else if ("汇总".equals(type)) {
			for (int i = 0; i < rsRows; i++){
				Cell cell = readsheet.getCell(0, i);
	    		//找纯数据，即所需要的数据
	    		if ("产品号码".equals(cell.getContents().trim())) {
	    			isBegin=true;
	    			continue;
				}
	    		//保存数据
	    		if (isBegin && !"".equals(readsheet.getCell(0, i).getContents().trim())) {
	    			double cost;
	    			if ("".equals(readsheet.getCell(2, i).getContents().trim())) {
						cost=0;
					}else {
						cost=Double.valueOf(readsheet.getCell(2, i).getContents().trim());
					}
	    			/*
	    			 * 避免上传了重复的数据，每次遇到重复的，就会先删除原来的再上传现在的。
	    			 * */
	    			List<InHz> hzs=dao.find("from InHz where equipmentNumber='"+readsheet.getCell(0, i).getContents().trim()+"' and month='"+getTime()+"'");
	    			for (int j = 0; j < hzs.size(); j++) {
						dao.delete(hzs.get(j));
					}
	    			InHz hz=new InHz(
	    					readsheet.getCell(0, i).getContents().trim(),
	    					readsheet.getCell(1, i).getContents().trim(),
	    					cost,
	    					getTime());
					dao.save(hz);
				}
			}
		}
		excOfJxlZS.close();
		return "inputIn";
	}
	
	
	/*2016年7月11日15:38:58
	 * 张顺
	 * 上传最终的数据，主要作用是获取格式
	 * */
	public String uploadOutData() throws Exception {
		QueryExcOfJxl_ZS excOfJxlZS=new QueryExcOfJxl_ZS();
		Sheet readsheet=excOfJxlZS.trans(files,0);
		//获取Sheet表中所包含的总列数   
        int rsColumns = readsheet.getColumns();   
        //获取Sheet表中所包含的总行数  
        int rsRows = readsheet.getRows();   
        //获取指定单元格的对象引用   
        //更具类型判断
    	for (int i = 0; i < rsRows; i++){   
    		Cell cell = readsheet.getCell(0, i);
    		if ("序号".equals(cell.getContents()) || "".equals(readsheet.getCell(3, i).getContents().trim())) {
            	continue;
            }else {
            	/*
    			 * 避免上传了重复的数据，每次遇到重复的，就会先删除原来的再上传现在的。
    			 * */
    			List<OutDxDetail> details=dao.find("from OutDxDetail where equipmentNumber='"+readsheet.getCell(3, i).getContents().trim()+"' and month='"+getTime()+"'");
    			for (int j = 0; j < details.size(); j++) {
					dao.delete(details.get(j));
				}
    			//不用担心是否上传了带数据的模板，上传时程序会自动滤过该列数据
        		OutDxDetail detail=new OutDxDetail(
        				readsheet.getCell(1, i).getContents().trim(),
        				readsheet.getCell(2, i).getContents().trim(),
        				readsheet.getCell(3, i).getContents().trim(),
        				readsheet.getCell(6, i).getContents().trim(),
        				"",
        				readsheet.getCell(8, i).getContents().trim(),
        				readsheet.getCell(9, i).getContents().trim(),
        				getTime());
        		dao.save(detail);
			}
    	}
	    excOfJxlZS.close();
	    return gotoInputOutDate();
	}
	
	
	/*
	 * 2016年7月8日17:17:46
	 * 张顺
	 * 根据原数据得到整理后的数据
	 * */
	public String outEndDate() throws UnsupportedEncodingException {
		//清空集合
		errorInDxs=null;
		errorInYds=null;
		errorInHzs=null;
		//两个时间，用于计算耗时
		long starTime=System.currentTimeMillis();
		//查询原数据
		List<InDx> listDx=dao.find("from InDx where month='"+getTime()+"'");
		List<InYd> listYd=dao.find("from InYd where month='"+getTime()+"'");
		List<InHz> listHz=dao.find("from InHz where month='"+getTime()+"'");
		//找到对应的数据，并将数据填入
		for (int i = 0; i < listDx.size(); i++) {
			InDx dx=listDx.get(i);
			List<OutDxDetail> details=dao.find("from OutDxDetail where equipmentNumber='"+dx.getEquipmentNumber()+"' and month='"+getTime()+"'");
			if (details.size()>0) {
				OutDxDetail detail=details.get(0);
				detail.setMonthMonry(dx.getCostMustPay()+"");
				dao.update(detail);
			}else {
				errorInDxs=new ArrayList<InDx>();
				errorInDxs.add(dx);
			}
		}
		for (int i = 0; i < listYd.size(); i++) {
			InYd yd=listYd.get(i);
			List<OutDxDetail> details=dao.find("from OutDxDetail where equipmentNumber='"+yd.getEquipmentNumber()+"' and month='"+getTime()+"'");
			if (details.size()>0) {
				OutDxDetail detail=details.get(0);
				detail.setMonthMonry(yd.getCostMustPay()+"");
				dao.update(detail);
			}else {
				errorInYds=new ArrayList<InYd>();
				errorInYds.add(yd);
			}
		}
		for (int i = 0; i < listHz.size(); i++) {
			InHz hz=listHz.get(i);
			List<OutDxDetail> details=dao.find("from OutDxDetail where equipmentNumber='"+hz.getEquipmentNumber()+"' and month='"+getTime()+"'");
			if (details.size()>0) {
				OutDxDetail detail=details.get(0);
				detail.setMonthMonry(hz.getCost()+"");
				dao.update(detail);
			}else {
				errorInHzs=new ArrayList<InHz>();
				errorInHzs.add(hz);
			}
		}
		//用于计算耗时
		long endTime=System.currentTimeMillis();
		getRequest().setAttribute("cost_time", endTime-starTime);
		System.out.println("耗时-->>"+(endTime-starTime)); 
		return exportExc();
	}
	
	/*
	 * 2016年7月11日13:48:32
	 * 张顺
	 * 生成最终的Excle文件
	 * */
	public String exportExc() {
		//查询最终表数据
		List<OutDxDetail> list=dao.find("from OutDxDetail");
		boolean isSuc=new ExportExcOfJxl().export(list); 
		System.out.println("-------成功与否------>>"+isSuc);
		return "output";
	}
	
	/*
	 * 2016年7月11日13:42:21
	 * 张顺
	 * 空方法用于实现安全刷新,解决了刷新导致重复提交的问题
	 * 2016年7月11日16:12:54
	 *由于前台用了frame框架，所以用不着这个功能了
	 * */
	public String safe() {
		return SUCCESS;
	}
	
	
	/*2016年7月13日10:43:10
	 * 张顺
	 * 作用是把模板的数据带过去
	 * */
	public String gotoInputOutDate() throws UnsupportedEncodingException {
		List<String> modelNames=dao.find("select modelName from ModelOutDxDetail group by modelName");
		getRequest().setAttribute("modelNames", modelNames);
		return "inputOut";
	}
	
	
	public String selectModel() throws UnsupportedEncodingException {
		String modelName=getRequest().getParameter("mname");
		List<ModelOutDxDetail> models=dao.find("from ModelOutDxDetail where modelName='"+modelName+"'");
		System.out.println(models.size()+modelName);
		/*
		 * 避免上传了重复的数据，每次遇到重复的，就会先删除原来的再上传现在的。
		 * */
		List<OutDxDetail> details=dao.find("from OutDxDetail where month='"+getTime()+"'");
		for (int j = 0; j < details.size(); j++) {
			dao.delete(details.get(j));
		}
		//不用担心是否上传了带数据的模板，上传时程序会自动滤过该列数据
		for (int j = 0; j < models.size(); j++) {
			ModelOutDxDetail m=models.get(j);
			OutDxDetail detail=new OutDxDetail(
				m.getType(),
				m.getDepartment(),
				m.getEquipmentNumber(),
				m.getNote(),
				m.getMonthMonry(),
				m.getFirstDepartment(),
				m.getInvoice(),
				getTime()
			);
			dao.save(detail);
		}
		return gotoInputOutDate();
	}
}

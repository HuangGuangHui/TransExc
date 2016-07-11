package com.zs.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;

import com.zs.dao.BaseDaoOfHibe;
import com.zs.dao.IBaseDaoOfSpring;
import com.zs.entity.InDx;
import com.zs.entity.OutDxDetail;
import com.zs.file.Copy;
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
	
	
	public String getTime() {
		return year+"/"+month;
	}
	public IBaseDaoOfSpring getDao() {
		return dao;
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
	
	
	public String transtion() throws Exception {
		QueryExcOfJxl_ZS excOfJxlZS=new QueryExcOfJxl_ZS();
		Sheet readsheet=excOfJxlZS.trans(files,0);
		//获取Sheet表中所包含的总列数   
        int rsColumns = readsheet.getColumns();   
        //获取Sheet表中所包含的总行数   
        int rsRows = readsheet.getRows();   
        //获取指定单元格的对象引用   
        //更具类型判断
        if ("最终".equals(type)) {
        	for (int i = 0; i < rsRows; i++){   
        		Cell cell = readsheet.getCell(0, i);
        		if ("序号".equals(cell.getContents())) {
                	continue;
                }else {
            		OutDxDetail detail=new OutDxDetail(
            				readsheet.getCell(1, i).getContents().trim(),
            				readsheet.getCell(2, i).getContents().trim(),
            				readsheet.getCell(3, i).getContents().trim(),
            				readsheet.getCell(6, i).getContents().trim(),
            				readsheet.getCell(7, i).getContents().trim(),
            				readsheet.getCell(8, i).getContents().trim(),
            				readsheet.getCell(9, i).getContents().trim(),
            				getTime());
            		dao.save(detail);
    			}
        	}
    	}else if("来源".equals(type)){
    		//是否是所需要的数据的标志，false否，true是
    		boolean isBegin=false;
    		for (int i = 0; i < rsRows; i++){
    			Cell cell = readsheet.getCell(0, i);
        		String equNuber="";
        		//找 【缴费编号】
        		if ("缴费编号：".equals(cell.getContents().trim())) {
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
    				InDx inDx=new InDx(readsheet.getCell(0, i).getContents().trim(),
        					readsheet.getCell(1, i).getContents().trim(),
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
    	} 
	    excOfJxlZS.close();
	    outEndDate();
	    return SUCCESS;
	}
	
	
	/*
	 * 2016年7月8日17:17:46
	 * 张顺
	 * 根据原数据得到整理后的数据
	 * */
	
	private void outEndDate() {
		//查询原数据
		List<InDx> list=dao.find("from InDx where month='"+getTime()+"'");
		//找到对应的数据，并将数据填入
		for (int i = 0; i < list.size(); i++) {
			InDx dx=list.get(i);
			List<OutDxDetail> details=dao.find("from OutDxDetail where equipmentNumber='"+dx.getEquipmentNumber()+"' and month='"+getTime()+"'");
			if (details.size()>0) {
				OutDxDetail detail=details.get(0);
				detail.setMonthMonry(dx.getCostMustPay()+"");
				dao.update(detail);
			}
		}
		
	}
	
	
}

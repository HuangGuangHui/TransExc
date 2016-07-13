package com.zs.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;

import com.zs.dao.IBaseDaoOfSpring;
import com.zs.entity.ModelOutDxDetail;
import com.zs.entity.OutDxDetail;
import com.zs.file.NameOfDate;
import com.zs.util.Page;
import com.zs.util.QueryExcOfJxl_ZS;

public class ModelManagerAction extends MyBaseAction{
	File files;
	IBaseDaoOfSpring dao;
	List<ModelOutDxDetail> model;
	Page page;
	String modelName;
	ModelOutDxDetail mod;
	
	public ModelOutDxDetail getMod() {
		return mod;
	}
	public void setMod(ModelOutDxDetail mod) {
		this.mod = mod;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public File getFiles() {
		return files;
	}
	public void setFiles(File files) {
		this.files = files;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<ModelOutDxDetail> getModel() {
		return model;
	}
	public void setModel(List<ModelOutDxDetail> model) {
		this.model = model;
	}
	public IBaseDaoOfSpring getDao() {
		return dao;
	}
	public void setDao(IBaseDaoOfSpring dao) {
		this.dao = dao;
	}
	
	
	public String query() throws UnsupportedEncodingException {
		//带上模板的数据
		List<ModelOutDxDetail> models=dao.find("from ModelOutDxDetail group by modelName");
		getRequest().setAttribute("models", models);
		//以下是所有的部分,判断是否有筛选条件
		String mname=getRequest().getParameter("mname");
		if (mname==null || "".equals(mname)) {
			int count;
			if (0==dao.find("from ModelOutDxDetail").size()%10) {
				count=dao.find("from ModelOutDxDetail").size()/10;
			}else {
				count=dao.find("from ModelOutDxDetail").size()/10+1;
			}
			if (getRequest().getParameter("pageOn")==null) {
				page=new Page(1,count, 10);
			}else {
				int no=Integer.valueOf(getRequest().getParameter("pageOn"));
				page=new Page(no,count, 10);
			}
			model=dao.findOfFenYe("from ModelOutDxDetail", (page.getPageOn()-1)*page.getSize(), page.getSize());
		}else {
			int count;
			String hql="from ModelOutDxDetail where modelNameKey='"+mname+"'";
			getRequest().setAttribute("mname", mname);
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
			model=dao.findOfFenYe(hql, (page.getPageOn()-1)*page.getSize(), page.getSize());
		}
		return "modelQuery";
	}
	
	
	public String add() {
		//获取唯一的KEY
		String key="model"+new NameOfDate().getFileName();
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
    			List<ModelOutDxDetail> details=dao.find("from ModelOutDxDetail where equipmentNumber='"+readsheet.getCell(3, i).getContents().trim()+"' and model_name='"+modelName+"'");
    			for (int j = 0; j < details.size(); j++) {
					dao.delete(details.get(j));
				}
    			//不用担心是否上传了带数据的模板，上传时程序会自动滤过该列数据
    			ModelOutDxDetail model=new ModelOutDxDetail(
        				readsheet.getCell(1, i).getContents().trim(),
        				readsheet.getCell(2, i).getContents().trim(),
        				readsheet.getCell(3, i).getContents().trim(),
        				readsheet.getCell(6, i).getContents().trim(),
        				"",
        				readsheet.getCell(8, i).getContents().trim(),
        				readsheet.getCell(9, i).getContents().trim(),
        				modelName,
        				key);
        		dao.save(model);
			}
    	}
	    excOfJxlZS.close();
		return "modelAdd";
	}
	
	
	public String update() throws UnsupportedEncodingException {	
		//带上模板的数据
		List<ModelOutDxDetail> models=dao.find("from ModelOutDxDetail group by modelName");
		getRequest().setAttribute("models", models);
		String key=getRequest().getParameter("mname");
		String newName=getRequest().getParameter("newName");
		if (key!=null && newName!=null) {
			List<ModelOutDxDetail> list1=dao.find("from ModelOutDxDetail where modelNameKey='"+key+"'");
			for (int i = 0; i < list1.size(); i++) {
				ModelOutDxDetail tempModel=list1.get(i);
				tempModel.setModelName(newName);
				dao.update(tempModel);
			}
		}
		return "modelUpdate";
	}
	
	public String delete() throws UnsupportedEncodingException {	
		//带上模板的数据
		List<ModelOutDxDetail> models=dao.find("from ModelOutDxDetail group by modelName");
		getRequest().setAttribute("models", models);
		
		String key=getRequest().getParameter("mname");
		if (key!=null) {
			List<ModelOutDxDetail> list1=dao.find("from ModelOutDxDetail where modelNameKey='"+key+"'");
			for (int i = 0; i < list1.size(); i++) {
				ModelOutDxDetail tempModel=list1.get(i);
				dao.delete(tempModel);
			}
		}
		return "modelDelete";
	}
	
	
	public String deleteFromId() throws UnsupportedEncodingException {
		String id=getRequest().getParameter("id");
		if (id!=null) {
			ModelOutDxDetail mo=(ModelOutDxDetail) dao.get(ModelOutDxDetail.class, Integer.valueOf(id));
			dao.delete(mo);
		}
		return query();
	}
	
	public String addOrUpdateModel() throws UnsupportedEncodingException {
		//获取cz，根据cz来决定采取哪种操作
		String cz=getRequest().getParameter("cz");
		if (cz!=null) {
			if (cz.equals("add")) {
				if (mod.getEquipmentNumber()!=null 
						&& !"".equals(mod.getEquipmentNumber().trim())
						&& mod.getMonth()!=null 
						&& !"".equals(mod.getMonth().trim())) {
					dao.save(mod);
				}
			}else if (cz.equals("update")) {
				String id=getRequest().getParameter("id");
				if (mod.getEquipmentNumber()!=null 
						&& !"".equals(mod.getEquipmentNumber().trim())
						&& mod.getMonth()!=null 
						&& !"".equals(mod.getMonth().trim())) {
					mod.setId(Integer.valueOf(id));
					dao.update(mod);
				}
			}
		}
		return query();
	}
}

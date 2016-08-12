package com.zs.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.zs.entity.OutDxDetail;

import jxl.Cell;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.Boolean;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;



public class ExportExcOfJxl {
	
	
	
	public boolean export(List<OutDxDetail> data,String path) {
		boolean isSucc=false;
		OutputStream os = null;
		WritableWorkbook wwb = null;
		try {
			String filePath = path+"output/outputExcle.xls";
			File file = new File(filePath);
			//如果指定文件不存在，则新建该文件
			if(file.isFile()){
				file.delete();
			}else {
				file.createNewFile();
			}
			os = new FileOutputStream(file);//创建一个输出流
			wwb = Workbook.createWorkbook(os);
			WritableSheet sheet = wwb.createSheet("明细表", 0);//创建一个工作页，第一个参数的页名，第二个参数表示该工作页在excel中处于哪一页
			
			//第一种格式：居中，带边框
			WritableCellFormat wcf1 =new WritableCellFormat();
			wcf1.setAlignment(Alignment.CENTRE);// 对齐方式
			wcf1.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf1.setBorder(Border.ALL, BorderLineStyle.THIN);// 边框
			//第一种格式：居左，带边框
			WritableCellFormat wcf2 =new WritableCellFormat();
			wcf2.setAlignment(Alignment.LEFT);// 对齐方式
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);// 边框
			
			sheet.getSettings().setDefaultColumnWidth(20); // 设置列的默认宽度
			// sheet.setRowView(2,false);//行高自动扩展
			// setRowView(int row, int height);--行高
			// setColumnView(int col,int width); --列宽
			sheet.setColumnView(0, 6);// 设置第一列宽度
			sheet.setRowView(0, 500);// 设置第一列高度
			
			String[] title={"序号","类型","二级部门","费用项目","备注","【多少】月份","一级部门","发票号码"};
			for (int i = 0; i < title.length; i++) {
				Label label=new Label(i, 0, title[i],wcf2);
				sheet.addCell(label);
			}
			
			Label label=null;
			Number nb = null;
			
			for (int i = 0; i < data.size(); i++) {
				OutDxDetail detail=data.get(i);
					nb = new Number(0,i+1,i+1,wcf1);
					sheet.addCell(nb);
					label=new Label(1, i+1, detail.getType(),wcf2);
					sheet.addCell(label);
					label=new Label(2, i+1, detail.getDepartment(),wcf2);
					sheet.addCell(label);
					label=new Label(3, i+1, detail.getEquipmentNumber(),wcf2);
					sheet.addCell(label);
					label=new Label(4, i+1, detail.getNote(),wcf2);
					sheet.addCell(label);
					if ("".equals(detail.getMonthMonry())) {
						label=new Label(5, i+1, detail.getMonthMonry(),wcf2);
						sheet.addCell(label);
					}else{
						nb=new Number(5, i+1, Double.valueOf(detail.getMonthMonry()),wcf1);
						sheet.addCell(nb);
					}
					label=new Label(6, i+1, detail.getFirstDepartment(),wcf2);
					sheet.addCell(label);
					label=new Label(7, i+1, detail.getInvoice(),wcf2);
					sheet.addCell(label);
			}
			isSucc=true;
			/*
			//第一个参数表示列，第二个参数表示行
			Label label = new Label(0,0,"test");//填充第一行第一个单元格的内容
			sheet.addCell(label);
			WritableFont wf = new WritableFont(WritableFont.TIMES, 18, WritableFont.BOLD, true);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			label = new Label(0,1,"font",wcf);//定制单元格格式
			sheet.addCell(label);
			NumberFormat nf = new NumberFormat("#.###");//格式化数字
			wcf = new WritableCellFormat(nf);
			Number nb = new Number(0,2,3.1415926,wcf);
			sheet.addCell(nb);
			Boolean labelB = new Boolean(0, 3, false); //填充布尔型数据
			sheet.addCell(labelB); 
			DateTime labelDT = new DateTime(0, 4, new java.util.Date()); //添加日期
			sheet.addCell(labelDT); 
			DateFormat df = new DateFormat("yyyy-MM-dd hh:mm:ss"); //添加时间
			WritableCellFormat wcfDF = new WritableCellFormat(df); 
			DateTime labelDTF = new DateTime(0, 5, new java.util.Date(), wcfDF); 
			sheet.addCell(labelDTF); 
			WritableFont wfc = new WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.GREEN);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc); 
			wcfFC.setBackground(jxl.format.Colour.RED);//设置单元格的颜色为红色 
			label = new jxl.write.Label(0,6,"i love china",wcfFC);
			sheet.addCell(label);
			*/
			wwb.write();//将内容写到excel文件中
			os.flush();//清空输出流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally {
			try {
				if(wwb != null)
					wwb.close();
				if(os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
		return isSucc;
	}
	
}

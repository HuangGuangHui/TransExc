package com.zs.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
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



public class ExportExcOfJxlExample {
	
	
	
	public static void main(String[] args) {
		OutputStream os = null;
		WritableWorkbook wwb = null;
		try {
			String filePath = "D:\\Test.xls";
			File file = new File(filePath);
			if(!file.isFile())//���ָ���ļ������ڣ����½����ļ�
			file.createNewFile();
			os = new FileOutputStream(file);//����һ�������
			wwb = Workbook.createWorkbook(os);
			WritableSheet sheet = wwb.createSheet("sheet1", 0);//����һ������ҳ����һ��������ҳ�����ڶ���������ʾ�ù���ҳ��excel�д�����һҳ
			//��һ��������ʾ�У��ڶ���������ʾ��
			Label label = new Label(0,0,"test");//����һ�е�һ����Ԫ�������
			sheet.addCell(label);
			WritableFont wf = new WritableFont(WritableFont.TIMES, 18, WritableFont.BOLD, true);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			label = new Label(0,1,"font",wcf);//���Ƶ�Ԫ���ʽ
			sheet.addCell(label);
			NumberFormat nf = new NumberFormat("#.###");//��ʽ������
			wcf = new WritableCellFormat(nf);
			Number nb = new Number(0,2,3.1415926,wcf);
			sheet.addCell(nb);
			Boolean labelB = new Boolean(0, 3, false); //��䲼��������
			sheet.addCell(labelB); 
			DateTime labelDT = new DateTime(0, 4, new java.util.Date()); //�������
			sheet.addCell(labelDT); 
			DateFormat df = new DateFormat("yyyy-MM-dd hh:mm:ss"); //���ʱ��
			WritableCellFormat wcfDF = new WritableCellFormat(df); 
			DateTime labelDTF = new DateTime(0, 5, new java.util.Date(), wcfDF); 
			sheet.addCell(labelDTF); 
			WritableFont wfc = new WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.GREEN);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc); 
			wcfFC.setBackground(jxl.format.Colour.RED);//���õ�Ԫ�����ɫΪ��ɫ 
			label = new jxl.write.Label(0,6,"i love china",wcfFC);
			sheet.addCell(label);
			wwb.write();//������д��excel�ļ���
			os.flush();//��������
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
	}
}

package com.zs.util;
import java.io.File;   

import java.io.FileInputStream;   
  
import java.io.InputStream;   
import java.util.Date;

import com.zs.dao.BaseDaoOfHibe;
import com.zs.entity.OutDxDetail;
  
    
  
import jxl.Cell;   
  
import jxl.CellType;   
  
import jxl.Sheet;   
  
import jxl.Workbook;   
  
import jxl.write.Label;



public class QueryExcOfJxl_ZS {
	
	/*
	 public void trans(File file,String time){   
        jxl.Workbook readwb = null;   
        try{   
            //����Workbook����, ֻ��Workbook����   
            //ֱ�Ӵӱ����ļ�����Workbook   
        	//"D:/�û�Ŀ¼/�ҵ��ĵ�/Tencent Files/1217360619/FileRecv/5�·�/�ϴ�5�µ��ŷѺ˶�.xls"
            InputStream instream = new FileInputStream(file);   
            readwb = Workbook.getWorkbook(instream);   
            //Sheet���±��Ǵ�0��ʼ   
            //��ȡ��һ��Sheet��   
            Sheet readsheet = readwb.getSheet(0);   
            //��ȡSheet������������������   
            int rsColumns = readsheet.getColumns();   
            //��ȡSheet������������������   
            int rsRows = readsheet.getRows();   
            //��ȡָ����Ԫ��Ķ�������   
            for (int i = 0; i < rsRows; i++){   
            	Cell cell = readsheet.getCell(0, i);
            	if ("���".equals(cell.getContents())) {
                	continue;
                }else {
                	OutDxDetail detail=new OutDxDetail(readsheet.getCell(1, i).getContents(),
                			readsheet.getCell(2, i).getContents(),
                			readsheet.getCell(3, i).getContents(),
                			readsheet.getCell(4, i).getContents(),
                			readsheet.getCell(5, i).getContents(),
                			readsheet.getCell(6, i).getContents(),
                			readsheet.getCell(7, i).getContents(),
                			time);
                	BaseDaoOfHibe.save(detail);
				}
                System.out.println();   
            }  
            
            //�����Ѿ�������Excel������,�����µĿ�д���Excel������   
            jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File("D:/�û�Ŀ¼/�ҵ��ĵ�/Tencent Files/1217360619/FileRecv/5�·�/5�·ݵ��ŷ������أ������ṩ��/����2.xls"), readwb);   
            //��ȡ��һ�Ź�����   
            jxl.write.WritableSheet ws = wwb.getSheet(0);   
            //��õ�һ����Ԫ�����   
            jxl.write.WritableCell wc = ws.getWritableCell(0, 0);   
            //�жϵ�Ԫ�������, ������Ӧ��ת��   
            if (wc.getType() == CellType.LABEL)    
            {   
                Label l = (Label) wc;   
                l.setString("������");   
            }   
            //д��Excel����   
            wwb.write();   
            wwb.close();  
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            readwb.close();   
        }   
	}   
	 
	*/
	
	Workbook readwb = null; 
	
	/*
	 * 2016��7��8��15:46:59
	 * ��˳
	 * ����ǵ�����close
	 * */
	 public Sheet trans(File file,int number){   
		 
		 Sheet readsheet=null;
	        try{   
	            //����Workbook����, ֻ��Workbook����   
	            //ֱ�Ӵӱ����ļ�����Workbook   
	        	//"D:/�û�Ŀ¼/�ҵ��ĵ�/Tencent Files/1217360619/FileRecv/5�·�/�ϴ�5�µ��ŷѺ˶�.xls"
	            InputStream instream = new FileInputStream(file);   
	            readwb = Workbook.getWorkbook(instream);   
	            //Sheet���±��Ǵ�0��ʼ   
	            //��ȡ��һ��Sheet��   
	            readsheet = readwb.getSheet(number); 
	          
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } 
        return readsheet;
	 }
	 
	 public void close() {
		 readwb.close();
	}
}

package com.zs.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
	
	public String upload(File f,String name) throws InterruptedException, IOException {
		FileInputStream fis=new FileInputStream(f);
		String path="D:/apache-tomcat-6.0.37/webapps/Test/upload";
		String dirPath=new NameOfDate().getDir();
		File dir=new File(path+"/"+dirPath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		String fName=new NameOfDate().getFileName()+name.substring(name.lastIndexOf("."));
		File tageFile=new File(path+"/"+dirPath+"/"+fName);
		while (tageFile.exists()) {
			Thread.sleep(20);
			fName=new NameOfDate().getFileName()+name.substring(name.lastIndexOf("."));
		}
		tageFile.createNewFile();
		System.out.println(tageFile);
		FileOutputStream fos=new FileOutputStream(tageFile);
		byte b[]=new byte[1024];
		while(fis.read(b)!=-1){
			fos.write(b);
		}
		
		System.out.println(dirPath);
		System.out.println(fName);
		return dirPath+"/"+fName;
	}
}

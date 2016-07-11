package com.zs.file;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NameOfDate {
	public String getDir() {
		return new SimpleDateFormat("yyyy-MM").format(new Date());
	}
	public String getFileName() {
		return new SimpleDateFormat("ddHHmmssSSS").format(new Date());
	}
}

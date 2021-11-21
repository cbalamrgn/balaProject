package com.library;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClass {
	public void writeData(String sheetName,int rowno,int cellno,String data) throws IOException {
		File f = new File("C:\\Users\\balam\\eclipse-workspace\\FrameworkMaven\\Excel Maintenance\\Newfile.xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet s = book.createSheet(sheetName);
		Row r = s.createRow(rowno);
		Cell c = r.createCell(cellno);
		c.setCellValue(data);
		FileOutputStream out = new FileOutputStream(f);
		book.write(out);
	}
	
	
	
	

	}



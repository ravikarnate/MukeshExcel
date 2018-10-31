package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	public XSSFWorkbook wb;;
	public XSSFSheet sheet1;

	public ExcelDataConfig(String excelpath)
	{
	
	try {
		File fi = new File(excelpath);
		FileInputStream fis = new FileInputStream(fi);
		 wb = new XSSFWorkbook(fis);
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
	}
	
	public String getData(int sheetNumber, int row, int column)
	{
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex)
	{
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
	    return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

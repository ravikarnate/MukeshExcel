import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File fi = new File("/home/ravindranath/Downloads/mukeshexcel.xlsx");
		FileInputStream fis = new FileInputStream(fi);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		/*
		String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data from excel is " +data0);
		
		String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Data from excel is " +data1);
        */
		
		int rowcount = sheet1.getLastRowNum();
		System.out.println("Row count of excel " +rowcount);
		
		for(int i=0; i<rowcount; i++)
		{
			String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Data from Row "+i+" is " +data0);
		}
		
		wb.close();
	}

}

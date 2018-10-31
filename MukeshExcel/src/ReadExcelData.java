import lib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExcelDataConfig excel = new ExcelDataConfig("/home/ravindranath/Downloads/mukeshexcel.xlsx");
		
		System.out.println(excel.getData(0, 0, 0));

	}

}

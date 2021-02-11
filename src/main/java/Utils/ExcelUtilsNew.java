package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

public class ExcelUtilsNew {
	 public static File file;
	   public static Sheet sheet1 ;
	   public static FileInputStream fis;
	   public static HSSFRow row;
	   public static HSSFWorkbook wb;		   

	
	 public static String getUserData(String excelPath){
	   
		 file = new File(excelPath);
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				wb = new HSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sheet1 =  wb.getSheetAt(0);
			 int rowCount = sheet1.getLastRowNum()+1;
			 System.out.println("rowcount:" +rowCount);
	         int colCount = sheet1.getRow(0).getLastCellNum();
	         System.out.println("colcount:" +colCount);
	
	for(int i=0;i<=rowCount;i++)
	{
		 String sheetUserType= sheet1.getRow(i).getCell(0).getStringCellValue();
		 System.out.println("sheetUserType:" +sheetUserType);
			
		   }
	return null;
	
}
		public static String getExcelValue(int SheetNumber,int row,int column)
		{
		String excelPath = "C:/Users/DELL/eclipse-workspace/AmazonAssignment/src/test/resources/AmazonTestData/TestData1.xls";

String data= sheet1.getRow(row).getCell(column).getStringCellValue();
return data;
}
}

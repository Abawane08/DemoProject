package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;


public class ExcelUtils {
	
	public static File file;
	   public static HSSFSheet sheet1 ;
	   public static FileInputStream fis;
	   public static Row row;
	   public static HSSFWorkbook wb;
	   
	   
	//New thing added   
	public static HashMap<String,HashMap<String,String>> getUserData(String excelPath,String sheetName,String userType)
	{
		String sheetUserType, sheetColumnName, sheetColumnValue  = null;
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
		sheet1 =  wb.getSheet(sheetName);
		
		//Hashmap needed to input row with usertype as the key
		HashMap<String,HashMap<String,String>> hm = new HashMap<String,HashMap<String,String>>();
		//Hashmap needed to input keys as column name and column values as the values
		HashMap<String,String> hc = new HashMap<String,String>();
		
		//Get the row count
		int rowCount = sheet1.getLastRowNum()+1;
		
		//Get the column count
		int colCount = sheet1.getRow(0).getLastCellNum();
		
		for(int i=1;i<rowCount;i++)
		{
			sheetUserType = sheet1.getRow(i).getCell(0).getStringCellValue();
			
			//Get the sheetUserType from excel one by one and compare it with user type passed in script
			if(sheetUserType.equalsIgnoreCase(userType))
			{
				for(int j=1;j<colCount;j++)
				{   
					//Get the column name and corresponding column value
					sheetColumnName = sheet1.getRow(0).getCell(j).getStringCellValue();
					sheetColumnValue = sheet1.getRow(i).getCell(j).getStringCellValue();

					//log.info(sheetColumnName+" : "+sheetColumnValue);
					hc.put(sheetColumnName, sheetColumnValue);
				}
			}
		}
		//return the hashmap
		hm.put(userType, hc);
		return hm;
		
	}
	
	
	public static String getExcelValue(String sheetName,String userType,String columnName)
	{
		String excelPath = "C:/Users/DELL/eclipse-workspace/AmazonAssignment/src/test/resources/AmazonTestData/TestData1.xls";
		HashMap<String,HashMap<String,String>> hm = getUserData(excelPath,sheetName,userType);
		String mapValue = hm.get(userType).get(columnName);
		return mapValue;
	}
}

	
	
	
	


	
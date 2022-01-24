package com.DD.Speedoy.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import org.apache.poi.ss.usermodel.DateUtil;


public class DataUtil {
	
	@DataProvider(name = "getData")
     public Object[][] getData(Method m) throws IOException {
		
		File f =new File("./src/test/resources/excelfiles/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Object[][]data = null;
		Sheet sh = wb.getSheet(m.getName());
		int totalrows = sh != null ? sh.getPhysicalNumberOfRows() : 0;
		int totalcells = sh != null ? sh.getRow(0).getLastCellNum() : 0;
		
		System.out.println("total no of rows is "  + totalrows);
		System.out.println("total no of cells is "  + totalcells);
		
		if(sh!=null)
		{
			data = new Object[totalrows-1][totalcells];
			
			for(int i=1; i<totalrows; i++) {
				
				for(int j=0; j<totalcells; j++) {

					//data[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue().toString();
					
					Cell cell1 = sh.getRow(i).getCell(j);
					
					switch (sh.getRow(i).getCell(j).getCellType().name()) {
	                
	                case "STRING":
	                	data[i-1][j] = cell1.getRichStringCellValue().getString();
	                    break;
	                    
	                case "NUMERIC":
	                    if (DateUtil.isCellDateFormatted(cell1)) {
	                    	data[i-1][j] = cell1.getDateCellValue();
	                    } else {
	                    	data[i-1][j] = cell1.getNumericCellValue();
	                    }
	                    break;
	                    
	                /*case Cell.CELL_TYPE_BOOLEAN:
	                	data[i-1][j] = cell1.getBooleanCellValue();
	                    break;
	                    
	                case Cell.CELL_TYPE_FORMULA:
	                	data[i-1][j] = cell1.getCellFormula();
	                    break;
	                    
	                default:
	                    System.out.println();*/
	            }
					
			}
			}
		}
		wb.close();
		fis.close();
		f = null;
	
		return data;
	
	
}

}

package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public String[][] ReadData(String fileName) throws IOException {
		// TODO Auto-generated method stub

		XSSFWorkbook wb = new XSSFWorkbook("./Data/"+fileName+".xlsx");
		//XSSFWorkbook wb = new XSSFWorkbook("./Data/LEADDATA.xlsx");
		
		System.out.println(wb);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowcount = ws.getLastRowNum();
		System.out.println(rowcount);
		
		int cellcount = ws.getRow(0).getLastCellNum();
		System.out.println(cellcount);	
		
		
		//declare 2d array to save the data from excel
		String[][] data = new  String[rowcount][cellcount];
		
		for (int i = 1; i <= rowcount; i++) {
			
			for (int j = 0; j < cellcount; j++) {
				
				XSSFCell cell = ws.getRow(i).getCell(j);
				
				cell.setCellType(CellType.STRING);				
				String stringCellValue = cell.getStringCellValue();
				//System.out.println(stringCellValue);
				data[i-1][j]= stringCellValue;
				System.out.println(stringCellValue);

				
				/*String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				
				//first value for 1 is 1 but want to save it in 0 so we are using i-1
				data[i-1][j]= stringCellValue;
				System.out.println(stringCellValue);*/			
				

			}
			
		}
		wb.close();
		return data;

		

	}

}

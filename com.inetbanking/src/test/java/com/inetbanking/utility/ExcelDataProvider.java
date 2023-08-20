package com.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
//	C:\Users\LENOVO\eclipse-workspace\com.inetbanking\TestData\TestData.xlsx
	
	XSSFWorkbook workbook;
	FileInputStream fins;
	File fs;
	FileOutputStream fout;
	
	public ExcelDataProvider(String filename)
	{
		try{
			 fs = new File("./TestData/"+filename+".xlsx");
			 fins = new FileInputStream(fs);
			 workbook = new XSSFWorkbook(fins);
		}catch(Exception e) {
			System.out.println("File not found in the specified working directory" +e);
			}
		
	}
 
     public int rowCount(String sheetname)
     {
    	return workbook.getSheet(sheetname).getLastRowNum();
     }
     public int columnCount(String sheetname, int row)
     {
    	return workbook.getSheet(sheetname).getRow(row).getLastCellNum();
     }
     public int rowCount(int index)
     {
    	 return workbook.getSheetAt(index).getLastRowNum();
     }
     public int columnCount(int index ,int row)
     {
    	 return workbook.getSheetAt(index).getRow(row).getLastCellNum();
     }
     public String getStringcellData(String sheetname,int row ,int col)
     {
    	 return workbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
     }
     public String getStringcellData(int index,int row ,int col)
     {
    	 return workbook.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();
     }
     public int getNumericcellData(String sheetname ,int row ,int col)
     {
    	 return(int) workbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
     }
     public int getNumericcellDta(int index ,int row ,int col)
     {
    	 return(int) workbook.getSheetAt(index).getRow(row).getCell(col).getNumericCellValue();
     }
     
     
     public String [][] getExcelTestData(String sheetname)
     {
    	 int rows = rowCount(sheetname);
    	 int cols = columnCount(sheetname,0);
    	 
    	 String [][] data = new String[rows][cols];
    	 
    	 for(int i=0; i< rows;  i++)
    	 {
    		 for(int j=0; j< cols; j++) {
    			 
    			data[i][j]= workbook.getSheet(sheetname).getRow(i+1).getCell(j).toString();
    		 }
    	 }
    	 
    	 return data;
     }
     public void createHeaderColumn(String ColName,String sheetname,int row)
     {
    	 workbook.getSheet(sheetname).getRow(row).createCell(columnCount(sheetname,row)+1).setCellValue(ColName);
    	
    	try {
    		 fout = new FileOutputStream(fs);
    		 workbook.write(fout);
    	}catch(Exception e){
    		
    		e.printStackTrace();
    		
    	}
    	
     }
     
     public void setStringCelldata(String sheetname,int row,String cellData)throws Exception
     {
    	 workbook.getSheet(sheetname).getRow(row).createCell(columnCount(sheetname,row)+1).setCellValue(cellData); 
    	
    	 fout = new FileOutputStream(fs);
		 workbook.write(fout);
     }
     
//        public static void main(String[]args) {
    	 
//    	ExcelDataProvider excelDataProvider = new ExcelDataProvider("TestData");
    	
//    	System.out.println(excelDataProvider.rowCount(0));
//    	System.out.println(excelDataProvider.columnCount("Login", 0));
    	
//    	System.out.println(excelDataProvider.getStringcellData("Login", 1, 0));
//    	System.out.println(excelDataProvider.getStringcellData("Login", 1, 1));
//    	System.out.println(excelDataProvider.getStringcellData("Login", 1, 2));
    	
    	
//    	System.out.println(excelDataProvider.getStringcellData(0, 1, 0));
//    	System.out.println(excelDataProvider.getStringcellData(0, 1, 1));
//    	System.out.println(excelDataProvider.getStringcellData(0, 1, 2));
  	
  	

     
}   
//}    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
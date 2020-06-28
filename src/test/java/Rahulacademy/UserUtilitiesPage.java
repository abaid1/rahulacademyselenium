package Rahulacademy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class UserUtilitiesPage {
	
	public void fnScreenshot() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\akash\\eclipse-workspace_Demo\\Rahulacademy\\testdata\\SeleniumTestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
	int sheetnum = workbook.getNumberOfSheets();
	System.out.println(sheetnum);
	XSSFSheet datasheet = workbook.getSheetAt(0);
	Iterator<Row> rows=datasheet.iterator();
	Row rowValue=rows.next();
	Iterator<Cell> cells=rowValue.cellIterator();
	
	//System.out.println("Ruchi ka Workbook ka cell: " + cellValue);
	int k=0, j=0;
	int testcaseColumn=0;
	int nameColumn=0;
	int emailColumn=0;
	int passwordColumn=0;
	int confirmpasswordColumn=0;
	int loginRow = 0;
	int registrationRow = 0;
	
	while(cells.hasNext()) {
		Cell cellValue=cells.next();
		if(cellValue.getStringCellValue().equalsIgnoreCase("testcase")) {
			testcaseColumn = k;
		}
		if(cellValue.getStringCellValue().equalsIgnoreCase("Name")) {
			nameColumn = k;
		}
		if(cellValue.getStringCellValue().equalsIgnoreCase("email")) {
			emailColumn = k;
		}
		if(cellValue.getStringCellValue().equalsIgnoreCase("password")) {
			passwordColumn = k;
		}
		if(cellValue.getStringCellValue().equalsIgnoreCase("confirmpassword")) {
			confirmpasswordColumn = k;
		}
		k++;
	}
	
//	while(rows.hasNext()) {
//		if (rowValue.getCell(testcaseColumn).equals(rowValue)("Login")) { 
//			loginRow=j;
//			System.out.println("it is" + loginRow);
//		}j++;
//			
//		
//		//Row rowValue.rows.
//		
//	}
	System.out.println(testcaseColumn);
	System.out.println(nameColumn);
	System.out.println(emailColumn);
	System.out.println(passwordColumn);
	System.out.println(confirmpasswordColumn);
//	if(cellValue.getStringCellValue().equalsIgnoreCase("TestCase")) {
//		cells.next();
//		if(cellValue.getStringCellValue().equalsIgnoreCase("Name"))
		
	}
	
	
	}

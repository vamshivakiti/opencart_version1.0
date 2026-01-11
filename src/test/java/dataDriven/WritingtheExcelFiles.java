package dataDriven;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingtheExcelFiles {

	public static void main(String[] args) throws IOException {
     FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\myFile.xlsx");
     XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet= workbook.createSheet("Dynamic data");
	/*
	 * XSSFRow row1= sheet.createRow(0);
	 * row1.createCell(0).setCellValue("Wel come");
	 * row1.createCell(1).setCellValue(1234);
	 * row1.createCell(2).setCellValue("Java");
	 * row1.createCell(3).setCellValue("Automation");
	 * 
	 * XSSFRow row2= sheet.createRow(0);
	 * row1.createCell(0).setCellValue("Wel come");
	 * row1.createCell(1).setCellValue(4321);
	 * row1.createCell(2).setCellValue("Python");
	 * row1.createCell(3).setCellValue("Automation");
	 * 
	 * XSSFRow row3= sheet.createRow(0);
	 * row1.createCell(0).setCellValue("Wel come");
	 * row1.createCell(1).setCellValue(567); row1.createCell(2).setCellValue("c#");
	 * row1.createCell(3).setCellValue("Automation");
	 */
      Scanner sc = new Scanner(System.in);
      System.out.println("Please enter required rows");
      int numberOfRows=sc.nextInt();
      System.out.println("Please enter required cells");
       int numberOfCell= sc.nextInt();
       
       for(int r=0; r<=numberOfRows; r++) {
    	   XSSFRow  currentRow =  sheet.createRow(r);
    	   
    	   for(int c=0;c<numberOfCell; c++) {
    		   XSSFCell cell=  currentRow.createCell(c);
    		   cell.setCellValue(sc.next());
    	   }
       }
     workbook.write(file);
     workbook.close();
     file.close();
     
     
     
	}

}

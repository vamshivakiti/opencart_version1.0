package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//OpenFile in reading mode-->got to workbook--> goto sheet--> goto row--> goto cell
public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData1.xlsx");

		XSSFWorkbook workBook = new XSSFWorkbook(file);	
		XSSFSheet sheet    = workBook.getSheet("ProductData");
		//count number of rows and cells.
		int numOfRows=sheet.getLastRowNum();
		System.out.println("Number of rows :"+numOfRows);
		// count the number of cells
		int totalCells= sheet.getRow(1).getLastCellNum();

		System.out.println("Number of cells :"+totalCells);

		for(int r =0; r<=numOfRows;r++) {

			XSSFRow currentRow=sheet.getRow(r);


			for(int c=0; c<totalCells;c++) {
				XSSFCell cellData=currentRow.getCell(c);
				System.out.print(cellData.toString() +"\t");
			}
			System.out.println();
		}
		workBook.close();
		file.close();

	}

}

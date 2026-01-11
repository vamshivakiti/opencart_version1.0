package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xfiles, String xlsheet) throws Exception
	{
	fi = new FileInputStream(xfiles);
	    wb =new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    int rowCoun=ws.getLastRowNum();
	    wb.close();
	    fi.close();
	    return rowCoun;
	}
	
	
	public static int getCellCount(String xfiles, String xlsheet, int rownum) throws IOException {
		
		fi = new FileInputStream(xfiles);
	    wb =new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row =ws.getRow(rownum);
	int cellcount	=row.getLastCellNum();
	wb.close();
	fi.close();
	return cellcount;
	}
	
	public static String getCellData(String xfiles, String xlsheet,int rownum,int colnum) throws IOException
	{
		fi = new FileInputStream(xfiles);
	    wb =new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row =ws.getRow(rownum);
	    row.getCell(colnum);
	    String data;
	    try {
	    	data=cell.toString();
	    	DataFormatter formatter = new DataFormatter();
	    	data =formatter.formatCellValue(cell);
	    }
	    catch(Exception e) {
	    	data="";
	    }
	    wb.close();
	    fi.close();
		return data;
	}
	public static void setCellData(String xfiles, String xlsheet,int rownum,int colnum, String data) throws IOException {
		
		fi = new FileInputStream(xfiles);
	    wb =new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row =ws.getRow(rownum);
	    
	   cell = row.getCell(colnum);
	   cell.setCellValue(data);
	   fo = new FileOutputStream(xfiles);
	   
	   wb.write(fo);
	   wb.close();
	   fi.close();
	   fo.close();
	}
	
	public static void fillGreenColor(String xfiles, String xlsheet,int rownum,int colnum ) throws IOException
	{
		fi = new FileInputStream(xfiles);
	    wb =new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row =ws.getRow(rownum);
	    cell = row.getCell(colnum);
	    style=wb.createCellStyle();
	    style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(style);
	    fo=new FileOutputStream(xfiles);
	    wb.write(fo);
	    wb.close();fi.close();fo.close(); 
	}
	
	public static void fillRedColor(String xfiles, String xlsheet,int rownum,int colnum ) throws IOException
	{
		fi = new FileInputStream(xfiles);
	    wb =new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row =ws.getRow(rownum);
	    cell = row.getCell(colnum);
	    style=wb.createCellStyle();
	    style.setFillBackgroundColor(IndexedColors.RED.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(style);
	    fo=new FileOutputStream(xfiles);
	    wb.write(fo);
	    wb.close();fi.close();fo.close(); 
	}
}

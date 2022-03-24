package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * it is developed by using apache poi libraries which is used to fetch the data from excelsheet
 * @author LOVERBOY
 *
 */

public class Excelutility {
	/**
	 *it is used to read the data from excel based on below arguments
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDatafromexcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/organization - Copy.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		book.close();
		return data;
		
	}
	/**
	 * it is used to the total number of rows present in excel sheet
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowcount(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/organization - Copy.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		int totalrow = sh.getLastRowNum();
		book.close();
		return totalrow;
		
	}
	/**
	 * it is used to write the data into excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void excelData(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/organization - Copy.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		sh.getRow(rownum).createCell(cellnum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata/organization - Copy.xlsx");
		book.write(fos);
		book.close();
	}

}

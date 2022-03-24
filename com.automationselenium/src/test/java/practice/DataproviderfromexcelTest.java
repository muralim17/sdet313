package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.Excelutility;

public class DataproviderfromexcelTest{
	@DataProvider
	public Object[][] supplycredential() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/organization - Copy.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Dataprovider");
		int lastrownum = sh.getLastRowNum();
		System.out.println(lastrownum);
		DataFormatter format=new DataFormatter();
		Object[][] objarr=new Object[lastrownum+1][2];
		for(int i=0;i<=lastrownum;i++)
		{
			objarr[i][0]=format.formatCellValue(sh.getRow(i).getCell(0));
			objarr[i][1]=format.formatCellValue(sh.getRow(i).getCell(1));
		}
		return objarr;
	
}
	@Test(dataProvider="supplycredential")
	public void logintoapp(String username,String password)
	{
		System.out.println(username+"   "+password);
		//System.out.println(password);
	}
}

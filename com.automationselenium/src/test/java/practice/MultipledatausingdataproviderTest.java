package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipledatausingdataproviderTest {
	@Test(dataProvider="getdata")
		public void multipledata(String name,String company,String emailid,String employeeid)
		{
			System.out.println(name);
			System.out.println(company);
			System.out.println(emailid);
			System.out.println(employeeid);
			System.out.println("===============");
		}
	@DataProvider
	public Object[][] getdata()
	{
Object[][] objArray=new Object[2][4];
		
		objArray[0][0]="Murali m";
		objArray[0][1]="Tyss bangalore";
		objArray[0][2]="murali@gmail.com";
		objArray[0][3]="1428";
		
		objArray[1][0]="kohli";
		objArray[1][1]="Mphysis banagalore";
		objArray[1][2]="rahul@gmail.com";
		objArray[1][3]="EMP100";
		
		return objArray;
	}
}


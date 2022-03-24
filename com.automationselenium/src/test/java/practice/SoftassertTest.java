package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftassertTest {
	
 SoftAssert sf = new SoftAssert();
	@Test
	public void checkassertions()
	{
		
		String exp="ell";
		String act="hello";
		sf.assertEquals(exp, act);
	}
	@Test
	public void softasserts()
	{
		String exp="ell";
		String act="hello";
		sf.assertEquals(exp, act);
		sf.assertAll();
	}

	@Test
	public void integer()
	{
		int x=20;
		int y=40;
		sf.assertEquals(x, y);


	}

	
	@Test
	public void integer2()
	{
		int x=20;
		int y=40;
		sf.assertEquals(x, y);
		sf.assertAll();
	}
      
	@Test
	public void cricketers()
	{
		int a=18;
		int b=24;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

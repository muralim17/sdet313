package practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardassertTest {
@Test
public void assertEquals()
{
	String exp="Hello";
	String act="Hello";
	Assert.assertEquals(exp, act);
	
}
	@Test
	public void  assertnotequals()
	{
	String name="ravi";
	String name2="rahul";
	Assert.assertNotEquals(name, name2);
	}
	
	@Test
	public void assertequal()
	{
	int x=20;
	int y=20;
	Assert.assertEquals(x, y);
	
	}
	@Test
	public void booleanequals()
	{
		
	boolean flag=false;
	boolean flag1=false;
	Assert.assertEquals(flag, flag1);
	
}
	@Test
	public void cricketers()
	{
		int a=18;
		int b=24;
		Assert.assertEquals(a, b);
		System.out.println("bytes are not equal");
	}
	
	@Test
	public void array()
	{
		int[] a= {1,2,3};
		int[] b= {1,3,5};
		
		
		
		
	}
	
	
	
	



}

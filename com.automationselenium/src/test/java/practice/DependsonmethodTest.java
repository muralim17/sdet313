package practice;

import org.testng.annotations.Test;

public class DependsonmethodTest {
	@Test
	public void createaccount() throws Exception
	{
		System.out.println("login");
		System.out.println("createaccount");
		System.out.println("logout");
		throw new Exception();
	}
	@Test(dependsOnMethods="createaccount")
	public void modifyaccount()
	{
		System.out.println("login");
		System.out.println("modifyaccount");
		System.out.println("logout");
	}
	@Test(dependsOnMethods="modifyaccount")
	public void deleteaccount()
	{
		System.out.println("login");
		System.out.println("modifyaccount");
		System.out.println("logout");
	}
	

}

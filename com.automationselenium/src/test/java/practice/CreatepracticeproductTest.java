package practice;

import org.testng.annotations.Test;

public class CreatepracticeproductTest {
	@Test(groups="smokeTest")
	public void createproduct()
	{
		System.out.println("product created successfully");
	}
	
	@Test(groups="regressionTest")
	public void createproductwithname()
	{
		System.out.println("product with name created");
	}

}

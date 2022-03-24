package practice;

import org.testng.annotations.Test;

public class CreatepracticeorganizationTest {
@Test(groups="regressionTest")
public void createpracticeorganization()
{
	System.out.println("organization is successfully created");
}

@Test(groups="smokeTest")
public void createorganizationwithcontactname()
{
	System.out.println("organization with contactname created");
}
}

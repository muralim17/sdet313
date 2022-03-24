package practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreatepracticecampaignTest {

@Test(groups="smokeTest")
public void createpracticecampaign()
{
	System.out.println("campaign is created");
}

@Test(groups="regressionTest")
public void createpracticecampaignwithproduct()
{
	System.out.println("campaign with product is created");
}

}

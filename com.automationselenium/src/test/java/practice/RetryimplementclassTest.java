package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryimplementclassTest {
	@Test(retryAnalyzer=com.crm.autodesk.genericutility.Retryanalyzerimplementationclass.class)
public void create()
{
	System.out.println("retry");
	Assert.assertEquals(false, true);
}
}

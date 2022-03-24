package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author MURALI M
 *
 */

public class Fileutility {
   /**
    * it is used to fetch a commondata from propertyfile
    * @param key
    * @return
    * @throws IOException
    */
	public String getpropertykeyvalue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/main/resources/commondata/data.Properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}

}

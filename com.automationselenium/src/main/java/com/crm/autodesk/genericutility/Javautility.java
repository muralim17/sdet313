package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author MURALI M
 *
 */

public class Javautility {
	
	/**
	 * it is used to generate number ranges between 1 to 1000
	 * @return int data
	 */
	public int getRandomNumber() {
		Random random=new Random();
		int Randomnum=random.nextInt(10000);
		return Randomnum;
		
	}
	/**
	 * used to get system date and time in IST format
	 * @return
	 */
	public String getSystemDateandTime()
	{
		Date date=new Date();
		return date.toString();
		
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemdatewithformat()
	{
		Date date=new Date();
		String dateandtime=date.toString();
		String yyyy = dateandtime.split(" ")[5];
		String dd = dateandtime.split(" ")[2];
		int mm=date.getMonth()+1;
		String finalformat=yyyy+"-"+mm+"-"+dd;
		return finalformat;
	}

	
	
	
	
}

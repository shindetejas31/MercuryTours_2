package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=10;

	public static String generateEmail()
	{
			
			String RanMail = RandomStringUtils.randomNumeric(9);

			return RanMail+"@tmail.com";
		
	}


}

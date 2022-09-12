package tools;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateManipulator {

	// private static Date d;

	public static Date dateConvertToSql(java.util.Date d) {
		long timeInMilliSeconds = d.getTime();
		java.sql.Date date = new java.sql.Date(timeInMilliSeconds);
		return date;
	}

	public static String dateConvertToDDmmYYYY(Date d) {
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = sourceFormat.format(d);
		return date;
	}

	public static Timestamp dateAndTimeInSql() {

		long now = System.currentTimeMillis();
		Timestamp sqlTimestamp = new Timestamp(now);
		System.out.println("currentTimeMillis     : " + now);
		System.out.println("SqlTimestamp          : " + sqlTimestamp);
		System.out.println("SqlTimestamp.getTime(): " + sqlTimestamp.getTime());
		
		return sqlTimestamp;

	}
	
	public static Date dateInSql() {
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		return date;
	}
}

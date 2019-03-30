package zwt.test;

import java.util.Date;

public class Zwttest {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
//		java.sql.Date registerTime = new java.sql.Date(now.getTime());
//		java.sql.Time registerTimes = new java.sql.Time(now.getTime());
		//上次登录时间
		java.sql.Timestamp registerTimes = new java.sql.Timestamp(now.getTime());
		System.out.println(registerTimes);
	}
}

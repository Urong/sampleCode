package com.urong.wedding.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CommonUtil {

	public static String getCurrenDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);

		return formatter.format(new Date());
	}
}

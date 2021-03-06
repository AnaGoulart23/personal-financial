package com.financeiro.personalfinancials.utilities.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static LocalDate parseDate(final String dateForParsing, final String datePattern) {
		final DateTimeFormatter format = DateTimeFormatter.ofPattern(datePattern);
		return LocalDate.parse(dateForParsing, format);
	}

	public static String strFormattedDate(final String datePattern, final LocalDate dateForFormat) {
		final DateTimeFormatter format = DateTimeFormatter.ofPattern(datePattern);
		return format.format(dateForFormat);
	}

}

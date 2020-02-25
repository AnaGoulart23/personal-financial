package com.financeiro.personalfinancials.utilities;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.financeiro.personalfinancials.utilities.date.DateUtil;

public class DateUtilTest {

	@Test
	public void testParseDate() {
		assertEquals(LocalDate.of(2019, 4, 6), (DateUtil.parseDate("06/04/2019", "dd/MM/yyyy")));
	}
	
	@Test
	public void testStrFormattedDate() {
		assertEquals("2019-04-06", DateUtil.strFormattedDate("yyyy-MM-dd", LocalDate.of(2019, 04, 06)));
	}
	
}

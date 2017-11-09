package com.relay42.interview.datagen;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;

public class TimeStampGeneratorTest {
	
	Date beginningOfTheYear;
	
	@Before
	public void setup(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 1, 1);
		beginningOfTheYear = calendar.getTime();
	}

	@Test
	public void shouldReturnTimestampInThisYearByDefault() {
		Long ts = new TimestampGenerator().getValue();
		assertTrue(ts > beginningOfTheYear.getTime());
	}

}

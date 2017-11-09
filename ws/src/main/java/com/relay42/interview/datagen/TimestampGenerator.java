package com.relay42.interview.datagen;

import java.util.Calendar;
import java.util.Date;

import uk.co.jemos.podam.common.AttributeStrategy;

public class TimestampGenerator implements  AttributeStrategy<Long> {

	public Long getValue() {
		return today().getTime() + (long)(Math.random() * getDurationFromBeginningFoThisYear()) ;
	}

	private long getDurationFromBeginningFoThisYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 1, 1);
		return today().getTime() - calendar.getTime().getTime();
	}
	
	private Date today(){
		return new Date();
	}

}

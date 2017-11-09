package com.relay42.interview.datagen;

import uk.co.jemos.podam.common.AttributeStrategy;

public class TomatoCountGenerator implements  AttributeStrategy<Integer> {

	public Integer getValue() {
		return (int) (Math.random() * 2000);
	}

}

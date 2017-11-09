package com.relay42.interview.datagen;

import java.util.UUID;

import uk.co.jemos.podam.common.AttributeStrategy;

public class UUIDGenerator implements  AttributeStrategy<String> {

	public String getValue() {
		return UUID.randomUUID().toString();
	}

}

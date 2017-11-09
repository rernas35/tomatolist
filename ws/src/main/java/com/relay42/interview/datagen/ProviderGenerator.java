package com.relay42.interview.datagen;

import uk.co.jemos.podam.common.AttributeStrategy;

public class ProviderGenerator implements  AttributeStrategy<String> {

	public String getValue() {
		int random = getRandomIndex();
		switch (random) {
		case 0:
			return "Heinz";
		case 1:
			return "Hunt's";
		case 2:
			return "Del Monte";
		default:
			return "Le Ol' Granma";
		}
	}

	private int getRandomIndex() {
		return (int) (Math.random() * 4);
	}

}

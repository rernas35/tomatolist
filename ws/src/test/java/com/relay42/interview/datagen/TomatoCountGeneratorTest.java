package com.relay42.interview.datagen;

import static org.junit.Assert.*;

import org.junit.Test;

public class TomatoCountGeneratorTest {

	@Test
	public void shouldReturnValueLessThan2000GreaterThen0ByDefault() {
		Integer count = new TomatoCountGenerator().getValue();
		assertTrue(count >= 0 && count <= 2000);
	}

}

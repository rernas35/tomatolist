package com.relay42.interview.datagen;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

public class UUIDGeneratorTest {

	@Test
	public void test() {
		assertTrue(new UUIDGenerator().getValue().matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"));
	}

}

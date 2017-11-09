package com.relay42.interview.datagen;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProviderGeneratorTest {

	List<String> providerList = new ArrayList<String>();
	
	@Before
	public void setup(){
		providerList.add("Heinz");
		providerList.add("Hunt's");
		providerList.add("Del Monte");
		providerList.add("Le Ol' Granma");
	}
	
	@Test
	public void shouldReturnOneOfFourProviderByDefault() {
		assertTrue(providerList.contains(new ProviderGenerator().getValue()));
	}

}

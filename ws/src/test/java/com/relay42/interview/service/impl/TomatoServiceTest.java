package com.relay42.interview.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.relay42.interview.model.TomatoData;
import com.relay42.interview.service.ITomatoDataProvider;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ITomatoDataProvider.class)
public class TomatoServiceTest {
	PodamFactory factory = new PodamFactoryImpl();
	
	@Mock ITomatoDataProvider mockTomatoProvider;
	
	@InjectMocks TomatoService tomatoService;
	
	@Before 
	public void setup(){
		List<TomatoData> tomatoData = new ArrayList<TomatoData>();
		IntStream.range(0, 5).forEach(c -> tomatoData.add(factory.manufacturePojo(TomatoData.class)));
		when(mockTomatoProvider.getTomatoData()).thenReturn(tomatoData);
	}
	
	@Test
	public void shouldReturnFullTomatoListİfNoSizeIsProvided() {
		assertEquals(5, tomatoService.list(null).size());
	}
	
	@Test
	public void shouldReturnCorrectCountTomatoListİfSizeIsProvided() {
		assertEquals(3, tomatoService.list(3).size());
	}
	
	@Test
	public void shouldReturnCorrectCountTomatoListEvenİfSizeIsGreaterThanActualSize() {
		assertEquals(5, tomatoService.list(10).size());
	}

}

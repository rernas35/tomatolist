package com.relay42.interview.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

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

import com.relay42.interview.ErrorCodes;
import com.relay42.interview.model.Response;
import com.relay42.interview.model.TomatoData;
import com.relay42.interview.service.ITomatoDataProvider;
import com.relay42.interview.service.ITomatoService;
import com.relay42.interview.service.impl.TomatoService;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ITomatoService.class)
public class TomatoListControllerTest {
	PodamFactory factory = new PodamFactoryImpl();
	
	@Mock ITomatoService mockTomatoService;
	
	@InjectMocks TomatoListController tomatorController;
	
	@Before 
	public void setup(){
		List<TomatoData> tomatoData = new ArrayList<TomatoData>();
		IntStream.range(0, 5).forEach(c -> tomatoData.add(factory.manufacturePojo(TomatoData.class)));
		when(mockTomatoService.list(5)).thenReturn(tomatoData);
		when(mockTomatoService.list(3)).thenReturn(tomatoData.subList(0,3));
	}
	
	@Test
	public void shouldReturnFullTomatoListİfNoSizeIsProvided() {
		Response<List<TomatoData>> response = tomatorController.getTomatoList("5", null);
		assertEquals(ErrorCodes.SUCCESS,response.getResponseCode());
		assertNotNull(response.getDescription());
		assertEquals(5, response.getBody().size());
	}
	
	@Test
	public void shouldReturnCorrectCountTomatoListİfSizeIsProvided() {
		Response<List<TomatoData>> response = tomatorController.getTomatoList("3", null);
		assertEquals(ErrorCodes.SUCCESS,response.getResponseCode());
		assertNotNull(response.getDescription());
		assertEquals(3, response.getBody().size());
	}
	
	@Test
	public void shouldReturnErrorCode01İfWrongInputTypeIsProvided() {
		Response<List<TomatoData>> response = tomatorController.getTomatoList("dd", null);
		assertEquals(ErrorCodes.WRONG_INPUT_TYPE,response.getResponseCode());
		assertNotNull(response.getDescription());
		assertNull(response.getBody());
	}

}

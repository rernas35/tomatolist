package com.relay42.interview.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.relay42.interview.model.TomatoData;
import com.relay42.interview.service.ITomatoDataProvider;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Service
public class PodamTomatoDataProvider implements ITomatoDataProvider{

	static List<TomatoData> tomatoList = new ArrayList<TomatoData>();
	
	static {
		final PodamFactory factory = new PodamFactoryImpl();
		IntStream.range(0, 1000).forEach(c-> tomatoList.add(factory.manufacturePojo(TomatoData.class)));
	}
	
	public List<TomatoData> getTomatoData() {
		return tomatoList;
	}
	
	 
	

}

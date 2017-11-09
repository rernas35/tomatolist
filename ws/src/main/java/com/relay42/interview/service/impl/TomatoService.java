package com.relay42.interview.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relay42.interview.model.TomatoData;
import com.relay42.interview.service.ITomatoDataProvider;
import com.relay42.interview.service.ITomatoService;

@Service
public class TomatoService implements ITomatoService {
	
	@Autowired
	ITomatoDataProvider tomatoDataProvider;

	@Override
	public List<TomatoData> list(Integer size) {
		if (size == null || size > tomatoDataProvider.getTomatoData().size())
			return tomatoDataProvider.getTomatoData();
		else
			return filter(tomatoDataProvider.getTomatoData(),size);
	}
	
	private List<TomatoData> filter(List<TomatoData> tomatoList,Integer size){
		return tomatoList.subList(0, size);
	}

}

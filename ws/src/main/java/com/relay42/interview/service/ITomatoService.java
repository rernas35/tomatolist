package com.relay42.interview.service;

import java.util.List;

import com.relay42.interview.model.TomatoData;

public interface ITomatoService {
	
	List<TomatoData> list(Integer size);

}

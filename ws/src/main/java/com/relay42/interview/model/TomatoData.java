package com.relay42.interview.model;

import com.relay42.interview.datagen.ProviderGenerator;
import com.relay42.interview.datagen.TimestampGenerator;
import com.relay42.interview.datagen.TomatoCountGenerator;
import com.relay42.interview.datagen.UUIDGenerator;

import uk.co.jemos.podam.common.PodamStrategyValue;

public class TomatoData {
	
	@PodamStrategyValue(value=UUIDGenerator.class)
	String id ;
	
	@PodamStrategyValue(value=TomatoCountGenerator.class)
	Integer tomatoes;
	
	@PodamStrategyValue(value=ProviderGenerator.class)
	String provider;
	
	@PodamStrategyValue(value=TimestampGenerator.class)
	Long timestamp;
	
	public TomatoData(String id, Integer tomatoes, String provider, Long timestamp) {
		super();
		this.id = id;
		this.tomatoes = tomatoes;
		this.provider = provider;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getTomatoes() {
		return tomatoes;
	}
	
	public void setTomatoes(Integer tomatoes) {
		this.tomatoes = tomatoes;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}

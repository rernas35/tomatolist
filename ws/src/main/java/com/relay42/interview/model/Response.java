package com.relay42.interview.model;

public class Response<R> {

	R body;
	String responseCode;
	String description;
	
	public R getBody() {
		return body;
	}
	
	public Response<R> setBody(R body) {
		this.body = body;
		return this;
	}
	
	public String getResponseCode() {
		return responseCode;
	}
	
	public Response<R> setResponseCode(String responseCode) {
		this.responseCode = responseCode;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Response<R> setDescription(String description) {
		this.description = description;
		return this;
	}
	
	
	
}

package com.projects.web;

//TODO ACTUALLY PARSE AND POPULATE METADATA
public class MetaData {

	private String data;
	
	public MetaData(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String toString() {
		return "Metadata:\n" + data;
	}
	
}

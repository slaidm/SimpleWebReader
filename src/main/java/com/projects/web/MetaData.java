package com.projects.web;

import java.util.LinkedList;
import java.util.List;

//TODO ACTUALLY PARSE AND POPULATE METADATA
public class MetaData {

	private String data;
	private List<String> contents = new LinkedList<>();
	
	public MetaData() {
		this.data = "";
	}
	
	public MetaData(String data) {
		this.data = data;
	}
	
	public MetaData(String data, List<String> contents) {
		this.data = data;
		this.contents.addAll(contents);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String toString() {
		return data + "\n" + contents.stream().reduce("", (acc, s) -> acc += s + "\n");
	}
	
}

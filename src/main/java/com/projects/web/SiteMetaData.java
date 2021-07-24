package com.projects.web;

//TODO: ACTUALLY PARSE AND POPULATE
public class SiteMetaData {

	private String data;
	
	public SiteMetaData() {
		this.data = "";
	}
	
	public SiteMetaData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String toString() {
		return data;
	}
}

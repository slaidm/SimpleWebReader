package com.projects.web;

public class Chapter {
	private int order;
	private String title;
	private String text;
	
	public Chapter(String title, String text, int order) {
		this.title = title;
		this.text = text;
		this.order = order;
	}
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		return "Chapter " + order + "\n" + title + "\n\n" + text;
	}
	
}

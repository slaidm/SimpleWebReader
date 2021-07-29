package com.projects.web;

import java.util.LinkedList;
import java.util.List;

public class Book {
	private String title = "";
	private String author = "";
	private String quote = "";
	private String font = "";
	private String fontcolor = "";
	private String backgroundcolor = "";
	private int fontsize;
	
	public Book(String title, String author, String quote, String font, String fontcolor, String backgroundcolor, int fontsize) {
		this.title = title;
		this.author = author;
		this.quote = quote;
		this.font = font;
		this.fontcolor = fontcolor;
		this.backgroundcolor = backgroundcolor;
		this.fontsize = fontsize;
	}
	
}

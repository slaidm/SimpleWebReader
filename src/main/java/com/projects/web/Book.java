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
	private String fontsize;
	
	public Book(String title, String author, String quote, String font, String fontcolor, String backgroundcolor, int fontsize) {
		this.title = title;
		this.author = author;
		this.quote = quote;
		this.font = font;
		this.fontcolor = fontcolor;
		this.backgroundcolor = backgroundcolor;
		this.fontsize = Integer.toString(fontsize);
	}
	
	
	public String toString() {
		return title + " " + author + " " + quote + " :: " + font + ":" + fontcolor + ":" + backgroundcolor + ":" + fontsize;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getQuote() {
		return quote;
	}


	public void setQuote(String quote) {
		this.quote = quote;
	}


	public String getFont() {
		return font;
	}


	public void setFont(String font) {
		this.font = font;
	}


	public String getFontcolor() {
		return fontcolor;
	}


	public void setFontcolor(String fontcolor) {
		this.fontcolor = fontcolor;
	}


	public String getBackgroundcolor() {
		return backgroundcolor;
	}


	public void setBackgroundcolor(String backgroundcolor) {
		this.backgroundcolor = backgroundcolor;
	}


	public String getFontsize() {
		return fontsize;
	}


	public void setFontsize(String fontsize) {
		this.fontsize = fontsize;
	}
}

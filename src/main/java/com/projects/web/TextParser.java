package com.projects.web;

import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class TextParser {

	public Book parseStream(BufferedReader br) throws IOException {
		Book b = null;
		String title = "The Art of War";
		String author = "Sun Tzu";
		String line = null;
		List<String> quotes = new ArrayList<>();
		while((line = br.readLine()) != null) {
			if(line.contains("I. ")) {
				break;
			} 
		}
		StringBuilder sb = new StringBuilder("");
		while((line = br.readLine()) != null) {
			if(line.equals("")) {
				quotes.add(sb.toString());
				sb.delete(0, sb.length());
			} else {
				if(!line.matches("^[IXVCL]*\\. .*$")) {
					line = line.replaceFirst("^(\\d+\\. )", "");
					sb.append(line + "\n");
				} else
					line=br.readLine();
			}
		}
		String font = generateFonts();
		String color = generateColor();
		String backgroundColor = generateColor();
		int fontsize = getRandInt(25, 55);
		
		b = new Book(title, author, quotes.get(getRandInt(0, quotes.size()-2)), font, color, backgroundColor, fontsize);
		
		return b;
	}
	
	private String generateFonts() {
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		int rand = getRandInt(0, fonts.length-1);
		return fonts[rand];
	}
	
	private int getRandInt(int min, int max) {
		return (int)(Math.random() * (max - min +1)) + min;
	}
	
	private String generateColor() {
		return Integer.toHexString((int)Math.floor(Math.random()*16777215));
	}
	
	
}

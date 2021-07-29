package com.projects.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/*TODO: Notate, parser, printer*/
public class TextReader {
	
	public static Book getText() {
		Book b = null;
		try {
			String urlString = "http://classics.mit.edu/Tzu/artwar.1b.txt"; 
			URL url = new URL(urlString);
			
			try {
				url.toURI();
			} catch (URISyntaxException e) {
				throw new IOException();
			}
			
			URLConnection con = url.openConnection();
			InputStream is = con.getInputStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        
	        TextParser tp = new TextParser();
	        b = tp.parseStream(br);
	        
			br.close(); 
			is.close();
	        
		} catch (IOException e) {
			System.out.print("Bad URL. Cannot parse file.\n");
			e.printStackTrace();
		}
		return b;
	}
//	
	public static void main(String[] args) {
		System.out.println(TextReader.getText().toString());		
	}
}

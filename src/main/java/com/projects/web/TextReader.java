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
	
	public static String getText(String website) {
		try {
			URL url = new URL(website);
			
			try {
				url.toURI();
			} catch (URISyntaxException e) {
				throw new IOException();
			}
			
			URLConnection con = url.openConnection();
			InputStream is = con.getInputStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));

	        String line = null;
	        int limit = 200;
	        int i = 0; 
	        
	        // read each line and write to System.out
	        while ((line = br.readLine()) != null && (i++) < limit) {
	            System.out.println(line);
	        }
	        
			br.close(); 
			is.close();
	        
		} catch (IOException e) {
			System.out.print("Bad URL. Cannot parse file.\n");
			e.printStackTrace();
		}
		return "\n\nAll Finished!";
	}
	
	public static void main(String[] args) {
		String url = "https://www.gutenberg.org/cache/epub/8300/pg8300.txt"; //A bible to start off with. 
		String text = TextReader.getText(url);
		System.out.println(text);
		
	}
	
}

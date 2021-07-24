package com.projects.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class TextParser {

	public String parseStream(BufferedReader br) throws IOException {
		//Ignore first bit, and include in separate object.
		//Title
		//Author
		//MetaData
		//Contents
		//Chapters
		//	Texts
		//Out
		Book b = new Book();
		b.setSitemetadata(getSiteMetadata(br));
		b.setMetadata(getMetaData(br));
		b.setTitle(getTitle(br));
		b.appendMetadata(getMetaData(br));
		b.setChapters(getChapters(br));
		
		return b.toString();
	}
	
	
	private List<Chapter> getChapters(BufferedReader br) {
		// TODO Auto-generated method stub
		return null;
	}

	//TODO
	private String getTitle(BufferedReader br) {
		return null;
	}


	private MetaData getMetaData(BufferedReader br) {
		// TODO Auto-generated method stub
		return null;
	}


	private SiteMetaData getSiteMetadata(BufferedReader br) throws IOException {
		StringBuffer siteInformation = new StringBuffer("");
		String gutenbergSiteInformation = ".*\\Q***\\E.*";
		Pattern p = Pattern.compile(gutenbergSiteInformation);
		
		String line = null;
		while((line = br.readLine())!=null && !p.matcher(line).matches()) {
			siteInformation.append(line + "\n");
		}
		return new SiteMetaData(siteInformation.toString());
	}
	
	//TODO
	private int countLineBreaks(BufferedReader br) {
		String line = null;
		return 0;
	}
	

	public static void main(String[] args) throws IOException {

	}
}

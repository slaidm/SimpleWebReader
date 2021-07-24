package com.projects.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class TextParser {

	public String parseStream(BufferedReader br) throws IOException {
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
		List<Chapter> chapters = new LinkedList<>();
		return chapters;
	}

	private String getTitle(BufferedReader br) throws IOException {
		String line = null;
		StringBuilder sb = new StringBuilder("");
		int lb = countLineBreaks(br);
		if(lb == 6) {
			for(int i = 0; i < lb; i++) {
				line = br.readLine();
			}
			while((line = br.readLine())!= null && !line.equals("")) {
				sb.append(line);
			}
		}
		return sb.toString();
	}


	private MetaData getMetaData(BufferedReader br) throws IOException {
		StringBuilder sb = new StringBuilder("");
		String line = null;
		int lb = countLineBreaks(br);
		if (lb == 4) {
			for(int i = 0; i < lb; i++) {
				line = br.readLine();
			}
			while((line = br.readLine()) != null) {
				if(line.equals("")) {
					if(countLineBreaks(br) > 3) {
						break;
					}
				}
				else {
					sb.append(line);
				}
			}
		}
		return new MetaData(sb.toString());
	}


	private SiteMetaData getSiteMetadata(BufferedReader br) throws IOException {
		StringBuilder siteInformation = new StringBuilder("");
		String gutenbergSiteInformation = ".*\\Q***\\E.*";
		Pattern p = Pattern.compile(gutenbergSiteInformation);
		
		String line = null;
		while((line = br.readLine())!=null && !p.matcher(line).matches()) {
			siteInformation.append(line + "\n");
		}
		return new SiteMetaData(siteInformation.toString());
	}
	
	//TODO
	private int countLineBreaks(BufferedReader br){
		int count = 1;
		try {
			br.mark(20);
			String line = null;
			while((line = br.readLine()) != null && line.equals("")) {
				count++;
			}		
			br.reset();
		} catch (IOException e) {
			System.out.println("Failure in countLineBreaks");
			e.printStackTrace();
		} 
		return count;
	}
	

	public static void main(String[] args) throws IOException {

	}
}

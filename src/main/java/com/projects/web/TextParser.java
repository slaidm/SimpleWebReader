package com.projects.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class TextParser {

	public Book parseStream(BufferedReader br) throws IOException {
		Book b = new Book();
		
		//printLines(br, 200);
		
		b.setSitemetadata(getSiteMetadata(br));
		b.setMetadata(getMetaData(br));
		//b.setTitle(getTitle(br));
		//b.appendMetadata(getMetaData(br));
		b.setChapters(getChapters(br));
		
		return b;
	}
	
	
	private List<Chapter> getChapters(BufferedReader br) throws IOException {
		List<Chapter> chapters = new LinkedList<>();
		String line = null;
		StringBuilder sb = new StringBuilder("");
		String title = "";
		int lb = countLineBreaks(br);
		int index = 0;
		while((line = br.readLine()) != null && index++ < 12) {
			for(int i = 0; i<lb; i++) {
				line = br.readLine();
			}
			title = line;
			for(int i = 0; (line = br.readLine()) != null; i++) {
				if(line.equals("")){
					if((lb = countLineBreaks(br)) > 5) {
						break;
					} else {
						sb.append("\n");
					}
				} else {
					sb.append(line+"\n");
				}
	
			}
			chapters.add(new Chapter(title, sb.toString(), index));
		}
		return chapters;
	}

	private MetaData getMetaData(BufferedReader br) throws IOException {
		StringBuilder sb = new StringBuilder("");
		List<String> contents = new LinkedList<>();
		String line = null;
		int lb = countLineBreaks(br);
		while((line = br.readLine()) != null) {
			sb.append(line + "\n");
			if(line.toLowerCase().contains("contents")) {
				break;
			}
		}
		while((line = br.readLine())!= null) {
			if(line.equals("")) {
				if((lb = countLineBreaks(br)) == 5) {
					break;
				}
			} else {
				contents.add(line);
			}
		}
		return new MetaData(sb.toString(), contents);
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
			br.mark(30);
			String line = null;
			while((line = br.readLine()) != null && line.equals("")) {
				count++;
			}		
			br.reset();
		} catch (IOException e) {
			//System.out.println("Failure in countLineBreaks");
			//e.printStackTrace();
		} 
		return count;
	}
	
	private void printLines(BufferedReader br, int num) throws IOException {
		String line = null;
		for(int i = 0; i < num && (line=br.readLine()) != null; i++) {
			System.out.println(line);
		}
	}
}

package com.projects.web;

import java.util.LinkedList;
import java.util.List;

public class Book {
	private String title = "";
	private String author = "";
	private SiteMetaData sitemetadata = new SiteMetaData();
	private MetaData metadata = new MetaData();
	private List<Chapter> chapters = new LinkedList<>();
	
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
	public SiteMetaData getSitemetadata() {
		return sitemetadata;
	}
	public void setSitemetadata(SiteMetaData sitemetadata) {
		this.sitemetadata = sitemetadata;
	}
	public MetaData getMetadata() {
		return metadata;
	}
	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(sitemetadata.toString()+"\n");
		sb.append(metadata.toString() + "\n");
		sb.append(title + "\n");
		sb.append(author + "\n");
		for(Chapter c : chapters) {
			sb.append(c.toString());
		}
		return sb.toString();
	}
	public void appendMetadata(MetaData metaData2) {
		this.metadata = new MetaData(this.toString() + metaData2.toString());
	}
	
}

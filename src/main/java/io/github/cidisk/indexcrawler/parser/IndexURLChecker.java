package io.github.cidisk.indexcrawler.parser;

import io.github.cidisk.indexcrawler.CrawlConfig;

import org.htmlcleaner.TagNode;
/*
 * created by Cai Duo
 * 
 * */
public class IndexURLChecker implements NodeChecker{

	private String indexTextPattern;
	private String indexPattern;
	
	public IndexURLChecker(CrawlConfig config){
		indexTextPattern = config.getIndexTextPatternReg();
		indexPattern = config.getIndexPatternReg();
	}

	@Override
	public boolean checkNode(TagNode node) {
		// TODO Auto-generated method stub
		if(null != node){
			
	   	  	String anchorText = node.getText().toString().trim();
	   	  	String url = node.getAttributeByName("href");
	   	  	if(!url.startsWith("http")){
	   	  		url = "http://" + url;
	   	  	}
	   	  	if(anchorText.matches(indexTextPattern) && url.matches(indexPattern)){
	   	  		return true;
	   	  	}	
		}
		return false;
	}
	
	private boolean checkValid(String txt){
		if(null != txt && !txt.isEmpty()){
			return true;
		}
		return false;
	}
	public boolean checkNode(String href,String anchorText) {
		// TODO Auto-generated method stub
		if(checkValid(href) && checkValid(anchorText)){
			

	   	  	if(!href.startsWith("http")){
	   	  		href = "http://" + href;
	   	  	}
	   	  	if(anchorText.matches(indexTextPattern) && href.matches(indexPattern)){
	   	  		return true;
	   	  	}	
		}
		return false;
	}

}

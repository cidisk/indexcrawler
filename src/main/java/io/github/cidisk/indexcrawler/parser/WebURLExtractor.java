package io.github.cidisk.indexcrawler.parser;

import io.github.cidisk.indexcrawler.CrawlConfig;
import io.github.cidisk.indexcrawler.url.WebURL;
import io.github.cidisk.indexcrawler.util.Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.conditional.TagNodeAttNameValueRegexCondition;





/*
 * created by Cai Duo
 * 
 * */
public class WebURLExtractor {
	private static Pattern pattern = initializePattern();


	public WebURLExtractor(CrawlConfig config) {

	}

	public Set<WebURL> extractUrls(String input,short potencial_depth,NodeChecker checker) {
		    Set<WebURL> extractedUrls = new HashSet<>();
		    if (input != null) {
		      //////////// add for node finding
		      HtmlCleaner cleaner = new HtmlCleaner();
			  TagNode root = cleaner.clean(input);
			  Pattern tag = Pattern.compile(".*");
		      TagNodeAttNameValueRegexCondition cond = new TagNodeAttNameValueRegexCondition(tag,pattern);
		      List<? extends TagNode> linkNodes = root.getElementList(cond, true);
		      for(TagNode node : linkNodes){
		    	  if(checker.checkNode(node)){
			    	  String nodePath = Util.getNodePathString(node);
			    	  String anchorText = node.getText().toString().trim();
			    	  String url = node.getAttributeByName("href");
			    	  WebURL webUrl = new WebURL();
			    	  webUrl.setAnchor(node.getName());
			    	  webUrl.setNodePos(nodePath);
			    	  webUrl.setURL(url);
			    	  webUrl.setTag(anchorText);
			    	  webUrl.setDepth(potencial_depth);
			    	  extractedUrls.add(webUrl);
		    	  }

		      }
		    }
		    return extractedUrls;
	 }
	/*public Set<WebURL> extractInfoUrlsByCharacter(String input,short potencial_depth,NodeChecker checker) {
	    Set<WebURL> extractedUrls = new HashSet<>();
	    if (input != null) {
	     // Matcher matcher = pattern.matcher(input);
	      //////////// add for node finding
	      HtmlCleaner cleaner = new HtmlCleaner();
		  TagNode root = cleaner.clean(input);
		  Pattern tag = Pattern.compile(".*");
	      TagNodeAttNameValueRegexCondition cond = new TagNodeAttNameValueRegexCondition(tag,infoPattern);
	      List<? extends TagNode> linkNodes = root.getElementList(cond, true);
	      for(TagNode node : linkNodes){
	    	  if(checker.checkNode(node)){
		    	  String nodePath = Util.getNodePathString(node);
		    	  String anchorText = node.getText().toString().trim();
		    	  String url = node.getAttributeByName("href");
		    	  WebURL webUrl = new WebURL();
		    	  webUrl.setAnchor(node.getName());
		    	  webUrl.setNodePos(nodePath);
		    	  webUrl.setURL(url);
		    	  webUrl.setTag(anchorText);
		    	  webUrl.setDepth(potencial_depth);
		    	  extractedUrls.add(webUrl);
	    	  }

	      }
	    }
	    return extractedUrls;
 }*/

	/** Singleton like one time call to initialize the Pattern */
	private static Pattern initializePattern() {
		return Pattern.compile("\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)"
				+ "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov"
				+ "|mil|biz|info|mobi|name|aero|jobs|museum"
				+ "|travel|[a-z]{2}))(:[\\d]{1,5})?"
				+ "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?"
				+ "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?"
				+ "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)"
				+ "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?"
				+ "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*"
				+ "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");
	}

}

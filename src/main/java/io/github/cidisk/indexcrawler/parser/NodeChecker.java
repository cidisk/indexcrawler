package io.github.cidisk.indexcrawler.parser;

import org.htmlcleaner.TagNode;
/*
 * created by Cai Duo
 * 
 * */
public interface NodeChecker {
	boolean checkNode(TagNode node);
	// return the node path
	boolean checkNode(String href,String anchorText);
}

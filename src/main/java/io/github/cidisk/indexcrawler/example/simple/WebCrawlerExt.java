package io.github.cidisk.indexcrawler.example.simple;
import io.github.cidisk.indexcrawler.Page;
import io.github.cidisk.indexcrawler.WebCrawler;
import io.github.cidisk.indexcrawler.parser.HtmlParseData;
import io.github.cidisk.indexcrawler.url.WebURL;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class WebCrawlerExt extends WebCrawler {

	// public static int cnt = 0;
/*	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g"
					+ "|png|tiff?|mid|mp2|mp3|mp4"
					+ "|wav|avi|mov|mpeg|ram|m4v|pdf"

					+ "|rm|smil|wmv|swf|wma|zip|rar|gz))$");*/
	static long cnter = 1;
	
	
	//该方法设定为只访问符合索引页的过滤
/*	@Override
	public boolean shouldVisit(Page page,WebURL url) {

		 String href = url.getURL().toLowerCase();
         return !FILTERS.matcher(href).matches() && href.startsWith("http://xa.58.com/");

	}*/

	/**
	 * This function is called when a page is fetched and ready to be processed
	 * by your program.
	 */
	@Override
	public void visit(Page page) {
		
		String url = page.getWebURL().getURL();
		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			for(WebURL iurl : page.getParseData().getInfoUrls()){
				if(infoDocIdServer.isSeenBefore(iurl.getURL())){
					System.out.println("Already Seen: "+ iurl.getURL());
				}
				else{
					System.out.println("First Seen: "+ iurl.getURL());
				}
			}

			String html = htmlParseData.getHtml();
			File file = new File("I:\\蔡多论文\\Temp\\"+ cnter +".html");
			System.out.println("File:" + cnter);
			cnter++;
			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
				fw.write(html);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			
			Set<WebURL> outlinks = htmlParseData.getOutgoingIndexUrls();
			Set<WebURL> infolinks = htmlParseData.getInfoUrls();
						
			System.out.println("Page Title:" + htmlParseData.getTitle());
			System.out.println("Current Url:" + url);
			System.out.println("Number of outgoing index links: " + outlinks.size());
			System.out.println("Number of info links: " + infolinks.size());
		}
	}
	
}

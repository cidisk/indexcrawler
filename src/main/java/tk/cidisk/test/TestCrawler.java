package tk.cidisk.test;


import io.github.cidisk.indexcrawler.CrawlConfig;
import io.github.cidisk.indexcrawler.CrawlController;
import io.github.cidisk.indexcrawler.fetcher.PageFetcher;

public class TestCrawler {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String crawlStorageFolder = "I:\\蔡多论文\\Temp";
        int numberOfCrawlers = 5;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setUserAgentString("Baidu Spier");
        config.setIncludeBinaryContentInCrawling(true);
        config.setMaxPagesToFetch(100);
        //config.setIndexPatternReg("http://xa.58.com/chuzu/pn[1-9]+/.*");
        config.setIndexPatternReg("http://hk.88db.com/Property/Residential-for-Lease/[0-9]+/");
        //config.setIndexTextPatternReg("^\\+?[1-9][0-9]*$");
        config.setIndexTextPatternReg("^\\+?[1-9][0-9]*$");
        //config.setInfoPatternReg("http://xa.58.com/zufang/.*\\.shtml");
        config.setInfoPatternReg("http://hk.88db.com/Property/Residential-for-Lease/ad-[0-9]+/");
        config.setDepthOfCrawling((short)2);
        config.setResumableIndexCrawling(false);
        config.setResumableInformationCrawling(true);
        /* Instantiate the controller for this crawl.*/
         
        PageFetcher pageFetcher = new PageFetcher(config);
        CrawlController controller = new CrawlController(config, pageFetcher);
        
        /* For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages*/
         
        //controller.addSeed("http://xa.58.com/chuzu/");
        controller.addSeed("http://hk.88db.com/Property/Residential-for-Lease/1/");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(WebCrawlerExt.class, numberOfCrawlers); 
//        String input = "<html><body><a href=\"good.com\"><font>text</font></a></body></html>";
//        HtmlCleaner cleaner = new HtmlCleaner();
//		  TagNode root = cleaner.clean(input);
//		  Pattern tag = Pattern.compile(".*");
//		  Pattern indexPattern = Pattern.compile("\\w+\\.com");
//	      TagNodeAttNameValueRegexCondition cond = new TagNodeAttNameValueRegexCondition(tag,indexPattern);
//	      List<? extends TagNode> linkNodes = root.getElementList(cond, true); 
//	    System.out.println("Find " +linkNodes.size());
//	      for(TagNode node:linkNodes){
//	    	String url = node.toString();
//	    	System.out.println("row:"+ node.getRow());
//	    	System.out.println("col:"+ node.getCol());
//	    	
//	    	System.out.println("text:"+ node.getText());
//	    	System.out.println("AAAAAA:" + url);
//	    }
	      
	}
}

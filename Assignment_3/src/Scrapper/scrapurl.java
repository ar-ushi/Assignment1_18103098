package Scrapper;
import java.io.*;
import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opencsv.CSVWriter;
import java.util.*;
public class scrapurl {
	public static void main(String[] args) {
		String pathUrl = "allurls.csv",pathText = "text.csv";
		//creating a file obj for file at our csv file
		File fileUrl = new File(pathUrl),fileText = new File(pathText);
		try {
			FileWriter outputUrl = new FileWriter(fileUrl), outputText = new FileWriter(fileText);
			CSVWriter urlWriter = new CSVWriter(outputUrl), textWriter = new CSVWriter(outputText);
			
			//Adding headers to both csv files
			//url csv contains -> url and a text which is the page title
			//text csv contains -> text contained in a tag
			String[] headerUrl = {"Text","URL"}, headerText = {"Tag","Text"};
			urlWriter.writeNext(headerUrl);
			textWriter.writeNext(headerText);
			
			//Adding Data to csv 
			ArrayList<String> visited = new ArrayList<String>(); //list stores all links that we've parsed through
	        Set<String> links = new HashSet<>(); //check if new url is the same as one in set so will be skipped else we go into a infinite loop
	        
	        int count = 0;
	        
	        //Adding first URL - from seed url,crawler looks for all additional links
	        String seedUrl = "http://pec.ac.in";
	        visited.add(seedUrl);
	        links.add(seedUrl);
	        count++;
	        
	        for(int i = 0; i<visited.size();i++) {
	        	try {
	        	//take URL from list
	        	String curr = visited.get(i);
	        	//fetch content
	        	Response resp = Jsoup.connect(curr).timeout(10*1000).execute();
	        	String contentType = resp.contentType();
	        	Document d = resp.parse();
	        	if (contentType != "application/pdf" && contentType != "video/mp4") {
	        	//get title for url csv 
	        	String title = d.title();
	        	System.out.println(title);
	        	String[] data = {"Url: " + (i+1), curr };
	        	System.out.println(data);
	        	urlWriter.writeNext(data);
	        	textWriter.writeNext(data);
	        	textWriter.writeNext(new String[] {"Title: " + title});
	        	
	        	//getting all links
	        	Elements nextLink = d.select("a[href]");
	        	for (Element e : nextLink) {
	        		String url = e.absUrl("href"); //absURL lets us get an entire url from an attribute
	        		String etext = e.text(); 
	        		if (!links.contains(url) && url.contains("https://pec.ac.in/")  && etext.length() >= 1){
	        			//only extracts externals links of images and not pdfs/mp4s 
	        			//System.out.println(url); 
	        			//System.out.println(url + "&" + etext);
	        			String[] textData = {etext,url};
	        			urlWriter.writeNext(textData);
	        			visited.add(url);
	        			links.add(url);
	        			count++;
	        		}
	        }
        	/*Elements atag = d.select("a");
 	        for (Element a : atag) {
 	        	String text = a.text();
 	        	if (text.length() >= 1) {
 	        		//only scrape text if present else don't 
 	        		System.out.println("a : " + text);
 	        		textWriter.writeNext(new String[] {"a", text});
 	        }
 	        }*/
	        //getting all tags containing <p> 
	        	
	        Elements ptag = d.select("p");
	        for (Element p : ptag) {
	        	
	        	String text = p.text();
	        	if (text.length() >= 1) {
	        		//only scrape text if present else don't 
	        		System.out.println("p : " + text);
	        		textWriter.writeNext(new String[] {"p", text});
	        }
	        	
	        	}
	        

	        
	       //getting tags for img - since ignoring img type is causing csv to have special characters
	        //Same method can be followed for all tags. Did img because during scraping textcsv had special characters which was actually due to wrong url
	        Elements imgtag = d.select("img");
	        for (Element img : imgtag) {
	        	String text = img.text();
	        	String url = img.attr("src");
	        	System.out.println("Source url :" + url);
	        	if (text.length()>0 && url.length()>0) {
	        		textWriter.writeNext(new String[] {"img", url});
	        	}
	        }
	        }else {
	        	continue;
	        }
	        
		}
	        	catch (IOException e) {
        	System.out.println(e);
        	}
	        	if (i == 200) {
	        	//capping it off at 200 because entire website takes an extensive time to scrap
	        		urlWriter.writeNext(new String[] {"Total URLS :" + count} );
	        		break;
	        	}
	        }
	        
	        textWriter.close();
	        urlWriter.close();
		
		} 
		 catch (IOException e) {
	        
				e.printStackTrace();
			}
		}
}
	



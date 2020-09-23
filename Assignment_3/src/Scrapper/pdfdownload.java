package Scrapper;
import java.io.*;
import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opencsv.CSVWriter;
import java.util.*;

public class pdfdownload{
	public static void main(String[] args) {
		String pathUrl = "pdfs.csv";
		//creating a file obj for file at our csv file
		File fileUrl = new File(pathUrl);
		try {
			FileWriter outputUrl = new FileWriter(fileUrl);
			CSVWriter urlWriter = new CSVWriter(outputUrl);
			
			//Adding headers to both csv files
			//url csv contains -> url and a text which is the page title
			//text csv contains -> text contained in a tag
			String[] headerUrl = {"URL"};
			ArrayList<String> visited = new ArrayList<String>(); //list stores all links that we've parsed through
	        Set<String> links = new HashSet<>(); //check if new url is the same as one in set so will be skipped else we go into a infinite loop
	        Set<String> pdf = new HashSet<>();
	        int count = 0;
	        String seedUrl = "http://pec.ac.in";
	        visited.add(seedUrl);
	        links.add(seedUrl);
	        
	        count++;
	        for(int i = 0; i<visited.size();i++) {
	        	try {
	        		String curr = visited.get(i);
	        		Document d = Jsoup.connect(curr).get();
	        		Elements nextLink = d.select("a[href]");
	        		for (Element e : nextLink) {
	        			String url = e.absUrl("href"); //absURL lets us get an entire url from an attribute
		        		String etext = e.text(); 
		        		if (!links.contains(url) && url.contains("https://pec.ac.in/")  && etext.length() >= 1){
		        			if ((url.endsWith(".pdf") || url.endsWith(".mp4") || url.endsWith(".txt") || url.endsWith(".docx")) && !pdf.contains(url)){
		        				System.out.println(url);
		        				String[] textData = {url};
		        				urlWriter.writeNext(textData);
		        				pdf.add(url);
		        			}
		        			else {
		        				visited.add(url);
		        		        links.add(url);
		        		        
		        		        count++;
		        			}
		        		}
	        		}
	        		
	        	}catch (IOException e) {
	        		e.printStackTrace();
	        		
	        	}
	        	if (i == 100) { //capping it off at 100 for test demo 
	        		urlWriter.writeNext(new String[] {"Total URLS :" + count} );
	        		break;
	        	}
	        	
	        }
	        urlWriter.close();
			
	}catch (IOException e) {
		e.printStackTrace();
	}
}
}
package Scrapper;
import java.io.*;
import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opencsv.CSVWriter;
import java.util.*;

public class focusedcrawl{
	public static void main(String[] args) {
		String pathUrl = "facurls.csv",pathText = "factext.csv";
		//creating a file obj for file at our csv file
		File fileUrl = new File(pathUrl),fileText = new File(pathText);
		try {
			FileWriter outputUrl = new FileWriter(fileUrl), outputText = new FileWriter(fileText);
			CSVWriter urlWriter = new CSVWriter(outputUrl), textWriter = new CSVWriter(outputText);
			String[] headerUrl = {"Text","URL"}, headerText = {"Tag","Text"};
			urlWriter.writeNext(headerUrl);
			textWriter.writeNext(headerText);
			
			//Adding Data to csv 
			ArrayList<String> visited = new ArrayList<String>(); //list stores all links that we've parsed through
	        Set<String> links = new HashSet<>(); //check if new url is the same as one in set so will be skipped else we go into a infinite loop
	        Set<String> faculty = new HashSet<>();
	        int count = 0;
	        int depth = 1;
	        //depth first search
	        
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
		        		if (etext.length() != 0) {
		        			
		        			if (!links.contains(url) && url.contains("https://pec.ac.in/")){
		        				count++;
		        				visited.add(url);
		        				links.add(url);
		        				
		        			if ((url.contains("faculty")) && !faculty.contains(url)){
		        				System.out.println(url);
		        				String[] textData = {url};
		        				//urlWriter.writeNext(textData);
		        				faculty.add(url);
		        			}
		        			else {
		        				visited.add(url);
		        		        links.add(url);
		        		        
		        		        count++;
		        			}
		        		}
		        		}
	        		}
	        		
	        	}catch (IOException e) {
	        		e.printStackTrace();
	        		
	        	}
	        	if (i == 100) { //capping it off at 100 for test demo 
	        		//urlWriter.writeNext(new String[] {"Total URLS :" + count} );
	        		break;
	        	}
	        	
	        }
	        
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
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
		String pathUrl = "facurls.csv";
		//creating a file obj for file at our csv file
		File fileUrl = new File(pathUrl);
		try {
			FileWriter outputUrl = new FileWriter(fileUrl);
			CSVWriter urlWriter = new CSVWriter(outputUrl);
			ArrayList<String> ar = new ArrayList<String>();     
	        String seedUrl = "http://pec.ac.in/faculty-index"; //observe that each university has an index where they store all faculty details so seed url needs to be changed only
	        		try {
	        		Document d = Jsoup.connect(seedUrl).get();
	        		Element table = d.select("table").get(0);
	        		Elements rows =  table.select("tr");
	        		/*Elements ths =  table.select("th");
	        		for (Element th : ths) {
	        			String etext = th.text(); 
		        		if (etext.length() >= 1) {
		        			ar.add(etext);
		        			}
	        		}
	        		String[] headerUrl = new String[ar.size()];
	        		//specifically for pec.
	        		ar.remove(0);
	        		headerUrl = ar.toArray(headerUrl);
	        		urlWriter.writeNext(headerUrl);*/   //column name code
	        		
	        		for (Element row : rows) {
	        			Elements tds = row.select("td");
	        			for (Element td : tds) {
	        				ArrayList<String> visited = new ArrayList<String>();
	        				String tdt = td.text();
	        				if (tdt.length()>=1) {
	        					visited.add(tdt);
	        				}
	        				String[] textstore = new String[visited.size()];
	        				textstore = visited.toArray(textstore);
	        				urlWriter.writeNext(textstore);
	        			}
	        			
	        			System.out.println(tds.text());
	        			
	        		}
	        	
	        			urlWriter.close();
		        			
	        		} catch (IOException e) {
	        		e.printStackTrace();
	        		
	        	}
	        
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
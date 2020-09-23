package Scrapper;
import java.io.*;
import com.opencsv.CSVReader;
import java.util.*;
import java.net.URL;
import java.net.URLConnection;
public class download{
	public static void main(String[] args) {
		try {
			String file = "pdfs.csv";
			FileReader filereader = new FileReader(file);
			CSVReader urlReader = new CSVReader(filereader);
			String[] records;
			int slashIndex;
			int dotIndex;
			 while ((records = urlReader.readNext()) != null) {
				 for (String url : records) {
					 System.out.println(url);
					 String extn = url.substring(url.lastIndexOf('/')+1,url.length());
					 //String filename = extn.substring(0, extn.lastIndexOf('.'));
					 System.out.println(extn);
					 download(url,new File(extn));
				 }
			 }
		} catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	}
	public static void download (final String url,final File dest) throws IOException{
		final URLConnection conn = new URL(url).openConnection();
		conn.setConnectTimeout(60000);
		conn.setReadTimeout(60000);
		conn.addRequestProperty("User-Agent", "Mozilla/5.0");
		final FileOutputStream output = new FileOutputStream(dest,false);
		final byte[] buffer = new byte[2048];
		int read;
		final InputStream input = conn.getInputStream();
        while((read = input.read(buffer)) > -1)
        	output.write(buffer,0,read);
        output.flush();
        output.close();
        input.close();
	}
}
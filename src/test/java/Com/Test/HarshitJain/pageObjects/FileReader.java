package Com.Test.HarshitJain.pageObjects;

import java.io.File;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
//import com.opencsv.CSVParser;
//import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class FileReader {
static File file;
	
	static String CSVfile = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData"+File.separator+"SampleCSV3.csv";
	public FileReader(File file) {
		this.file=file;
	}
	
	public FileReader() {
	}
	
	public static List<String[]> fetchDataFromCsv(){ 
	 try {
	        // Create an object of file reader class with CSV file as a parameter.
	        FileReader filereader = new FileReader(file);
	 
	        // create csvParser object with
	        // custom separator semi-colon
	        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
	 
	        // create csvReader object with parameter
	        // filereader and parser
	        CSVReader csvReader = new CSVReaderBuilder(filereader)
	                                  .withCSVParser(parser)
	                                  .build();
	 
	        // Read all data at once
	        List<String[]> allData = csvReader.readAll();
	 
	        // Print Data.
	        for (String[] row : allData) {
	            for (String cell : row) {
	                System.out.print(cell + "\t");
	            }
	            System.out.println();
	        }
	        return allData;
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	//newCustmerPreApproved, age
	public static String getUserTypeDetails(String usertype, String userDetails){
	//it will return me row of user and required
		String columnValue = null;
		file=new File(CSVfile);
		List<String []> userData = fetchDataFromCsv();
		int cellCount=0;
		String [] header_row= userData.get(0) ;
			for (String cell : header_row) {
				if(cell.equals(userDetails)) {
					break;
				}
				cellCount++;
		}
		
		for(String [] user_row: userData) {
			if(user_row[0].equals(usertype)) {
				columnValue=user_row[cellCount];
			}
		}
		
		
		
		return columnValue;
	}
	
	public static void main(String arg[]) {
		System.out.println("output>>>"+FileReader.getUserTypeDetails("1","Product name"));
	}


}

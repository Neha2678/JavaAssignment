package readFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import recordMapper.recordCsv;

public class readCsvFile {
	static List<recordCsv> records = new ArrayList<>();
	//private static final Date  = null;
	public static void main(String[] args) throws Exception
    {
		readCsvFile rCsv = new readCsvFile();
		rCsv.readRecordsfromCsv();
        
    }
	
	public static List<recordCsv> readRecordsfromCsv() throws FileNotFoundException, ParseException
	{
		readCsvFile rCsv = new readCsvFile();
	
		//List<recordCsv> records = new ArrayList<>();
		// File path is passed as parameter
        File file = new File(
            "C:\\Users\\NehaJ6\\Downloads\\complaints.csv");
 
       // String[] attributes;
        
 
        // Creating an object of BufferedReader class
        BufferedReader br
            = new BufferedReader(new FileReader(file));
 
        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        try {
			while ((st = br.readLine()) != null)
			{
				String attributes[] = st.split(",");
			    // Print the string
				recordCsv addRec = rCsv.Save_in_collection(attributes);
				//System.out.println(addRec);
				
					records.add(addRec);
				
					// TODO Auto-generated catch block
					
			   //System.out.println(records);
		}
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}
	//Saving it in list
	private recordCsv Save_in_collection(String metadata[]) throws ParseException
	{
		//Issue on reading date so converted to string
			String Datereceived = metadata[0];
		
		

		String  Product = metadata[1];
		String Sub_product = metadata[2];
		String Issue = metadata[3];
		String Sub_issue = metadata[4];
		String Company = metadata[5];
		 String State = metadata[6];
		 String ZIP_code =  metadata[7];
		 String Submitted_via = metadata[8];
		
		String  Date_closed = metadata[9];
		
		 String Company_response = metadata[10];
		 String Timely_response = metadata[11];
		 String Consumer_disputed = metadata[12];
		  String Complaint_ID = metadata[13];

		  //return null;
		  
		return new recordCsv(Datereceived,Product,Sub_product,Issue,Sub_issue,Company,State,ZIP_code,Submitted_via,Date_closed,Company_response,Timely_response,Consumer_disputed, Complaint_ID);
		
	}
	//Throwing error don't have time to rectify
	
	
	/*public static List<recordCsv> Fetch_by_Id(String  Complaint_ID) {
		return records.stream().filter(c -> c.getComplaint_ID()).equals( Complaint_ID).collect(Collectors.toList());
	}
	
	public static List <recordCsv> FetchByBankName(String bankName) {
		return records.stream().filter(c -> c.getCompany()).equals(bankName)).collect(Collectors.toList());
	}
*/
}

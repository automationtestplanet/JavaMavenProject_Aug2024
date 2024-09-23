package demo.file.operations;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonOperations {

	public void readDataFromJson(String filePath) {

		try {
			JSONParser jParse = new JSONParser();
			FileReader jsonFile = new FileReader(filePath);
			JSONObject jObject = (JSONObject)jParse.parse(jsonFile);
			
			System.out.println(jObject.toString());
			
			System.out.println(jObject.get("userName"));
			System.out.println(jObject.get("password")); 
			
		} catch (Exception e) {
			System.out.println("Exception Occured while read data from Json: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		String josnFilePah = System.getProperty("user.dir") + "\\src\\main\\resources\\UserDetails.json";
		
		JsonOperations json = new JsonOperations();
		json.readDataFromJson(josnFilePah);

	}

}

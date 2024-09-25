package demo.file.operations;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ObjectMapperToReadDataFromFiles {

	public UserDetails readDataFromJson(String filePath) {
		try {
			ObjectMapper objMapper = new ObjectMapper();
			UserDetails userDetails = objMapper.readValue(Paths.get(filePath).toFile(), UserDetails.class);
			System.out.println(userDetails.getUserName());
			System.out.println(userDetails.getPassword());
			return userDetails;
		} catch (Exception e) {
			System.out.println("Exception Occured while read data from Json: " + e.getMessage());
			return null;
		}
	}

	public Credentials readDataFromXml(String filePath) {
		try {
			ObjectMapper xmlMapper = new XmlMapper();
			Credentials credentials = xmlMapper.readValue(Paths.get(filePath).toFile(), Credentials.class);
			System.out.println(credentials.getUserName());
			System.out.println(credentials.getPassword());
			return credentials;
		} catch (Exception e) {
			System.out.println("Exception Occured while read data from MXL: " + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		String josnFilePah = System.getProperty("user.dir") + "\\src\\main\\resources\\UserDetails.json";
		ObjectMapperToReadDataFromFiles objMapper = new ObjectMapperToReadDataFromFiles();
		objMapper.readDataFromJson(josnFilePah);

		String xmlFilePah = System.getProperty("user.dir") + "\\src\\main\\resources\\Credentials.xml";
		objMapper.readDataFromXml(xmlFilePah);
	}
}

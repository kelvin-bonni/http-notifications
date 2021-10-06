package com.pangaea.pangaeaassesssment.utilities;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtility {
	public static String toJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}		
		return json;
	}

	public static <T> T fromJson(String json, Class<T> valueType) {
		ObjectMapper mapper = new ObjectMapper();
		T t = null;
		try {
			t = mapper.readValue(json, valueType);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public static String mapToJson(Map<String, String> accountsMap) {
		String json = "";
		try {

			ObjectMapper mapper = new ObjectMapper();

			json = mapper.writeValueAsString(accountsMap);
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(accountsMap);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public static Map<String, String> jsonToMapKeyAsString(String json) {
		Map<String, String> map = new HashMap<String, String>();
		try {

			ObjectMapper mapper = new ObjectMapper();
			map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}

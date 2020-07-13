package models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class JsonConverter {

	@SuppressWarnings("unchecked")
	public static JSONObject userToJson(User user) {
		JSONObject obj = new JSONObject();
		String tempString = "";
		int tempInt = 0;

		tempString = user.getName();
		if(tempString != null && tempString.trim().length() > 0)
			obj.put("name", tempString);
		
		tempString = user.getSurname();
		if(tempString != null && tempString.trim().length() > 0)
			obj.put("surname", tempString);
		
		tempString = user.getTypeString();
		if(tempString != null && tempString.trim().length() > 0)
			obj.put("type", tempString);
		
		tempInt = user.getId();
		obj.put("id", new Integer(tempInt));
		
		tempInt = user.getAge();
		obj.put("age", new Integer(tempInt));
		
		Date tempDate = user.getBirthDate();
		if(tempDate != null)
			obj.put("birthdate", tempDate);
		
		Timestamp tempTimestamp = user.getCreationTimestamp();
		if(tempTimestamp != null)
			obj.put("timestamp", tempTimestamp);
		
		return obj;
	}
	
	public static User jsonToUser(JSONObject json) {
		User user = new User();
		String tempString = "";
		int tempInt = 0;
		
		if(json.containsKey("name")) {
			tempString = json.get("name").toString();
			user.setName(tempString);
		}
		
		if(json.containsKey("surname")) {
			tempString = json.get("surname").toString();
			user.setSurname(tempString);
		}
		
		if(json.containsKey("type")) {
			tempString = json.get("type").toString();
			user.setType(User.charStrToEnum(tempString));
		}
		
		if(json.containsKey("id")) {
			tempInt = Integer.parseInt(json.get("id").toString());
			user.setId(tempInt);
		}
		
		if(json.containsKey("age")) {
			tempInt = Integer.parseInt(json.get("age").toString());
			user.setAge(tempInt);
		}
		
		if(json.containsKey("birthdate")) {
			Date tempDate = (Date) json.get("birthdate");
			user.setBirthDate(tempDate);
		}
		
		if(json.containsKey("timestamp")) {
			Timestamp tempTimestamp = (Timestamp) json.get("timestamp");
			user.setCreationTimestamp(tempTimestamp);
		}
		return user;
	}
	
	public static List<JSONObject> usersToJson(List<User> users) {
		List<JSONObject> jsons = new ArrayList<JSONObject>();
		
		for (User user : users) {
			jsons.add(user.getJsonObj());
		}
		
		return jsons;
	}
	
	public static List<User> jsonsToUsers(List<JSONObject> jsons) {
		List<User> users = new ArrayList<User>();
		
		for (JSONObject json : jsons) {
			users.add(jsonToUser(json));
		}
		
		return users;
	}
}

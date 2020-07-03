package models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class User {
	public static enum eType{
		CHILD,
		OWNER,
		SPOUSE
	}
	
	private int id;
	private String name;
	private String surname;
	private Date birthDate;					//This is the sql Date
	private Timestamp creationTimestamp;	//This is the sql Timestamp
	private int age;
	private eType type;
	
	public User(int id, String name, String surname, Date birthDate, Timestamp creationTimestamp, int age, eType type) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.creationTimestamp = creationTimestamp;
		this.age = age;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}
	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public eType getType() {
		return type;
	}
	public void setType(eType type) {
		this.type = type;
	}
	
	/**
	 * Converts the birthdate into the string parseable by default by the database
	 * @return Birthdate as yyyy-MM-dd
	 */
	public String getStandardDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(birthDate);
	}
	
	/**
	 * Converts the user type into a 1-letter String accepted by the database
	 * @return 1-letter string equivalent to the type
	 */
	public String getTypeString() {
		String ret = "";
		switch (type) {
		case OWNER:
			ret = "O";
			break;
			
		case SPOUSE:
			ret = "S";
			break;
			
		case CHILD:
			ret = "C";
			break;
		default:
			break;
		}
		return ret;
	}
	
	/**
	 * Convert the 1-letter type from the database to the equivalent user type
	 * @param chr 1-letter string for the DB user type
	 * @return enum for the java user type
	 */
	public static eType charStrToEnum(String chr) {
		if(chr.length() != 1)
			return null;
		
		eType type = null;
		switch (chr.toUpperCase()) {
		case "C":
			type = eType.CHILD;
			break;
			
		case "O":
			type = eType.OWNER;
			break;
			
		case "S":
			type = eType.SPOUSE;
			break;

		default:
			break;
		}
		return type;
	}
}

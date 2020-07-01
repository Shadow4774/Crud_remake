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
	private Date birthDate;
	private Timestamp creationTimestamp;
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
	
	public String getStandardDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(birthDate);
	}
	
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

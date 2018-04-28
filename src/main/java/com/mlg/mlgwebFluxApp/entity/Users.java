/**
 * 
 */
package com.mlg.mlgwebFluxApp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author darshan
 *
 */
@Document( collection = "users" )
public class Users implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 977642042148679696L;

	@Id
	private int id;
	private String name;
	private String age;
	
	public Users() { }
	
	public Users(String name, String age) {
		this.name = name;
		this.age = age;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id= " + this.id + ", name= " + this.name + ", age= " + this.age + "]";
	}
}

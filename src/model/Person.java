package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String username;

	private String address;

	private String email;

	private String name;

	private String password;

	private String phone;

	private String surname;

	//bi-directional many-to-one association to Diary
	@OneToMany(mappedBy="person")
	private Set<Diary> diaries;

	public Person() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<Diary> getDiaries() {
		return this.diaries;
	}

	public void setDiaries(Set<Diary> diaries) {
		this.diaries = diaries;
	}

	public Diary addDiary(Diary diary) {
		getDiaries().add(diary);
		diary.setPerson(this);

		return diary;
	}

	public Diary removeDiary(Diary diary) {
		getDiaries().remove(diary);
		diary.setPerson(null);

		return diary;
	}

}
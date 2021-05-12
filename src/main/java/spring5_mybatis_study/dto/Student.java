package spring5_mybatis_study.dto;

import java.util.Date;

public class Student {
	private int studId;
	private String name;
	private String email;
	private PhoneNumber phone;
	private Date dob;
	private Address address;
	private Gender gender;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return String.format("Student [studId=%s, name=%s, email=%s, phone=%s, dob=%s, address=%s, gender=%s]", studId,
				name, email, phone, dob, address, gender==Gender.FEMALE?"여자":(gender==Gender.MALE?"남자":"없음"));
	}

}
